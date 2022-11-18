package com.braini.cryptanalyzer;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static List<Character> listSymbols = new ArrayList<>();

   static {
        listSymbols.add('a');
        listSymbols.add('b');
        listSymbols.add('c');
        listSymbols.add('d');
        listSymbols.add('e');
        listSymbols.add('f');
        listSymbols.add('g');
        listSymbols.add('h');
        listSymbols.add('i');
        listSymbols.add('j');
        listSymbols.add('k');
        listSymbols.add('l');
        listSymbols.add('m');
        listSymbols.add('n');
        listSymbols.add('o');
        listSymbols.add('p');
        listSymbols.add('q');
        listSymbols.add('r');
        listSymbols.add('s');
        listSymbols.add('t');
        listSymbols.add('u');
        listSymbols.add('v');
        listSymbols.add('w');
        listSymbols.add('x');
        listSymbols.add('y');
        listSymbols.add('z');
        listSymbols.add('A');
        listSymbols.add('B');
        listSymbols.add('C');
        listSymbols.add('D');
        listSymbols.add('E');
        listSymbols.add('F');
        listSymbols.add('G');
        listSymbols.add('H');
        listSymbols.add('I');
        listSymbols.add('J');
        listSymbols.add('K');
        listSymbols.add('L');
        listSymbols.add('M');
        listSymbols.add('N');
        listSymbols.add('O');
        listSymbols.add('P');
        listSymbols.add('Q');
        listSymbols.add('R');
        listSymbols.add('S');
        listSymbols.add('T');
        listSymbols.add('U');
        listSymbols.add('V');
        listSymbols.add('W');
        listSymbols.add('X');
        listSymbols.add('Y');
        listSymbols.add('Z');
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
            if (index > 51)
                index -= 52;                    // ���� ������ ������ 52(������� "����������") 52, ��� �� ������� ���������� ������ ��������;
            else if (index < 0)
                index += 52;                        // ���� ������ ���� ������������� ��������� 52, ��� �� ������� ���������� ������ ��������;
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
