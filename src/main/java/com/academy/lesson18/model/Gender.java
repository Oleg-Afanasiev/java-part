package com.academy.lesson18.model;

public enum Gender {
    MALE,
    FEMALE;

    private Character name;

    public static Gender valueOf(char name) {
        switch (name) {
            case 'f':
                return Gender.FEMALE;

            case 'm':
                return Gender.MALE;
        }
        return null;
    }
}
