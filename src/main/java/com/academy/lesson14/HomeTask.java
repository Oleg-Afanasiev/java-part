package com.academy.lesson14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HomeTask {
    public static void main(String[] args) {
        task1();
        sortByLastSymb();
    }

    private static void sortByLastSymb() {
        String[] words = {"Hello", "Bye", "I am", "zero", "java"};
        List<String> list = Arrays.asList(words);
        list.sort((s1, s2)->Character.compare(s1.charAt(s1.length()-1), s2.charAt(s2.length()-1)));
        //list.sort(Comparator.comparingInt(s -> s.charAt(s.length() - 1)));
        System.out.println(list);
    }

    // 1) 	Составьте лямбда-выражение,
    // которое возвращает значение true, если
    //	число принадлежит к диапазону чисел 10-20,
    // включая граничные значения
    public static void task1() {
        Predicate<Integer> predicateInt = n -> n >= 10 && n <= 20;
        System.out.println(predicateInt.test(11));
        System.out.println(predicateInt.test(21));
    }
}
