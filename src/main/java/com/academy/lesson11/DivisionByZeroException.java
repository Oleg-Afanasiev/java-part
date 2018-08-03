package com.academy.lesson11;

public class DivisionByZeroException extends Exception {
    private int n1;
    private int n2;

    public DivisionByZeroException() {
    }

    public DivisionByZeroException(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }
}
