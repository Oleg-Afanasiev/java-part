package com.academy.lesson11;

public class DemoMain {
    public static void main(String[] args) {
        printNumberDemo();
        calculatorDemo();
    }

    private static void calculatorDemo() {
        Calculator calc = new Calculator();
        try {
            System.out.println(calc.div(4,0));
        } catch (DivisionByZeroException exc) {
//            e.printStackTrace();
            System.out.println("Can't div by zero");
            System.out.println("n1=" + exc.getN1());
            System.out.println("n2=" + exc.getN2());
        } finally {
            System.out.println("Finish demo calc");
        }
    }

    private static void printNumberDemo() {
        int[] arr = {1, 12, 123};

        for (int n : arr) {
            System.out.println(String.format("%03d", n));
        }
    }
}
