package com.braini.cryptanalyzer.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class File {
    private final String name;
    private final String path;


    public File(String fullPath) {
        this.path = getPath(fullPath);
        this.name = getName(fullPath);
    }

    private String getPath(String fullPath) {                   //метод для получения пути файла без имени
        StringBuilder str = new StringBuilder(fullPath);
        return str.substring(0, str.lastIndexOf("\\") + 1);
    }

    private String getName(String fullPath) {                   //метод для получения имени файла
        StringBuilder str = new StringBuilder(fullPath);
        return str.substring(str.lastIndexOf("\\") + 1);
    }

    private String renameDecodeFile() {                         // Метод для создания нужного имени файла, который будет создан при рассшифровке файла
        StringBuilder str = new StringBuilder(name);
        str.setCharAt(str.lastIndexOf("(") + 1, 'd');
        str.setCharAt(str.lastIndexOf("(") + 2, 'e');
        return String.valueOf(str);
    }

    private String renameEncodeFile(File file) {                // Метод для создания нужного имени файла, который будет создан при шифровании файла
        StringBuilder str = new StringBuilder(file.name);
        str.insert(str.lastIndexOf("."), "(encoded)");
        return String.valueOf(str);
    }

    private String renameBruteForceFile(String key) {           // Метод для создания нужного имени файла, который будет создан при брутфорсе
        StringBuilder str = new StringBuilder(name);
        str.insert(str.lastIndexOf("."), "(decoded key-" + key + ")");
        return String.valueOf(str);
    }

    private List<Double> countingSymbols() {
        double count = 0;                                                           // Счетчик для кол-ва букв в тексте, будем использовать для подсчета процентов.
        double[] symbolsCount = new double[Alphabet.listSymbols.size() / 2];          // Массив, в котором будем хранить кол-во встречаемых букв от а до я и наши знаки 33+7.
        List<Double> symbolQuantity = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name))) {
            while (reader.ready()) {
                char symbol = Character.toLowerCase((char) reader.read());     // читаем символ и сразу приводит его к маленькому регистру
                count++;
                if (Alphabet.charContains(symbol)) {                                // Проверяем, если наш символ в "азбуке"
                    int index = Alphabet.getIndex(symbol);                         // получаем индекс этого символа
                    symbolsCount[index]++;                                         // считаем кол-во полученных символов
                }
            }
            for (int i = 0; i < Alphabet.listSymbols.size() / 2; i++) {
                symbolQuantity.add(symbolsCount[i] / count * 100);                 // Считаем в процентах кол-во каждой из букв
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return symbolQuantity;
    }

    public void encoding(int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.path + renameEncodeFile(this)))) {
            while (reader.ready()) {
                char symbol = (char) reader.read();                                 // Читаем один символ из файла
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
            }

        } catch (IOException e) {
            System.out.println("Error. Check the program");
        }
    }


    public void decoding(int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.path + this.renameDecodeFile()))) {
            key = key * -1;
            while (reader.ready()) {
                char symbol = (char) reader.read();                                 // Читаем один символ из файла
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
            }
        } catch (IOException e) {
            System.out.println("Error. Check the program");
        }
    }

    public void bruteForce(File file) throws IOException {
        List<Double> symbols = countingSymbols();               // Считаем проценты букв в декодируемом файле
        List<Integer> bigPercent = indexBigPercentSymbols(file);       // Получаем индексы самых встречаемых букв в Эталонном файле

        int key = 1;
        double sum = 0;
        for (int i = 0; i < Alphabet.listSymbols.size() / 2; i++) {
            Collections.rotate(symbols, -1);
            double sumPercent = sumPercentBigSymbols(symbols, bigPercent);
            if (sumPercent > sum) {
                sum = sumPercent;
                key = i + 1;
            }
        }
        if (countCapitalLetters() > countLowercaseLetters() && key != Alphabet.listSymbols.size() / 2)
            key += Alphabet.listSymbols.size() / 2;      // Проверка, что строчных символов больше, чем заглавных
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.path + this.renameBruteForceFile(String.valueOf(key))))) {
            key = key * -1;
            while (reader.ready()) {
                char symbol = (char) reader.read();                                 //Читаем один символ из файла
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
            }
        }
    }

    private List<Integer> indexBigPercentSymbols(File file) {               // Метод, Считает индексы символов, которые встречаются в тексте более 4%
        List<Double> symbols = file.countingSymbols();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) > 4) result.add(i);
        }
        return result;
    }

    private double sumPercentBigSymbols(List<Double> percent, List<Integer> index) {        // метод, считает сумму символов, которые употребляются более 4%
        double sum = 0;
        for (Integer integer : index) {
            sum += percent.get(integer);
        }
        return sum;
    }

    private int countCapitalLetters() {        // Считаем заглавные буквы в файле
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name))) {
            while (reader.ready()) {
                char symbol = (char) reader.read();
                if (Alphabet.charContains(symbol) && Alphabet.getIndex(symbol) >= Alphabet.listSymbols.size() / 2) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    private int countLowercaseLetters() {      // Считаем строчные буквы в файле
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name))) {
            while (reader.ready()) {
                char symbol = (char) reader.read();
                if (Alphabet.charContains(symbol) && Alphabet.getIndex(symbol) < Alphabet.listSymbols.size() / 2) {
                count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
