package com.braini.cryptanalyzer.service;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static List<Character> listSymbols = new ArrayList<>();

   static {                                 // ����� �������� �� 2 �����
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

    protected static Character shiftCharacter(char symbol, int key) {    //����� ���������, ������ �� ������ � ��� �������. ���� ������ ������, ���������� ������ ��������� �� key-�������
        if (listSymbols.contains(symbol)) {                    // ���������, ������ �� ���������� ������ � ��� �������;
            int index = listSymbols.indexOf(symbol) + key;    // ������� ������, ������� ��������� ������� �������� �������� + ���������� ���-�� ��������;
            if (index > Alphabet.listSymbols.size() - 1)
                index -= Alphabet.listSymbols.size();                    // ���� ������� "����������" ��������� ������ ��������, ��� �� ������� ���������� ������ ��������;
            else if (index < 0)
                index += Alphabet.listSymbols.size();                        // ���� ������ ���� ������������� ��������� ������ ��������, ��� �� ������� ���������� ������ ��������;
            return listSymbols.get(index);                  // ���������� ���������� ������
        } else {
            return symbol;                                  //���� ������� �� �������� � ��� ������, ���������� ��� ����.
        }
    }

    protected static int getIndex(char symbol) {              // �������� ������ �������
        return listSymbols.indexOf(symbol);
    }

    protected static boolean charContains(char symbol) {              // �������� ������ �������
        return listSymbols.contains(symbol);
    }
}
