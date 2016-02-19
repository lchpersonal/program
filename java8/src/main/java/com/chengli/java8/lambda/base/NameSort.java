package com.chengli.java8.lambda.base;

import java.util.Arrays;
import java.util.Comparator;

public class NameSort {

    private static final Name[] NAMES = new Name[]{
            new Name("Sally", "Smith"), new Name("Li", "Cheng"), new Name("haha", "wawa")};

    private static void printNames(String caption, Name[] names) {
        System.out.println(caption);
        for (Name name : names) {
            System.out.print(name + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // sort array using anonymous inner class
        Name[] copy = Arrays.copyOf(NAMES, NAMES.length);
        Arrays.sort(copy, new Comparator<Name>() {
            public int compare(Name a, Name b) {
                return a.compareTo(b);
            }
        });
        printNames("Names sorted with anonymous inner class:", copy);

        // sort array using lambda expression
        copy = Arrays.copyOf(NAMES, NAMES.length);
        Arrays.sort(copy, (a, b) -> a.compareTo(b));
        printNames("Names sorted with lambda expression:", copy);
    }
}