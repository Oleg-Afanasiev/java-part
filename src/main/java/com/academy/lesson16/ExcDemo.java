package com.academy.lesson16;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcDemo {
    private static String pathSorted = "d:/teaching/telesens-academy/QA-JA-04/Задания/Lesson_16/имена на И.txt";
    private static OutputStream os;
    private static  OutputStreamWriter  osw;
    public static void main(String[] args) {
        init();
        readAndWriteNamesDemo();
        close();
    }

    private static void close() {

        try {

            osw.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() {
        try {
            os = new FileOutputStream(pathSorted);
            osw = new OutputStreamWriter(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readAndWriteNamesDemo() {
        String path = "d:/teaching/telesens-academy/QA-JA-04/Задания/Lesson_16/женские имена.txt";

        try {
            Files.lines(Paths.get(path))
                    .filter(s->s.startsWith("И"))
                    .peek(System.out::println)
                    .forEach(ExcDemo::writeWrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWrapper(String str) {
        try {
            osw.write(str);
              osw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
