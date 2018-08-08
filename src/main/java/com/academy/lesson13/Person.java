package com.academy.lesson13;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private long id;
    private String name;
    private int age;

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    // SORT
    @Override
    public int compareTo(Person o) {
//        if (this.age < o.age)
//            return -1;
//
//        if (this.age > o.age)
//            return 1;
//
//        return 0;

        return Integer.compare(this.age, o.age);
    }
}
