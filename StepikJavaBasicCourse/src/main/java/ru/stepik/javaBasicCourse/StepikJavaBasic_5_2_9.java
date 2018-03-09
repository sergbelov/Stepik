package ru.stepik.javaBasicCourse;

import java.io.IOException;

public class StepikJavaBasic_5_2_9 {
    public static void main(String[] args) throws IOException {
        int memChar = System.in.read();
        if (memChar != -1) {
            int curChar = -1;
            while ((curChar = System.in.read()) != -1) {
                if (memChar != 13 || curChar != 10) {
                    System.out.write(memChar);
                }
                memChar = curChar;
            }
            System.out.write(memChar);
            System.out.flush();
        }
    }
}