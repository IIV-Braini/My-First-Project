package com.braini.cryptanalyzer.service;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static List<Character> listSymbols = new ArrayList<>();

   static {                                 // можно заменить на 2 цикла
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

    protected static Character shiftCharacter(char symbol, int key) {    //Метод проверяет, входит ли символ в наш алфавит. Если символ входит, возвращает символ сдвинутый на key-позиций
        if (listSymbols.contains(symbol)) {                    // Проверяем, входит ли переданный символ в наш алфавит;
            int index = listSymbols.indexOf(symbol) + key;    // Создаем индекс, который равняется индексу текущего элемента + сдвигаемое кол-во символов;
            if (index > Alphabet.listSymbols.size() - 1)
                index -= Alphabet.listSymbols.size();                    // Если алфавил "закончился" добавляем размер алфавита, что бы получит актуальный индекс элемента;
            else if (index < 0)
                index += Alphabet.listSymbols.size();                        // Если индекс стал отрицательным добавляем размер алфавита, что бы получит актуальный индекс элемента;
            return listSymbols.get(index);                  // Возвращаем полученный символ
        } else {
            return symbol;                                  //Если элемент не попадает в наш список, возвращаем как есть.
        }
    }

    protected static int getIndex(char symbol) {              // Получить индекс символа
        return listSymbols.indexOf(symbol);
    }

    protected static boolean charContains(char symbol) {              // Получить индекс символа
        return listSymbols.contains(symbol);
    }
}
