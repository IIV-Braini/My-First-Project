package com.braini.cryptanalyzer;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static List<Character> listSymbols = new ArrayList<>();

   static {
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('�');
        listSymbols.add('.');
        listSymbols.add(',');
        listSymbols.add('\"');
        listSymbols.add(':');
        listSymbols.add('!');
        listSymbols.add('?');
        listSymbols.add(' ');
    }
   /* public static List<Double> StandardQuantity = new ArrayList<>();            // ��������� ���-�� ���� � % ������������� � ������. � � � ������
    static {
        StandardQuantity.add(7.92);           // �
        StandardQuantity.add(1.71);           // �
        StandardQuantity.add(4.33);           // �
        StandardQuantity.add(1.74);           // �
        StandardQuantity.add(3.05);            // �
        StandardQuantity.add(8.41);           // � + �
        StandardQuantity.add(1.05);           // �
        StandardQuantity.add(1.75);           // �
        StandardQuantity.add(6.83);           // �
        StandardQuantity.add(1.12);            // �
        StandardQuantity.add(3.36);            // �
        StandardQuantity.add(5.00);            // �
        StandardQuantity.add(3.26);            // �
        StandardQuantity.add(6.72);            // �
        StandardQuantity.add(11.08);            // �
        StandardQuantity.add(2.81);            // �
        StandardQuantity.add(4.45);            // �
        StandardQuantity.add(5.33);            // �
        StandardQuantity.add(6.18);            // �
        StandardQuantity.add(2.18);            // �
        StandardQuantity.add(0.19);            // �
        StandardQuantity.add(0.89);            // �
        StandardQuantity.add(0.36);            // �
        StandardQuantity.add(1.47);            // �
        StandardQuantity.add(0.81);            // �
        StandardQuantity.add(0.37);            // �
        StandardQuantity.add(0.02);           // �
        StandardQuantity.add(1.96);           // �
        StandardQuantity.add(1.92);            // �
        StandardQuantity.add(0.38);            // �
        StandardQuantity.add(0.61);            // �
        StandardQuantity.add(2.13);            // �
    }

    public static double BigPercent = 92.73;
    public static double smallPercent = 7.27;
    */



    public static Character shiftCharacter(char symbol, int key) {    //����� ���������, ������ �� ������ � ��� �������. ���� ������ ������, ���������� ������ ��������� �� key-�������
        if (listSymbols.contains(symbol)) {                    // ���������, ������ �� ���������� ������ � ��� �������;
            int index = listSymbols.indexOf(symbol) + key;    // ������� ������, ������� ��������� ������� �������� �������� + ���������� ���-�� ��������;
            if (index > 72)
                index = key - 1;                    // ���� ������ ������ 72(������� "����������"), ������ ��������� key - 1 (��-�� ������� �� 0);
            else if (index < 0)
                index += 73;                        // ���� ���� ��� ������������� � ������ ���� ������������� ��������� 73, ��� �� ������� ���������� ������ ��������
            return listSymbols.get(index);                  // ���������� ���������� ������
        } else {
            return symbol;                                  //���� ������� �� �������� � ��� ������, ���������� ��� ����.
        }
    }

    public static int getIndex(char symbol) {              // �������� ������ �������
        return listSymbols.indexOf(symbol);
    }

    public static boolean charContains(char symbol) {              // �������� ������ �������
        return listSymbols.contains(symbol);
    }
}
