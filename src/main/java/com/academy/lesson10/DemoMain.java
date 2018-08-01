package com.academy.lesson10;

public class DemoMain {
    public static void main(String[] args) {
        // 1
        Button btn = new Button();
        btn.draw();

        CoolButton btn2 = new CoolButton();
        btn2.draw();

        // 2
        Component btn3 = provideButton();
        btn3.draw();
        btn3.erase();
    }

    private static Component provideButton() {
        return new CoolButton();
    }
}
