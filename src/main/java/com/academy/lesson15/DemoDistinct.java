package com.academy.lesson15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class DemoDistinct {
    public static void main(String[] args) {
        Subscriber[] subscrArr = new Subscriber[100];
        fillSubscribers(subscrArr);
        Arrays.stream(subscrArr)
//                .filter(s->s.getAge() >= 20 && s.getAge() <= 30)
                .filter(distinct(Subscriber::getAge))
                .sorted(Comparator.comparing(Subscriber::getAge))
                .forEach(System.out::println);
    }

    private static Predicate<Subscriber> distinct(Function<Subscriber, Object> propExtractor) {
        Set<Object> distinctByAge = new HashSet<>();
        return s-> distinctByAge.add(propExtractor.apply(s));
    }

    private static void fillSubscribers(Subscriber[] subscrArr){

        String[] names = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris",
                "Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris",
                "Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris",
                "Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris"};

        String[] lastNames = {"Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov",
                "Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov",
                "Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov",
                "Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov"};

        long id = 0L;
        for (int i = 0; i < subscrArr.length; i++) {
            id++;
            int nameIndex = (int) (Math.random() * names.length);
            String name = names[nameIndex];
            String lastName = lastNames[nameIndex];
            int age = (int) (18 + Math.random() * 42);
            String phoneNumber = fillPhoneNumber();
            subscrArr[i] = new Subscriber(id, name, lastName, age, phoneNumber);
        }
    }

    private static String fillPhoneNumber(){

        String phoneNumberPrefix = "999";
        StringBuilder phoneNumber = new StringBuilder(phoneNumberPrefix);

        for (int i = 0; i < 8; i++){
            int number = (int) (Math.random()*9);
            phoneNumber.append(number);
        }

        return phoneNumber.toString();
    }
}
