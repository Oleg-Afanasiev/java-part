package com.academy.lesson07.demo;

import com.academy.lesson06.demo.component.Button;

public class CheckBox extends Button {
    private boolean checked;

    public CheckBox(int height, int width) {
        super(height, width);
    }

    public CheckBox(int height, int width, boolean checked) {
//        super();
        super(height, width);
//        setHeight(height);
//        setWidth(width);
        this.checked = checked;
    }
}
