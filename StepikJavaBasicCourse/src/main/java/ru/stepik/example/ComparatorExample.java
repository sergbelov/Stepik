package ru.stepik.example;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {

    public static void main(String[] args) {
        TreeSet<String> ex = new TreeSet<String>(new ComparatorTest());
        ex.add(new String("Stive Global"));
        ex.add(new String("Stive Cooper"));
        ex.add(new String("Nancy Summer"));
        ex.add(new String("Aaron Eagle"));
        ex.add(new String("Barbara Smith"));

        Iterator<String> i = ex.iterator();

        while (i.hasNext()) {
            String ts = i.next();
            System.out.println("Str: " + ts);
        }
    }

    static class ComparatorTest implements Comparator<String> {

        @Override
        public int compare(String obj1, String obj2) {
            // поиск пробелов, для сортировки по фамилии
            int k = obj1.substring(obj1.indexOf(" "))
                    .compareTo(obj2.substring(obj2.indexOf(" ")));
            if (k == 0) {
                return obj1.compareTo(obj2);
            } else {
                return k;
            }
        }
    }

}