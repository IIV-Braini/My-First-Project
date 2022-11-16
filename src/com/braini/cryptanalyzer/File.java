package com.braini.cryptanalyzer;

import java.io.*;
import java.security.Key;

public class File {
    private String path;                                                                                       // ���� � �����
    private double[] symbolQuantity = new double[32];                                                          //������ ���� � ���������� �����������. � � � �� ���� �����.

    public File(String path) {
        this.path = path;
    }

    public File(String path, boolean bruteforce) {                      // !!!! ����� �������� ������ ���������!!!!!!
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
        double count = 0;                                                                                     // ������� ��� ���-�� ���� � ������, ����� ������������ ��� �������� ���������.
        double[] symbolsCount = new double[32];                                                               // ������, � ������� ����� ������� ���-�� ����������� ����
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))
        ) {
            while (reader.ready()) {

                char symbol = String.valueOf((char) reader.read()).toLowerCase().toCharArray()[0];           // ������ ������ � ����� �������� ��� � ���������� ��������
                if (Alphabet.charContains(symbol) && Alphabet.getIndex(symbol) < 33) {    // ���������, ���� ��� ������ � "������" � ��������� �� �� �� � �� �
                    int index = Alphabet.getIndex(symbol);                                        // �������� ������ ����� �������
                    if (index == 6)
                        index--;                                                                 // ��� � ����� �
                    symbolsCount[index]++;                                                                   // ������� ���-�� ��������� ��������
                }
            }
            for (int i = 0; i < 33; i++) {
                symbolQuantity[i] = symbolsCount[i] / count * 100;                                          // ������� � ��������� ���-�� ������ �� ����
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
                char symbol = (char) reader.read();                                 // ������ ���� ������ �� �����
                writer.write(Alphabet.shiftCharacter(symbol, key));                 // ���������� ���������� ������ � ����� ����
            }
        } catch (
                IOException e) {
            System.out.println("Error file part");
        }
    }

    private String newPart(String operation) {                  // ������ ������� ����� ���� ��� ����� ��������������� ��� ����������������
        //if(args[1] == "")                     // � ����������� �� �����������, ������������� ��� ��������� �������� ����� encode folder/textFile1.txt 20 // ��������� ���� folder/textFile1(encoded).txt decode folder/textFile1(encoded).txt 20 // ��������� ���� folder/textFile1(decoded).txt
        return "��� ����� ����� ����";           // ���������� ����� ���� � �����
    }

    public void bruteForce() {
    }
}
