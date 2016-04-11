package com.cl.test.prime;

/**
 * Created by chengli on 2016/4/11.
 */
public class PrimeCounter {


    public static void main(String[] args) {
        int n = 100000000;
        boolean[] datas = new boolean[n];
        int counter = 0;
        long begin = System.currentTimeMillis();
        for (int i = 3; i < 10000; i = i + 2) {
            if (!datas[i]) {
                for (int j = 3; j < n / i; j++) {
                    if (i * j % 2 != 0 && !datas[i * j]) {
                        datas[i * j] = true;
                        counter++;
                    }
                }
            }
        }
        System.out.println(50000000 - counter);
        System.out.println(String.format("cost %s ms", (System.currentTimeMillis() - begin)));
    }
}
