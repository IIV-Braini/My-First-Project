package com.braini.cryptanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cryptanalyzer {
    public static void main(String[] args) {
        String operation = args[0];                 // Получаем тип операции
        if (operation.equals("encode") || operation.equals("decode")) {          // Проверяем тип операции
            File file = new File(args[1]);
            int key = Integer.parseInt(args[2]) % 73;       //Получаем ключ и делаем "нормализацию".
            file.encoding(operation, key);
            System.out.println("Done");
        } else if ((operation.equals("bruteForce"))) {
            File file = new File(args[1], true);
            file.bruteForce();
            System.out.println("Done!");
        }
        System.out.println("Sorry, Argument error! Check and try again");
    }
}