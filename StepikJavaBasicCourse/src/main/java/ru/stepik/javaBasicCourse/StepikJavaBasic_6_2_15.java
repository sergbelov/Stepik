package ru.stepik.javaBasicCourse;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class StepikJavaBasic_6_2_15 {

    public static void main(String[] args) {
        ArrayDeque<Integer> data = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        int i = 0, p = 0;
        while (scanner.hasNext()) {
            try {
                i = Integer.parseInt(scanner.next());
                p++;
                if (p%2 == 0){
                    data.add(i);
                }
            } catch (NumberFormatException e) {};
        }

        Iterator iterator = data.descendingIterator();
        while (iterator.hasNext()){
/*
            System.out.write((byte)iterator.next());
            System.out.write(' ');
*/
            System.out.print((int)iterator.next());
            System.out.print(' ');
        }
//        System.out.flush();
    }
}
