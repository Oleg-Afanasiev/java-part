package com.academy.lesson10;

public class CoolButton implements Component {
    @Override
    public void draw() {
        System.out.println("CoolButton->draw");
    }

    @Override
    public void erase() {
        System.out.println("CollButton->erase");
    }
}
