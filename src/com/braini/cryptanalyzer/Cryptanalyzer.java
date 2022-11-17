package com.braini.cryptanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cryptanalyzer {
    public static void main(String[] args) throws IOException {
        //File fileIn = new File(args[1]);
        //String operation = args[0];
        String str = "C:\\Users\\IlyaI\\Desktop\\1\\3(encoded).txt";
        String operation = "bruteForce";
        File fileIn = new File(str);
        int key = 3534;
        if (operation.equals("encode")) {
            //int key = Integer.parseInt(args[2]) % 73;   //Получаем ключ и делаем "нормализацию".
            fileIn.encoding(key);
            System.out.println("Done");
        } else if (operation.equals("decode")) {
            //int key = Integer.parseInt(args[2]) % 73;       //Получаем ключ и делаем "нормализацию".
            fileIn.decoding(key);
            System.out.println("Done");
        } else if ((operation.equals("bruteForce"))) {
            fileIn.bruteForce();
            System.out.println("Done!");


        }
    }
}