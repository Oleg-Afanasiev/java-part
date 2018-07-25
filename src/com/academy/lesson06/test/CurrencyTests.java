package com.academy.lesson06.test;

import com.academy.lesson06.task.Currency;

public class CurrencyTests {
    public static void main(String[] args) {
        CurrencyTests test = new CurrencyTests();
        test.constructorTest();
        test.copyConstructorTest();
        test.isEqualTest();
    }

    public void constructorTest() {
        // test data
//        int[] values = {10, 0, -3};
//        String[] names = {"руб", "грн", "$"};

        CurrencyTestData[] positiveTestData = new CurrencyTestData[]{
                new CurrencyTestData(10, "руб"),
                new CurrencyTestData(0, "грн"),
                new CurrencyTestData(-3, "$")
        };

        CurrencyTestData[] negativeTestData = new CurrencyTestData[]{
                new CurrencyTestData(10, ""),
                new CurrencyTestData(0, "@"),
                new CurrencyTestData(-3, "euro")
        };

        // test logic
        for (int i = 0; i < positiveTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = positiveTestData[i].getName();
            double value = positiveTestData[i].getValue();

            Currency cur = new Currency(value, name);
            assert cur.getValue() == value;
            assert cur.getName().equals(name);
            assert cur.isValid();
        }

        for (int i = 0; i < negativeTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = negativeTestData[i].getName();
            double value = negativeTestData[i].getValue();

            Currency cur = new Currency(value, name);
            assert !cur.isValid();

        }
    }

    public void copyConstructorTest() {

    }

    public void isEqualTest() {
        Currency cur1 = new Currency(10, "руб");
        Currency cur2 = new Currency(10, "руб");
        Currency cur3 = new Currency(11, "руб");

        assert cur1.isEqual(cur2);
        assert !cur1.isEqual(cur3);
    }
}
