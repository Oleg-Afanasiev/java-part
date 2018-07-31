package com.academy.lesson07.demo;

public class DateTests {
    public static void main(String[] args) {
        testLeap();
    }

    private static void testLeap() {
        int[] leapYears = {2004, 2008, 2000, 4};
        int[] notLeapYears = {2003, 2009, 2100, 2007};

        for (int notLeapYear : notLeapYears) {
            // 1 способ - конструктор
            //Date date = new Date(notLeapYear, 1, 1);

            // 2 способ - методы set...
//            Date date = new Date();
//            date.setYear(notLeapYear);
//            date.setMonth(1);
//            date.setDay(1);

            // 3 способ - Шаблон Builder
            Date date = new Date()
                    .withYear(notLeapYear)
                    .withMonth(1)
                    .withDay(1);

            System.out.println("check: "+ notLeapYear);
            assert !date.isLeap();
        }

        for (int leapYear : leapYears) {
            Date date = new Date(leapYear, 1, 1);
            System.out.println("check: "+ leapYear);
            assert date.isLeap();
        }
    }
}
