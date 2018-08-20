package com.academy.lesson18.manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyManager {
    private static final String PROP_FILE_NAME = "java-part.properties";
    private Properties properties;

    private static PropertyManager instance = new PropertyManager();

    private PropertyManager() {
        // load properties
        properties = new Properties();
        InputStream is= PropertyManager.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);
        try {
            properties.load(new InputStreamReader(is, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyManager getInstance() {
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
