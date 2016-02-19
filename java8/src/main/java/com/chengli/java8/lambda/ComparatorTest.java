package com.chengli.java8.lambda;

import com.chengli.java8.lambda.base.Name;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chengli on 2016/1/27.
 */
public class ComparatorTest {

    private static final Name[] NAMES = new Name[]{
            new Name("Sally", "Smith"), new Name("Li", "Cheng"), new Name("haha", "wawa"),new Name("Queue", "Queue")};

    private static void printNames(String caption, Name[] names) {
        System.out.println(caption);
        for (Name name : names) {
            System.out.print(name + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Name[] copy = Arrays.copyOf(NAMES, NAMES.length);
        Comparator<Name> comp = Comparator.comparing(name -> name.getLastName());
        comp =comp.thenComparing(name -> name.getFirstName());
        Arrays.sort(copy, comp);
        printNames("Names sorted with key extractor comparator:", copy);

        // sort array using existing methods as lambdas
        copy = Arrays.copyOf(NAMES, NAMES.length);
        comp = Comparator.comparing(Name::getLastName).thenComparing(Name::getFirstName);
        Arrays.sort(copy, comp);
        printNames("Names sorted with existing methods as lambdas:", copy);
    }
}
