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
        double count = 0;                                               // ������� ��� ���-�� ���� � ������, ����� ������������ ��� �������� ���������.
        double[] symbolsCount = new double[26];                         // ������, � ������� ����� ������� ���-�� ����������� ���� �� � �� � � ���� ����� 33+7.
        List<Double> symbolQuantity = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path + this.name))) {
            while (reader.ready()) {
                Character symbol = Character.toLowerCase((char) reader.read()); // ������ ������ � ����� �������� ��� � ���������� ��������
                count++;
                if (Alphabet.charContains(symbol)) {                        // ���������, ���� ��� ������ � "������"
                    int index = Alphabet.getIndex(symbol);                  // �������� ������ ����� �������
                    symbolsCount[index]++;                                                                   // ������� ���-�� ���������� ��������
                }
            }
            for (int i = 0; i < 26; i++) {
                symbolQuantity.add(symbolsCount[i] / count * 100);                                          // ������� � ��������� ���-�� ������ �� ����
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
                char symbol = (char) reader.read();                                 // ������ ���� ������ �� �����
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // ���������� ���������� ������ � ����� ����
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
                char symbol = (char) reader.read();                                 // ������ ���� ������ �� �����
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // ���������� ���������� ������ � ����� ����
            }
        } catch (IOException e) {
            System.out.println("Error. Check the program");
        }
    }

    public void bruteForce(File file) throws IOException {
        List<Double> symbols = countingSymbols();               // ������� �������� ���� � ������������ �����
        List<Integer> bigPercent = indexBigPercentSymbols(file);       // �������� ������� ����� ����������� ���� � ��������� �����

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

                char symbol = (char) reader.read();                             //������ ���� ������ �� �����
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // ���������� ���������� ������ � ����� ����
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
