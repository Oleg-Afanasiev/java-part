package com.academy.lesson08.annotation;

import com.academy.lesson06.test.CurrencyTests;

import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        CurrencyTests curTests = new CurrencyTests();
        Class<?> clazz = CurrencyTests.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
//                method.getAnnotation().
                if (method.isAnnotationPresent(Log.class)) {
                    System.out.println(method.getName());
                    method.invoke(curTests);
                }
            }
        }
    }
}
