package com.academy.lesson4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
7) Написать регулярное выражение,
 которые проверят емейлы простого вида
 (например, test@test.test).
 */

public class Task7 {
    private static int CODE_SUCCESS = 1;
    private  static int CODE_FAIL = 0;

    public static void main(String[] args) {
        String mail = inputMail();
        int code = checkEmail(mail);
        outputMail (mail, code);

        testRegex();
    }

    private static void testRegex() {
        String[] correctMails = {"demoff@gmail.com", "123demoff32eddkh@gmail.com"};
        String[] incorrectMails = { "demoff@gmail.kh.com", "123demoff.kh@gmail.com", "demoff.kh@gmail.com"};

        System.out.println("Check correct mails: ");
        for (String mail : correctMails) {
            System.out.println(mail);
            assert checkEmail(mail) == CODE_SUCCESS;
        }

        System.out.println("Check incorrect mails: ");
        for (String mail : incorrectMails) {
            System.out.println(mail);
            assert checkEmail(mail) == CODE_FAIL;
        }
    }

    //Функция ввода почты
    public static String inputMail(){
        System.out.println("ведите @-mail:");
        String str = new Scanner(System.in).nextLine();
        return str;
    }
    //Функция проверки почты
    public static int checkEmail(String mailTarget){
//        final Pattern pattern = Pattern.compile("^[A-Za-z.%+\\-]+@[A-Za-z.\\-]+\\.[A-Za-z]{2,4}");
        final Pattern pattern = Pattern.compile("^[\\w%+\\-]+@[A-Za-z\\-]+\\.[A-Za-z]{2,4}$");
        final Matcher matcher = pattern.matcher(mailTarget);
        if (matcher.find()){
            return CODE_SUCCESS;
        }
        else
            return CODE_FAIL;
    }
    //Функция вывода результата
    public static void outputMail(String mail, int code){
        if (code== CODE_SUCCESS) {
            System.out.println(mail + ": = Correct");
        } else
            System.out.println(mail+ ": = Incorrect");
    }
}
