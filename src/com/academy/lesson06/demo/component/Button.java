package com.academy.lesson06.demo.component;

public class Button {
    public static String color = "grey";
    private final int maxHeight;
    private int height;
    protected int width;
    public String text;

    public Button() {
        maxHeight = 150;
        height = 20;
        width = 30;
    }

    public Button(int height, int width) {
        maxHeight = 100;
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
