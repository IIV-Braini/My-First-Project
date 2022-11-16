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
        String src = "C:\\Users\\IlyaI\\Desktop\\1\\3.txt";
        String dest = "C:\\Users\\IlyaI\\Desktop\\1\\cripto.txt";
        String encode = "C:\\Users\\IlyaI\\Desktop\\1\\cripto2.txt";
        String decode = "C:\\Users\\IlyaI\\Desktop\\1\\decode.txt";
        int key = -125678;
        int normalKey = key % 73; //Нормализация ключа

        /*List<Character> alhabet = new ArrayList<>();
        alhabet.add('а');
        alhabet.add('б');
        alhabet.add('в');
        alhabet.add('г');
        alhabet.add('д');
        alhabet.add('е');
        alhabet.add('ё');
        alhabet.add('ж');
        alhabet.add('з');
        alhabet.add('и');
        alhabet.add('й');
        alhabet.add('к');
        alhabet.add('л');
        alhabet.add('м');
        alhabet.add('н');
        alhabet.add('о');
        alhabet.add('п');
        alhabet.add('р');
        alhabet.add('с');
        alhabet.add('т');
        alhabet.add('у');
        alhabet.add('ф');
        alhabet.add('х');
        alhabet.add('ц');
        alhabet.add('ч');
        alhabet.add('ш');
        alhabet.add('щ');
        alhabet.add('ъ');
        alhabet.add('ы');
        alhabet.add('ь');
        alhabet.add('э');
        alhabet.add('ю');
        alhabet.add('я');
        alhabet.add('А');
        alhabet.add('Б');
        alhabet.add('В');
        alhabet.add('Г');
        alhabet.add('Д');
        alhabet.add('Е');
        alhabet.add('Ё');
        alhabet.add('Ж');
        alhabet.add('З');
        alhabet.add('И');
        alhabet.add('Й');
        alhabet.add('К');
        alhabet.add('Л');
        alhabet.add('М');
        alhabet.add('Н');
        alhabet.add('О');
        alhabet.add('П');
        alhabet.add('Р');
        alhabet.add('С');
        alhabet.add('Т');
        alhabet.add('У');
        alhabet.add('Ф');
        alhabet.add('Х');
        alhabet.add('Ц');
        alhabet.add('Ч');
        alhabet.add('Ш');
        alhabet.add('Щ');
        alhabet.add('Ъ');
        alhabet.add('Ы');
        alhabet.add('Ь');
        alhabet.add('Э');
        alhabet.add('Ю');
        alhabet.add('Я');
        alhabet.add('.');
        alhabet.add(',');
        alhabet.add('\"');
        alhabet.add(':');
        alhabet.add('!');
        alhabet.add('?');
        alhabet.add(' ');*/
        try(
                BufferedReader reader = new BufferedReader(new FileReader(encode));
                BufferedWriter writer = new BufferedWriter(new FileWriter(decode));
        ) {

            while (reader.ready())
            {
                char symbol = (char) reader.read();                                 // Читаем один символ из файла
                writer.write(Alphabet.shiftCharacter(symbol, normalKey));           // Записываем измененный символ в новый файл

            }
        } catch (IOException e) {
            System.out.println("error");
        }

        int[] symbolQuantity = new int[33];
        try (
                BufferedReader reader = new BufferedReader(new FileReader(encode))
        ) {
            while (reader.ready()) {
                char symbol = (char) reader.read();
                /*if (Alphabet.listSymbols.contains(symbol) && alhabet.indexOf(symbol) < 65){
                    int index = alhabet.indexOf(symbol);
                    if(index > 32) index -= 33;
                    symbolQuantity[index]++;
                }*/
            }
            for (int i : symbolQuantity) {
                System.out.println(i);
            }
        } catch (IOException e) {
            System.out.println("error");
        }


        System.out.println("Hello world!");
    }
}