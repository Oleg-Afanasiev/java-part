package com.academy.lesson06.task;

/*
3а) Класс Currency для работы с денежными суммами.
        - Класс должен быть представлен двумя private полями:
        double value; для хранения значания суммы
        String name; для хранения названия валюты ("грн", "руб", "$")

        Реализовать 2 конструктора:
        - без параметров
        - и с двумя параметрами, которые принимает (double value, String name);
        - конструктор копирования: (Currency currency)

        - Реализовать метод отображения суммы на экран print();
        Напр. в виде: 154.65руб // отображать не более 2 знаков после запятой

        - Реализовать операцию сравнения:
        boolean isEqual(Currency currency); // вернет true, если и значение и строка - совпадают

        - Реализовать методы:
        void add(double value, String name); // метод сложения
        (если name отличается от текущего поля 'name', то сложение не производить,
        а вывести сообщение об ошибке ("Error: currency names are differ 'грн' - 'руб')
        void add(Currency currency); // метод сложения

        void substract(double value, String name); // метод вычитания ...
        void substract(Currency currency);

        void divide(double factor); // деление суммы на число
        void multiply(double factor); // умножение суммы на число
*/

import java.util.Objects;

public class Currency {

    private static final String[] CURRENCIES_SUPPORTED = {"грн", "руб", "$"};
    private double value;
    private String name;  ///("грн", "руб", "$")

    private boolean valid = true;

    public Currency(double value, String name) {
        if (!ensureValidCurrency(name)) {
            valid = false;
            return;
        }
        this.value = value;
        this.name = name;
    }

    public Currency(Currency other) {
        this.value = other.value;
        this.name = other.name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!ensureValidCurrency(name)) {
            valid = false;
            return;
        }
        this.name = name;
    }

    public boolean isValid() {
        return valid;
    }

    public void print() {
        System.out.println(String.format("%.2f%s", value, name));
    }

    public boolean isEqual(Currency other) {
        if (this.value != other.value)
            return false;

        if (!this.name.equals(other.name))
            return false;

        return true;
    }

    // TODO check name is correspond to CURRENCIES_SUPPORTED
    private boolean ensureValidCurrency(String name) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%.2f%s", value, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Double.compare(currency.value, value) == 0 &&
                Objects.equals(name, currency.name);

//        Currency other = (Currency) o;
//        if (this.value != other.value)
//            return false;
//
//        if (!this.name.equals(other.name))
//            return false;
//
//        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, name);
    }
}
