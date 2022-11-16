package com.braini.cryptanalyzer;

import java.io.*;
import java.security.Key;

public class File {
    private String path;                                                                                       // путь к файлу
    private double[] symbolQuantity = new double[32];                                                          //Анализ букв в процентном соотношении. Е и Ё за одну букву.

    public File(String path) {
        this.path = path;
    }

    public File(String path, boolean bruteforce) {                      // !!!! нужно добавить патерн сингалеон!!!!!!
        this.path = path;
        countingSymbols();
    }

    public String getPath() {
        return path;
    }

    public double[] getSymbolQuantity() {
        return symbolQuantity;
    }
    private void countingSymbols() {
        double count = 0;                                                                                     // Счетчик для кол-ва букв в тексте, будем использовать для подсчета процентов.
        double[] symbolsCount = new double[32];                                                               // Массив, в котором будем хранить кол-во встречаемых букв
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))
        ) {
            while (reader.ready()) {

                char symbol = String.valueOf((char) reader.read()).toLowerCase().toCharArray()[0];           // читаем символ и сразу приводит его к маленькому регистру
                if (Alphabet.charContains(symbol) && Alphabet.getIndex(symbol) < 33) {    // Проверяем, если наш символ в "азбуке" и находится ли он от а до я
                    int index = Alphabet.getIndex(symbol);                                        // получаем индекс этого символа
                    if (index == 6)
                        index--;                                                                 // Тут ё стала е
                    symbolsCount[index]++;                                                                   // считаем кол-во полученых символов
                }
            }
            for (int i = 0; i < 33; i++) {
                symbolQuantity[i] = symbolsCount[i] / count * 100;                                          // Считаем в процентах кол-во каждой из букв
            }
        } catch (IOException e) {
            System.out.println("error File path");
        }

    }

    public void encoding(String operation, int key) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path));
                BufferedWriter writer = new BufferedWriter(new FileWriter(newPart(operation)));
        ) {
            while (reader.ready()) {
                char symbol = (char) reader.read();                                 // Читаем один символ из файла
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // Записываем измененный символ в новый файл
            }
        } catch (
                IOException e) {
            System.out.println("Error file part");
        }
    }

    private String newPart(String operation) {                  // Должен вернуть новый путь для Файла закодированного или раскодированного
        //if(args[1] == "")                     // В зависимости от кодирования, декодирования или Брутфорса новоеимя файла encode folder/textFile1.txt 20 // результат файл folder/textFile1(encoded).txt decode folder/textFile1(encoded).txt 20 // результат файл folder/textFile1(decoded).txt
        return "Тут будет новый путь";           // Возвращает новый путь к файлу
    }

    public void bruteForce() {
    }
}
