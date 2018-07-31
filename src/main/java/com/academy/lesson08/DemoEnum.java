package com.academy.lesson08;

import static com.academy.lesson08.Season.AUTUMN;
import static com.academy.lesson08.Season.WINTER;

public class DemoEnum {
    public static void main(String[] args) {
        System.out.println(WINTER == AUTUMN);
        System.out.println(WINTER == WINTER);
    }
}
