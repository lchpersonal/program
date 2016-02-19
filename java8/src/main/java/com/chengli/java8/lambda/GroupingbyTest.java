package com.chengli.java8.lambda;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chengli on 2016/1/28.
 */
public class GroupingbyTest {

    public static void main(String[] args) {
        Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
                limit(100).collect(Collectors.groupingBy(Person::getAge));
        Iterator it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
            System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
        }
    }

    private static class PersonSupplier implements Supplier<Person> {
        private int index = 0;
        private Random random = new Random();

        @Override
        public Person get() {
            return new Person(index++, "StormTestUser" + index, random.nextInt(100));
        }
    }

    private static class Person {
        private int no;
        private int age;
        private String name;

        public Person(int no, String name, int age) {
            this.no = no;
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getNo() {
            return no;
        }
    }
}
