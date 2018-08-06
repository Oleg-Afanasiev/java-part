package com.academy.lesson10.task1;

public class TimeImpl implements Time {
    private int h;
    private int m;
    private int s;

    @Override
    public void setTime(int hours, int minutes, int seconds) {

    }

    @Override
    public String getTime(TimeFormat timeFormat) throws IncorrectTimeFormat {
        switch (timeFormat) {
            case HOUR_12:
                return String.format("%02d:%02d:%02d%s",
                        h <= 12 ? h : h-12, m, s, h <= 12 ? "AM" : "PM");

            case HOUR_24:
                return String.format("%02d:%02d:%02d", h, m, s);
        }

        throw new IncorrectTimeFormat();
    }
}
