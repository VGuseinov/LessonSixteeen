package com.company;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {
        // File, FileWriter, FileReader
        // String, StringBuilder, StringBuffer
        // Math, Random
        // Классы-обертки
        // Серилизация

        // File
        // отностительный путь
        // абсолютный путь
        File f = new File("1.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        // чтобы получить размер файла
        System.out.println(f.length()); // метод length возвращает размер файла в байтах
        // дата изменения файла
        System.out.println(f.lastModified());
        // unix-time возвращат кол-во милисекунд прошедших с 01.01.1970
        f.setLastModified(124234234234l);
        // проверка скрытый/нескрытый
        System.out.println(f.isHidden());
        // путь к файлу
        System.out.println(f.getAbsoluteFile());

        // работа с папками
        // mkDir создает первую несуществубющую папку по указанному пути
        // mkDirs сздает псоледующие несуществующие папки по указанному пути
        File dir = new File("D:\\Guseinov\\test");
        if (!dir.exists()) {
            dir.mkdir();
        }
        // получение списка файлов внутри папки
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.print(file.getName());
            if (file.isDirectory()) {
                System.out.println(" (папка)");
            } else {
                System.out.println(" (файл)");
            }
        }
        list(dir, 0);

        // классы-обертки над  примитивными типами
        int i = 0;
        Integer x = i + 69;
        i = x - 12;
        double d = Double.parseDouble("12.7");
        System.out.println(d);
    }



    public static void list (File directory, int depth) {
        File[] files = directory.listFiles();
        for (File f : files) {
            printSpace9(depth);
            System.out.println(f.getName());
            if (f.isDirectory()) {
                list(f, depth + 1);
            }
        }
    }

    public static void printSpace9(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }
}
