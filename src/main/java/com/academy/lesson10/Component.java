package com.academy.lesson10;

public interface Component {
    void draw();
    default void erase() {
        System.out.println("Base erase");
    }
}
