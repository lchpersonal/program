package com.chengli.java8.stream.old;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by chengli on 2016/1/28.
 */
public class
Test {

    public static void main(String[] args) {
        //List<User> users = Stream.of();
    }


    private static class User{
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
