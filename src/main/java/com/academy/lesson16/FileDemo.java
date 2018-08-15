package com.academy.lesson16;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FileDemo {
    private static final String PROP_FILE_NAME = "java-part.properties";

    public static void main(String[] args) {
        demoDelete();
        readProperties();
    }

    private static void readProperties() {
        Properties prop = new Properties();
        InputStream is= FileDemo.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);
        try {
            prop.load(new InputStreamReader(is, "UTF-8"));
            String pathMaleNames = prop.getProperty("male.firstnames");
            System.out.println(pathMaleNames);
            System.out.println(Files.exists(Paths.get(pathMaleNames)));
            Files.lines(Paths.get(pathMaleNames)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demoDelete() {
        String path = "d:/temp1";
        File file = new File(path);
//        Files.get
        boolean resultDeleting = file.delete();
        System.out.println(resultDeleting);
    }
}
