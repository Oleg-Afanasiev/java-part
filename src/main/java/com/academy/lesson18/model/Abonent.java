package com.academy.lesson18.model;

import java.util.Objects;

public class Abonent {
    private long abonentId; 	// уникальный идентификатор
    private String firstName; 	// имя
    private String lastName;  	// фамилия
    private int age; 			// возраст
    private Gender gender;

    public long getAbonentId() {
        return abonentId;
    }

    public void setAbonentId(long abonentId) {
        this.abonentId = abonentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "abonentId=" + abonentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return abonentId == abonent.abonentId &&
                age == abonent.age &&
                Objects.equals(firstName, abonent.firstName) &&
                Objects.equals(lastName, abonent.lastName) &&
                Objects.equals(gender, abonent.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abonentId, firstName, lastName, age, gender);
    }
}
