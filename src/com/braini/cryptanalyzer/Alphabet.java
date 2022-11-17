package com.braini.cryptanalyzer;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static List<Character> listSymbols = new ArrayList<>();

   static {
        listSymbols.add('а');
        listSymbols.add('б');
        listSymbols.add('в');
        listSymbols.add('г');
        listSymbols.add('д');
        listSymbols.add('е');
        listSymbols.add('ё');
        listSymbols.add('ж');
        listSymbols.add('з');
        listSymbols.add('и');
        listSymbols.add('й');
        listSymbols.add('к');
        listSymbols.add('л');
        listSymbols.add('м');
        listSymbols.add('н');
        listSymbols.add('о');
        listSymbols.add('п');
        listSymbols.add('р');
        listSymbols.add('с');
        listSymbols.add('т');
        listSymbols.add('у');
        listSymbols.add('ф');
        listSymbols.add('х');
        listSymbols.add('ц');
        listSymbols.add('ч');
        listSymbols.add('ш');
        listSymbols.add('щ');
        listSymbols.add('ъ');
        listSymbols.add('ы');
        listSymbols.add('ь');
        listSymbols.add('э');
        listSymbols.add('ю');
        listSymbols.add('я');
        listSymbols.add('А');
        listSymbols.add('Б');
        listSymbols.add('В');
        listSymbols.add('Г');
        listSymbols.add('Д');
        listSymbols.add('Е');
        listSymbols.add('Ё');
        listSymbols.add('Ж');
        listSymbols.add('З');
        listSymbols.add('И');
        listSymbols.add('Й');
        listSymbols.add('К');
        listSymbols.add('Л');
        listSymbols.add('М');
        listSymbols.add('Н');
        listSymbols.add('О');
        listSymbols.add('П');
        listSymbols.add('Р');
        listSymbols.add('С');
        listSymbols.add('Т');
        listSymbols.add('У');
        listSymbols.add('Ф');
        listSymbols.add('Х');
        listSymbols.add('Ц');
        listSymbols.add('Ч');
        listSymbols.add('Ш');
        listSymbols.add('Щ');
        listSymbols.add('Ъ');
        listSymbols.add('Ы');
        listSymbols.add('Ь');
        listSymbols.add('Э');
        listSymbols.add('Ю');
        listSymbols.add('Я');
        listSymbols.add('.');
        listSymbols.add(',');
        listSymbols.add('\"');
        listSymbols.add(':');
        listSymbols.add('!');
        listSymbols.add('?');
        listSymbols.add(' ');
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
    }*/

    public static double BigPercent = 92.73;
    public static double smallPercent = 7.27;




    public static Character shiftCharacter(char symbol, int key) {    //Метод проверяет, входит ли символ в наш алфавит. Если символ входит, возвращает символ сдвинутый на key-позиций
        if (listSymbols.contains(symbol)) {                    // Проверяем, входит ли переданный символ в наш алфавит;
            int index = listSymbols.indexOf(symbol) + key;    // Создаем индекс, который равняется индексу текущего элемента + сдвигаемое кол-во символов;
            if (index > 72)
                index = key - 1;                    // Если индекс больше 72(алфавил "закончился"), индекс равняется key - 1 (из-за отсчета от 0);
            else if (index < 0)
                index += 73;                        // Если ключ был отрицательный и индекс стал отрицательным добавляем 73, что бы получит актуальный индекс элемента
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
