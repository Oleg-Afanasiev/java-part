package com.academy.lesson18.demo;

import com.academy.lesson18.dao.AbonentDao;
import com.academy.lesson18.dao.impl.jdbc.AbonentDaoImpl;
import com.academy.lesson18.model.Abonent;
import com.academy.lesson18.model.Gender;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JDBCDemo {
    public static void main(String[] args) {
        demoInsertAbonents();
        demoReadAbonents();
    }

    private static void demoInsertAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        Abonent abonent = new Abonent();
        Random random = new Random();
        List<Abonent> list = new ArrayList<>(100);
        for (int i = 0; i < 200_000; i++) {
            abonent.setFirstName("first_name_" + i);
            abonent.setLastName("last_name_" + i);
            abonent.setAge(5+random.nextInt(85));
            abonent.setGender(random.nextBoolean() ? Gender.FEMALE : Gender.MALE);

            list.add(abonent);
            if (list.size() == 100) {
                abonentDao.saveAll(list);
                list.clear();
            }
        }
    }

    private static void demoReadAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        abonentDao.getAll().stream()
                .forEach(System.out::println);


        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        java.util.Date date = new java.util.Date(sqlDate.getTime());
    }
}
