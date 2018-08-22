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

    protected void init() {

        try {
            Class.forName(PropertyManager.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(PropertyManager.getProperty("jdbc.connect"));
    }
}
