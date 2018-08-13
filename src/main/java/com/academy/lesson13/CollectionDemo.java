package com.academy.lesson13;

import java.util.*;
import java.util.Map.Entry;

public class CollectionDemo {
    public static void main(String[] args) {
//        listDemo();
//        mapDemo();
//        sortDemo();
        foreachDemo();
    }

    private static void foreachDemo() {
        Group group = new Group();
        group.add(new Person(1L, "Peter", 20));
        group.add(new Person(4L, "Helen", 25));
        group.add(new Person(6L, "Ivan", 43));

        for(Person p : group)
            System.out.println(p);
    }

    private static void sortDemo() {
        System.out.println("**********Sort Demo***********");

        System.out.println("***String***");
        List<String> listStr = new ArrayList<>();
        listStr.add("one");
        listStr.add("two");
        listStr.add("next");
        listStr.add("previous");
        listStr.add("bye bye");
        System.out.println(listStr);
        Collections.sort(listStr);
        System.out.println(listStr);

        System.out.println("***Person***");
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person(1L, "Vasya", 25));
        listPerson.add(new Person(77L, "Kolya", 54));
        listPerson.add(new Person(77L, "Kolya3", 55));
        listPerson.add(new Person(2L, "Helen", 23));
        listPerson.add(new Person(24L, "Yana", 18));
        listPerson.add(new Person(717L, "Kolya2", 54));

        System.out.println(listPerson);
        Collections.sort(listPerson);
        System.out.println();
        System.out.println(listPerson);

        System.out.println("Custom person");
//        Collections.sort(listPerson, new CustomPersonSort());
//        System.out.println(listPerson);

        listPerson.sort(new CustomPersonSort());
        System.out.println(listPerson);
    }

    private static void mapDemo() {
        Map<Long, Person> map = new HashMap<>();

        map.put(1L, new Person(1L, "Vasya", 25));
        map.put(2L, new Person(2L, "Helen", 23));
        map.put(77L, new Person(77L, "Kolya", 54));

        map.put(1L, new Person(1L, "Vanya", 33));

        System.out.println(map);

        System.out.println("*****MAP 1*******");
        for (Long key : map.keySet()) {
            System.out.println("key =" + key );
            System.out.println("value =" + map.get(key) );
        }

        System.out.println("*****MAP 2*******");
        for (Entry<Long, Person> entry: map.entrySet()) {
            System.out.println("key =" + entry.getKey() );
            System.out.println("value =" + entry.getValue() );
        }
    }

    private static void listDemo() {
        List<String> listStr = new ArrayList<>();
        System.out.println(listStr.size());
        System.out.println(listStr);

        listStr.add("one");
        listStr.add("two");
        listStr.add("next");

        System.out.println(listStr.size());
        System.out.println(listStr);

        System.out.println(listStr.contains("two"));
        System.out.println(listStr.contains("three"));

        listStr.add(1, "hello");
        System.out.println(listStr);

        listStr.set(1, "Hello world!");
        System.out.println(listStr);

        List<Integer> listInt = new ArrayList<>(Arrays.asList(1, 4, 5, 6));
        System.out.println(listInt);

        for (int i = 0; i < listInt.size(); i++) {
            System.out.println("1) listInt element:" + listInt.get(i));
        }

        for (Integer el : listInt) {
            System.out.println("2) listInt element:" + el);
        }
    }
}
