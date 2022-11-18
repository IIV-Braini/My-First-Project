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
        String str = "C:\\Users\\IlyaI\\OneDrive\\1\\hamlet(encoded).txt";
        String str2 = "C:\\Users\\IlyaI\\OneDrive\\1\\othello.txt";
        String operation = "bruteForce";
        File fileIn = new File(str);
        File fileAnalyzer = new File(str2);
        int key = 17;
        if (operation.equals("encode")) {
            //key = Integer.parseInt(args[2]) % 73;   //Получаем ключ и делаем "нормализацию".
            fileIn.encoding(key);
            System.out.println("Done");
        } else if (operation.equals("decode")) {
            //int key = Integer.parseInt(args[2]) % 73;       //Получаем ключ и делаем "нормализацию".
            fileIn.decoding(key);
            System.out.println("Done");
        } else if ((operation.equals("bruteForce"))) {
            fileIn.bruteForce(fileAnalyzer);
            System.out.println("Done!");
        }
    }
}