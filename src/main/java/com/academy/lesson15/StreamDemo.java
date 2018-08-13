package com.academy.lesson15;

import com.academy.lesson13.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.academy.lesson14.DemoMain.fillPersonsRandom;

public class StreamDemo {
    public static void main(String[] args) {
//        notStream();
//        stream();
//        streamPerson();
//        streamCollect();
//        streamToArray();
//        streamReduce();
        streamSubtract();

    }

    private static void streamSubtract() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        long sum = Arrays.stream(personArr)
                .mapToLong(Person::getId)
                .map(id-> -id)
                .sum();

        System.out.println(sum);
    }

    private static void streamReduce() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        String result =
                Arrays.stream(personArr)
                        .limit(10)
                        .map(Person::getName)
                        .reduce((name1, name2)-> name1 + ":" + name2).orElse("Nothing");
        System.out.println(result);
    }

    private static void streamToArray() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        List<Person> personList = Arrays.asList(personArr);

        long[] idArr = personList.stream()
                .limit(10)
                .mapToLong(Person::getId)
                .toArray();

        String[] names =
                personList.stream()
                        .limit(10)
                        .map(Person::getName)
                        .toArray(String[]::new);

        System.out.println(Arrays.toString(names));
    }

    private static void streamCollect() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        List<Person> personList =
                Arrays.stream(personArr)
                        .filter(p->p.getAge() >= 20 && p.getAge() <= 30)
                        .sorted(Comparator.comparing(Person::getName))
                        .collect(Collectors.toList());

        System.out.println(personList);
    }

    private static void streamPerson() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        Arrays.stream(personArr)
                .filter(p->p.getAge() >= 20 && p.getAge() <= 30)
//                .sorted((p1, p2)->p1.getName().compareTo(p2.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    private static void stream() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        List<Person> personList = Arrays.asList(personArr);
        //Arrays.stream(personArr).forEach(System.out::println);
        personList.stream()
                .filter(p-> p.getAge() >= 20 && p.getAge() <= 50)
                .filter(p->p.getName().startsWith("A"))
                .forEach(System.out::println);

        // Вывести на экран только id
        personList.stream()
                .filter(p-> p.getAge() >= 20 && p.getAge() <= 50)
                .filter(p->p.getName().startsWith("A"))
//                .map(p->p.getId()).forEach(System.out::println);
                .map(Person::getId)
                .peek(System.out::println)
                .forEach(id-> System.out.println("ID = " + id));
    }

    private static void notStream() {
        Person[] personArr = new Person[50];
        fillPersonsRandom(personArr);
        List<Person> personList = Arrays.asList(personArr);


        // 1 sort
        personList.sort((p1, p2)->p1.getName().compareTo(p2.getName()));
//        personList.sort(Comparator.comparing(Person::getName));
        // 2 filter
//        for (int i = 0; i < personList.size(); i++) {
//            System.out.println(personList.get(i));
//        }

        for (Person p : personList) {
            if (p.getAge()> 20 && p.getAge() < 50){
                System.out.println(p);
            }
        }
    }
}
