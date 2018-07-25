package com.academy.lesson07.demo;

import com.academy.lesson06.task.Currency;

public class DemoMain {
    public static void main(String[] args) {
        CheckBox checkBox1 = new CheckBox(100, 50);
        CheckBox checkBox2 = new CheckBox(200, 150, true);
        System.out.println("w1=" + checkBox1.getWidth());
        System.out.println("h1=" + checkBox1.getHeight());
        System.out.println("w2=" + checkBox2.getWidth());
        System.out.println("h2=" + checkBox2.getHeight());

//        Integer number = 12;
//        number.
        Empty empty = new Empty();
        System.out.println(empty.toString());

        // Object
        Currency cur1 = new Currency(1000, "$");
        Currency cur2 = new Currency(1000, "$");
        System.out.println(cur1); // currency.toString()
        System.out.println(cur1 == cur2);
        System.out.println(cur1.equals(cur2));

        // Date and DateTime
        System.out.println("************");
        Date date1 = new Date(2017, 5, 22);
        Date date2 = new Date(2017, 5, 23);
        Date date3 = new Date(2017, 5, 23);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date1.equals(date2));
        System.out.println(date2.equals(date3));

        DateTime dateTime1 = new DateTime(2017, 5, 22, 21, 0, 0);
        DateTime dateTime2 = new DateTime(2017, 5, 23, 8, 45, 15);
        DateTime dateTime3 = new DateTime(2017, 5, 23, 8, 45, 15);

        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime3);
        System.out.println(dateTime1.equals(dateTime2));
        System.out.println(dateTime2.equals(dateTime3));

    }
}
