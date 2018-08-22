package com.academy.lesson18.demo;

import com.academy.lesson18.dao.AbonentDao;
import com.academy.lesson18.dao.impl.jdbc.AbonentDaoImpl;
import com.academy.lesson18.model.Abonent;
import com.academy.lesson18.model.Gender;

import java.sql.Date;

public class JDBCDemo {
    public static void main(String[] args) {
        demoInsertAbonents();
        demoReadAbonents();
    }

    private static void demoInsertAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        Abonent abonent = new Abonent();
        abonent.setFirstName("first_name");
        abonent.setLastName("last_name");
        abonent.setAge(19);
        abonent.setGender(Gender.FEMALE);

        abonentDao.save(abonent);
    }

    private static void demoReadAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        abonentDao.getAll().stream()
                .forEach(System.out::println);


        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        java.util.Date date = new java.util.Date(sqlDate.getTime());
    }
}
