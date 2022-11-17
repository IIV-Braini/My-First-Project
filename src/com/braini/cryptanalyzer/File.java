package com.braini.cryptanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class File {
    private String name;
    private String path;                                                                                       // путь к файлу



    public File(String path) throws IOException {
        this.path = getPath(path);
        this.name = getName(path);
    }

    public String getPath() {
        return path;
    }


    private String getPath(String fullPath) {
        StringBuilder str = new StringBuilder(fullPath);
        return str.substring(0, str.lastIndexOf("/"));
    }

    private String getName(String fullPath) {
        StringBuilder str = new StringBuilder(fullPath);
        return str.substring(str.lastIndexOf("/")+1);
    }

    private String renameDecodeFile () {
        StringBuilder str = new StringBuilder(name);
        str.setCharAt(str.lastIndexOf("(") + 1, 'd');
        str.setCharAt(str.lastIndexOf("(") + 2, 'c');
        return String.valueOf(str);
    }

    private String renameEncodeFile () {
        StringBuilder str = new StringBuilder(name);
        str.insert(str.lastIndexOf("."), "(encoded)");
        return String.valueOf(str);
    }

    private String renameBruteForceFile (String key) {
        StringBuilder str = new StringBuilder(name);
        str.insert(str.lastIndexOf("."), "(decoded key-" + key + ")");
        return String.valueOf(str);
    }

    private List<Double> countingSymbols() throws IOException {
        double count = 0;                                                                                     // Счетчик для кол-ва букв в тексте, будем использовать для подсчета процентов.
        double[] symbolsCount = new double[32];                                                               // Массив, в котором будем хранить кол-во встречаемых букв
        BufferedReader reader = readFile(this);
        while (reader.ready()) {
            char symbol = String.valueOf((char) reader.read()).toLowerCase().toCharArray()[0];           // читаем символ и сразу приводит его к маленькому регистру
            if (Alphabet.charContains(symbol) && Alphabet.getIndex(symbol) < 33) {    // Проверяем, если наш символ в "азбуке" и находится ли он от а до я
                int index = Alphabet.getIndex(symbol);                                        // получаем индекс этого символа
                if (index == 6)
                    index--;                                                                 // Тут ё стала е
                symbolsCount[index]++;                                                                   // считаем кол-во полученых символов
            }
        }
        List<Double> symbolQuantity = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            symbolQuantity.add(symbolsCount[i] / count * 100);                                          // Считаем в процентах кол-во каждой из букв
        }
        return symbolQuantity;
    }

    private BufferedReader readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file.path + file.name))) {
            return reader;
        } catch (
                IOException e) {
            System.out.println("Error reading the file. Check the path");
        }
        System.out.println("Sorry, system not read file");
        return null;
    }

    private BufferedWriter writeFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.path + file.name))) {
            return writer;
        } catch (
                IOException e) {
            System.out.println("Error writer the file. Check the path");
        }
        System.out.println("Sorry, system not write data to file");
        return null;
    }

    public void encoding(int key) throws IOException {
        BufferedReader reader = readFile(this);
        File encodeFile = new File(path + this.renameEncodeFile());
        BufferedWriter writer = writeFile(encodeFile);
        while (reader.ready()) {
            char symbol = (char) reader.read();                                 // Читаем один символ из файла
            writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
        }
    }

    public void decoding(int key) throws IOException {
        BufferedReader reader = readFile(this);
        key = key * -1;
        File decodeFile = new File(path + this.renameDecodeFile());
        BufferedWriter writer = writeFile(decodeFile);
        while (reader.ready()) {
            char symbol = (char) reader.read();                                 // Читаем один символ из файла
            writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
        }
    }

        // (decoded) и (decoded key-20)

    public void bruteForce() throws IOException {
        List<Double> symbols = countingSymbols();
        int key = 0;
        int compareIndex = 1000;
        for (int i = 0; i < 32; i++) {
            Collections.rotate(symbols, i);
        }
    }
}
