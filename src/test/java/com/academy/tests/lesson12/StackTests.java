package com.academy.tests.lesson12;

import com.academy.lesson12.EmptyStackException;
import com.academy.lesson12.FullStackException;
import com.academy.lesson12.Stack;
import com.academy.lesson12.StackImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StackTests {

    public void testStackInt() {
        Integer[] intData = {1, 2, 4, 6, 7, 8, 89, 7, 4, 9};

        Integer[] arr = new Integer[intData.length];
        Stack<Integer> stackInt = new StackImpl<>(arr);

        try {
            for (int i = 0; i < intData.length; i++) {
                stackInt.push(intData[i]);
            }

            for (int i = intData.length-1; i >= 0; i--) {
                Assert.assertEquals(stackInt.peek(), intData[i]);
                Assert.assertEquals(stackInt.pop(), intData[i]);
            }
        } catch (FullStackException | EmptyStackException e) {
            Assert.fail("");
        }
    }

    public void testStackStr() {
        String[] strData = {"one", "two", "Hello World"};

        String[] arr = new String[strData.length];
        Stack<String> stackInt = new StackImpl<>(arr);

        try {
            for (int i = 0; i < strData.length; i++) {
                stackInt.push(strData[i]);
            }

            for (int i = strData.length-1; i >= 0; i--) {
                Assert.assertEquals(stackInt.peek(), strData[i]);
                Assert.assertEquals(stackInt.pop(), strData[i]);
            }
        } catch (FullStackException | EmptyStackException e) {
            Assert.fail("");
        }
    }
}
