package com.braini.cryptanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class File {
    private final String name;
    private final String path;


    public File(String path) {
        this.path = getPath(path);
        this.name = getName(path);
    }

    private String getPath(String fullPath) {
        StringBuilder str = new StringBuilder(fullPath);
        return str.substring(0, str.lastIndexOf("\\") + 1);
    }

    private String getName(String fullPath) {
        StringBuilder str = new StringBuilder(fullPath);
        return str.substring(str.lastIndexOf("\\") + 1);
    }

    private String renameDecodeFile() {
        StringBuilder str = new StringBuilder(name);
        str.setCharAt(str.lastIndexOf("(") + 1, 'd');
        str.setCharAt(str.lastIndexOf("(") + 2, 'e');
        return String.valueOf(str);
    }

    private String renameEncodeFile(File file) {
        StringBuilder str = new StringBuilder(file.name);
        str.insert(str.lastIndexOf("."), "(encoded)");
        return String.valueOf(str);
    }

    private String renameBruteForceFile(String key) {
        StringBuilder str = new StringBuilder(name);
        str.insert(str.lastIndexOf("."), "(decoded key-" + key + ")");
        return String.valueOf(str);
    }

    private List<Double> countingSymbols() {
        double count = 0;                                               // Счетчик для кол-ва букв в тексте, будем использовать для подсчета процентов.
        double[] symbolsCount = new double[26];                         // Массив, в котором будем хранить кол-во встречаемых букв от а до я и наши знаки 33+7.
        List<Double> symbolQuantity = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name))) {
            while (reader.ready()) {
                Character symbol = Character.toLowerCase((char) reader.read()); // читаем символ и сразу приводит его к маленькому регистру
                count++;
                if (Alphabet.charContains(symbol)) {                        // Проверяем, если наш символ в "азбуке"
                    int index = Alphabet.getIndex(symbol);                  // получаем индекс этого символа
                    symbolsCount[index]++;                                                                   // считаем кол-во полученных символов
                }
            }
            for (int i = 0; i < 26; i++) {
                symbolQuantity.add(symbolsCount[i] / count * 100);                                          // Считаем в процентах кол-во каждой из букв
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return symbolQuantity;
    }


    /*private BufferedReader readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file.path + file.name))) {
            return reader;
        } catch (
                IOException e) {
            System.out.println("Error reading the file. Check the path");
        }
        System.out.println("Sorry, system not read file");
        return null;
    }

    private BufferedWriter writeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path + this.name))) {
            return writer;
        } catch (
                IOException e) {
            System.out.println("Error writer the file. Check the path");
        }
        System.out.println("Sorry, system not write data to file");
        return null;
    }*/

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

        int key = 0;
        double sum = 0;
        for (int i = 0; i < 52; i++) {
            Collections.rotate(symbols, i*-1);
            double sumPercent = sumPercentBigSymbols(symbols, bigPercent);
            if (sum < sumPercent) {
                sum = sum;
                key = i;
            }
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.path + this.renameBruteForceFile(String.valueOf(key))))) {
            key = key * -1;
            while (reader.ready()) {

                char symbol = (char) reader.read();                             //Читаем один символ из файла
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
            }
        }
    }

    public List<Integer> indexBigPercentSymbols (File file) {
        List<Double> symbols = file.countingSymbols();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) > 5) result.add(i);
        }
        return result;
    }
    private double sumPercentBigSymbols(List<Double> percent, List<Integer> index) {
        double sum = 0;
        for (int i = 0; i < index.size(); i++) {
            sum += percent.get(index.get(i));
        }
        return sum;
    }
}
