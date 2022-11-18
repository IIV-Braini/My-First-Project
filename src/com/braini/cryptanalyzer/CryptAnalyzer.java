package com.braini.cryptanalyzer;

import com.braini.cryptanalyzer.service.Alphabet;
import com.braini.cryptanalyzer.service.File;

import java.io.*;

public class CryptAnalyzer {
    public static void main(String[] args) throws IOException {
        String operation = args[0];
        File fileIn = new File(args[1]);
        if (operation.equals("encode")) {
            int key = Integer.parseInt(args[2]) % Alphabet.listSymbols.size();   //Получаем ключ и делаем "нормализацию".
            fileIn.encoding(key);
            System.out.println("encoding file finished");
        } else if (operation.equals("decode")) {
            int key = Integer.parseInt(args[2]) % Alphabet.listSymbols.size();       //Получаем ключ и делаем "нормализацию".
            fileIn.decoding(key);
            System.out.println("decoding file finished");
        } else if ((operation.equals("bruteForce"))) {
            File fileAnalyzer = new File(args[2]);
            fileIn.bruteForce(fileAnalyzer);
            System.out.println("BruteForce DONE!");
        }
    }
}