package com.academy.tests.lesson10.task1;

import com.academy.lesson10.task1.Time;
import com.academy.lesson10.task1.TimeFormat;
import com.academy.lesson10.task1.TimeImpl;
import com.academy.lesson10.task1.TimeImplSeconds;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.academy.lesson10.task1.TimeFormat.HOUR_12;
import static com.academy.lesson10.task1.TimeFormat.HOUR_24;


public class TimeTests {

    @Test
    @Ignore
    public void testTime() {
        // data
        final int HOUR_I = 0;
        final int MINUTE_I = 1;
        final int SECOND_I = 2;
        final int FORMAT_I = 3;
        final int EXPECTED_I = 4;
            Object[][] testData = {
                    {13, 1, 1, HOUR_12, "01:01:01pm"},
                    {13, 1, 1, HOUR_24, "13:01:01"}
            };

        // test logic and asserts
        for (Object[] row : testData) {
            Time time1 = new TimeImpl();
            Time time2 = new TimeImplSeconds();
            time1.setTime((int)row[HOUR_I], (int)row[MINUTE_I], (int)row[SECOND_I]);
            time2.setTime((int)row[HOUR_I], (int)row[MINUTE_I], (int)row[SECOND_I]);
            String timeStr1 = time1.getTime((TimeFormat) row[FORMAT_I]);
            String timeStr2 = time2.getTime((TimeFormat)row[FORMAT_I]);

            Assert.assertEquals(timeStr1, (String)row[EXPECTED_I]);
            Assert.assertEquals(timeStr2, (String)row[EXPECTED_I]);
        }
//        Time time1 = new TimeImpl();
//        Time time2 = new TimeImplSeconds();
//        time1.setTime(13, 1, 1);
//        time2.setTime(13, 1, 1);
//        String timeStr1 = time1.getTime(HOUR_12);
//        String timeStr2 = time2.getTime(HOUR_12);
//
//        Assert.assertEquals(timeStr1, "01:01:01pm");
//        Assert.assertEquals(timeStr2, "01:01:01pm");
//
//        time1.setTime(13, 1, 1);
//        time2.setTime(13, 1, 1);
//        timeStr1 = time1.getTime(HOUR_24);
//        timeStr2 = time2.getTime(HOUR_24);
//
//        Assert.assertEquals(timeStr1, "13:01:01");
//        Assert.assertEquals(timeStr2, "13:01:01");
    }
}
