package com.braini.cryptanalyzer;

import com.braini.cryptanalyzer.service.Alphabet;
import com.braini.cryptanalyzer.service.File;

import java.io.*;

public class CryptAnalyzer {
    public static void main(String[] args) throws IOException {
        String operation = args[0];
        File fileIn = new File(args[1]);
        switch (operation) {
            case "encode" -> {
                int key = Integer.parseInt(args[2]) % Alphabet.listSymbols.size();   //Получаем ключ и делаем "нормализацию".
                fileIn.encoding(key);                                                   // Шифруем файл
                System.out.println("encoding file finished");
            }
            case "decode" -> {
                int key = Integer.parseInt(args[2]) % Alphabet.listSymbols.size();       //Получаем ключ и делаем "нормализацию".
                fileIn.decoding(key);                                                       // Расшифровываем файл
                System.out.println("decoding file finished");
            }
            case "bruteForce" -> {
                File fileAnalyzer = new File(args[2]);                                  // Создаем файл для анализа
                fileIn.bruteForce(fileAnalyzer);                                        // Подбираем ключ на основе файла для Анализа
                System.out.println("BruteForce DONE!");
            }
        }
    }
}