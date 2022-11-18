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
   /* public static List<Double> StandardQuantity = new ArrayList<>();            // Эталонное кол-во букв в % встречающихся в тексте. Е и Ё вместе
    static {
        StandardQuantity.add(7.92);           // А
        StandardQuantity.add(1.71);           // Б
        StandardQuantity.add(4.33);           // В
        StandardQuantity.add(1.74);           // Г
        StandardQuantity.add(3.05);            // Д
        StandardQuantity.add(8.41);           // Е + Ё
        StandardQuantity.add(1.05);           // Ж
        StandardQuantity.add(1.75);           // З
        StandardQuantity.add(6.83);           // И
        StandardQuantity.add(1.12);            // Й
        StandardQuantity.add(3.36);            // К
        StandardQuantity.add(5.00);            // Л
        StandardQuantity.add(3.26);            // М
        StandardQuantity.add(6.72);            // Н
        StandardQuantity.add(11.08);            // О
        StandardQuantity.add(2.81);            // П
        StandardQuantity.add(4.45);            // Р
        StandardQuantity.add(5.33);            // С
        StandardQuantity.add(6.18);            // Т
        StandardQuantity.add(2.18);            // У
        StandardQuantity.add(0.19);            // Ф
        StandardQuantity.add(0.89);            // Х
        StandardQuantity.add(0.36);            // Ц
        StandardQuantity.add(1.47);            // Ч
        StandardQuantity.add(0.81);            // Ш
        StandardQuantity.add(0.37);            // Щ
        StandardQuantity.add(0.02);           // Ъ
        StandardQuantity.add(1.96);           // Ы
        StandardQuantity.add(1.92);            // ь
        StandardQuantity.add(0.38);            // Э
        StandardQuantity.add(0.61);            // Ю
        StandardQuantity.add(2.13);            // Я
    }

    public static double BigPercent = 92.73;
    public static double smallPercent = 7.27;
    */



    public static Character shiftCharacter(char symbol, int key) {    //Метод проверяет, входит ли символ в наш алфавит. Если символ входит, возвращает символ сдвинутый на key-позиций
        if (listSymbols.contains(symbol)) {                    // Проверяем, входит ли переданный символ в наш алфавит;
            int index = listSymbols.indexOf(symbol) + key;    // Создаем индекс, который равняется индексу текущего элемента + сдвигаемое кол-во символов;
            if (index > 51)
                index -= 52;                    // Если индекс больше 52(алфавил "закончился") 52, что бы получит актуальный индекс элемента;
            else if (index < 0)
                index += 52;                        // Если индекс стал отрицательным добавляем 52, что бы получит актуальный индекс элемента;
            return listSymbols.get(index);                  // Возвращаем полученный символ
        } else {
            return symbol;                                  //Если элемент не попадает в наш список, возвращаем как есть.
        }
    }

    public static int getIndex(char symbol) {              // Получить индекс символа
        return listSymbols.indexOf(symbol);
    }

    public static boolean charContains(char symbol) {              // Получить индекс символа
        return listSymbols.contains(symbol);
    }
}
