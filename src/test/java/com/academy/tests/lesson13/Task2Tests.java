package com.academy.tests.lesson13;

import com.academy.lesson08.annotation.Test;
import javafx.util.Pair;
import org.testng.Assert;

@Test
public class Task2Tests {

    private static final int FREQ_IND = 0;
    private static final int MIN_IND = 1;

    public void testF() {
        int[] numbers = {1, 2, 5, 5, 4, 5, 6, 7, 2, 2, 8, 0, 1, 3, 1};
        Pair<Integer, Integer> res = freqAndMin(numbers);

        int freqExpected = 3;
        int minExpected = 1;

        int freqActual = res.getKey();
        int minActual = res.getValue();


        Assert.assertEquals(freqActual, freqExpected);
        Assert.assertEquals(minActual, minExpected);
    }

    public Pair<Integer, Integer> freqAndMin(int[] numbers) {
        return new Pair<>(1, 1);
    }
}
