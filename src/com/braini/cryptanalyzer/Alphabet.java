package com.braini.cryptanalyzer;

import java.util.ArrayList;
import java.util.List;

public  class Alphabet {

    private static List<Character> listSymbols = new ArrayList<>();

    {
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
}
