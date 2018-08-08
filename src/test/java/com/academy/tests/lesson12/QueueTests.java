package com.academy.tests.lesson12;

import com.academy.lesson08.annotation.Test;
import com.academy.lesson12.queue.Queue;
import com.academy.lesson12.queue.QueueImpl;
import org.testng.Assert;

@Test
public class QueueTests {
    public void testStackInt(){
        Integer[] intData = {1, 2, 4, 6, 7, 8, 89, 7, 4, 9};
        Integer[] arr = new Integer[intData.length];

        Queue<Integer> queueInt = new QueueImpl<>(arr);

        for (int i = 0; i < intData.length; i++){
            queueInt.add(intData[i]);
        }

        int n = queueInt.element().intValue();
        Assert.assertTrue(n == intData[0]);

        int m = queueInt.peek();
        Assert.assertTrue(m == intData[0]);


//// java.lang.ArrayIndexOutOfBoundsException: 10:


//        queueInt.poll();
//        Assert.assertTrue(intData[0] == 2);


//        for (int i = intData.length-1; i >= 0; i--) {
//
//            queueInt.remove();
//        }







    }
}
