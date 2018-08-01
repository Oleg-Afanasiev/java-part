package com.academy.lesson10;

public class Button implements Component{

    @Override
    public void draw() {
        System.out.println("button->draw");
    }

    @Override
    public void erase() {
        System.out.println("Custom -> erase");
    }
}
