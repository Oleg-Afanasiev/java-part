package com.academy.lesson14;

import com.academy.lesson13.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class DemoMain {
    public static void main(String[] args) {
        //personExr();
        lambda();
    }

    private static void lambda() {
        System.out.println("*****Lambda*****");
        String[] names = {"Peter", "helen", "Andry", "abdel", "Kate", "veronica", "Leonid", "Alex", "Max"};

        System.out.println("---toUpperCase---");
        for (String name : names) {
            System.out.println(actionWithString(name, String::toUpperCase));
        }

        System.out.println("---firstLetterToUpperCase---");
        for (String name : names) {
            System.out.println(actionWithString(name,
//                    s-> String.valueOf(Character.toUpperCase(s.charAt(0))) + s.substring(1)));
                    s-> s.substring(0, 1).toUpperCase() + s.substring(1)));
        }

        System.out.println("---only output---");
        for (String name : names) {
             actionWithStringWithoutReturning (name, System.out::println);
        }
    }

    private static String actionWithString(String str, Function<String, String> action) {
        return action.apply(str);
    }

    private static void actionWithStringWithoutReturning(String str, Consumer<String> action) {
        action.accept(str);
    }

    private static void personExr() {
        Person[] personArr = new Person[10];
        fillPersonsRandom(personArr);
        //  System.out.println(personArr);
        System.out.println("print array");
        System.out.println(Arrays.toString(personArr));
        List<Person> personList = new ArrayList<>(Arrays.asList(personArr)); // from personArr
        System.out.println("print list");
        System.out.println(personList);
        Map<Long, Person> personMap = new HashMap<>(); //
        for(Person person : personList) {
            personMap.put(person.getId(), person);
        }

        for (Map.Entry<Long, Person> entry : personMap.entrySet()) {
            System.out.println("id->" + entry.getKey());
            System.out.println("person->" + entry.getValue());
            System.out.println("----");
        }

        // Sort person by age desc
        System.out.println("----Sort person by age desc");
        personList.sort(new PersonByAgeDescComparator());
        System.out.println(personList);

        // Sort person by name reverse
        Comparator<Person> personByNameDescComparator = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };

        System.out.println("----Sort person by name reverse");
        personList.sort(personByNameDescComparator);
        System.out.println(personList);

        System.out.println("----Sort person by id reverse");
        Comparator<Person> personByIdDescComparator = (o1, o2) -> Long.compare(o2.getId(), o1.getId());
        personList.sort(personByIdDescComparator);
        personList.sort((o1, o2) -> Long.compare(o2.getId(), o1.getId()));
        System.out.println(personList);
    }

    private static void fillPersonsRandom(Person[] personArr) {
        String[] names = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max"};
        final int ageFrom = 10;
        final int ageTo = 90;
        long id = 123456;

        for (int i = 0; i < personArr.length; i++) {
            id++;
            int nameIndex = (int) (Math.random() * names.length);
            String name = names[nameIndex];
            int age = ageFrom + (int) (Math.random() * (ageTo - ageFrom));
            personArr[i] = new Person(id, name, age);
        }
    }

    static class PersonByAgeDescComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return Long.compare(p2.getAge(), p1.getAge());
        }
    }
}
