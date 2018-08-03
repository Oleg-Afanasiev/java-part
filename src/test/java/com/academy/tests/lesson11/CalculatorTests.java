package com.academy.tests.lesson11;

import com.academy.lesson11.Calculator;
import com.academy.lesson11.DivisionByZeroException;
import org.testng.annotations.Test;


public class CalculatorTests {

    @Test(expectedExceptions = {DivisionByZeroException.class, ArithmeticException.class})
    public void testDivision() throws DivisionByZeroException {
        System.out.println("testDivision()");
        Calculator calc = new Calculator();
        calc.div(1, 0);

        // classic assert
//        try {
//            calc.div(1, 0);
//            assert false;
//        } catch (DivisionByZeroException ignore) {
//            assert true;
//        }
    }
}
