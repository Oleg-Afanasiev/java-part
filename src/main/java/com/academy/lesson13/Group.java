package com.academy.lesson13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Iterable<Person> {

    private List<Person> people = new ArrayList<>();

    public void add(Person p) {
        people.add(p);
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < people.size();
            }

            @Override
            public Person next() {
                return people.get(index++);
            }
        };
    }
}
