package com.academy.lesson10.task1;

public class TimeImplSeconds implements Time {

    private int secondsAfterMidnight;

    @Override
    public void setTime(int hours, int minutes, int seconds) {

    }

    @Override
    public String getTime(TimeFormat timeFormat) {
        return "00:00:00";
    }

    private void toSeconds(int h, int m, int s) {
        secondsAfterMidnight = s + m*60 + h*60*60;
    }

    private int currentSecond() {
        return secondsAfterMidnight; // f(secondsAfterMidnight)
    }

    private int currentMinute() {
        return 0; // f(secondsAfterMidnight)
    }

    private int currentHour() {
        return 0; // f(secondsAfterMidnight)
    }
}
