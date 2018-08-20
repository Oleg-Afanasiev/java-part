package com.academy.lesson18.dao.impl.jdbc;

import com.academy.lesson18.manager.PropertyManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {

    private Properties properties;

    public BaseDao() {
        init();
    }

    protected void loadProperties() {

    }

    protected void init() {

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName(PropertyManager.getInstance().getProperty("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test_sql?user=root&password=root&serverTimezone=UTC&useSSL=false");
        return DriverManager.getConnection(PropertyManager.getInstance().getProperty("jdbc.connect"));
    }
}
