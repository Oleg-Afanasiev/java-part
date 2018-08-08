package com.academy.lesson13;

import java.util.Comparator;

public class CustomPersonSort implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return Long.compare(p2.getId(), p1.getId());
    }
}
