package com.academy.lesson06.demo;

import com.academy.lesson06.demo.component.Button;
import com.academy.lesson06.task.Currency;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int h = 10;
        int w = 20;
        String color = Button.color;
        Button.color = "green";
        Button button2 = new Button(h, w);
        Button button = new Button();
        button.getWidth();
        button.setText("Log In");
        System.out.println(button.getText());
        System.out.println(button.text);
        System.out.println(button.getWidth());

        //
        System.out.println("***********");
        IntCover intCover = new IntCover();
        intCover.number = 10;
        String str = "Hello";
        int n1 = 20;
        Integer n2 = 30;
        tryChangeParam(intCover);
        tryChangeParam(str);
        tryChangeParam(n1);
        tryChangeParam(n2);
        System.out.println(intCover.number); // ???
        System.out.println(str); // ???
        System.out.println(n1); // ???
        System.out.println(n2); // ???

        System.out.println("****");
        int[] arr = {1, 2, 3};
        tryChangeParam(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("**********Demo currency**********");
        Currency cur1 = new Currency(100, "руб");
        Currency cur2 = new Currency(cur1);

        cur1.print();
        cur2.print();
    }

    private static void tryChangeParam(int[] arr) {
        arr = new int[]{4, 5, 6};
        arr[0] = 100;
    }

    private static void tryChangeParam(int n) {
        n = 25;
    }

    private static void tryChangeParam(Integer n) {
        n = 35;
    }

    private static void tryChangeParam(String str) {
        str = "Bye";
    }

    private static void tryChangeParam(IntCover intCover) {
        intCover.number = 15;
    }
}
