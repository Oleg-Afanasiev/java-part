package com.academy.lesson11;

public class Calculator {
    public double div(double d1, double d2) {
        return d1/d2;
    }

    public double div (int n1, int n2) throws DivisionByZeroException {
        if (n2 == 0)
            throw new DivisionByZeroException(n1, n2);
        return n1/n2;
    }
}
