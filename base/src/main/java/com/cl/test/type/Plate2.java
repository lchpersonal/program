package com.cl.test.type;

import java.util.ArrayList;
import java.util.List;

public class Plate2 {

    List<Object> eggs = new ArrayList<Object>();

    public synchronized Object getEgg() {

        while (eggs.size() == 0) {

        }
        Object egg = eggs.get(0);
        eggs.clear();// 清空盘子
        System.out.println("拿到鸡蛋");
        return egg;
    }

    public synchronized void putEgg(Object egg) {
        while (eggs.size() > 0) {
        }
        eggs.add(egg);// 往盘子里放鸡蛋
        System.out.println("放入鸡蛋");
    }

    static class AddThread extends Thread {
        private Plate plate;
        private Object egg = new Object();

        public AddThread(Plate plate) {
            this.plate = plate;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                plate.putEgg(egg);
            }
        }
    }

    static class GetThread extends Thread {
        private Plate plate;

        public GetThread(Plate plate) {
            this.plate = plate;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                plate.getEgg();
            }
        }
    }

    public static void main(String args[]) {
        try {
            Plate plate = new Plate();
            Thread add = new Thread(new AddThread(plate));
            Thread get = new Thread(new GetThread(plate));
            add.start();
            get.start();
            add.join();
            get.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结束");
    }
}