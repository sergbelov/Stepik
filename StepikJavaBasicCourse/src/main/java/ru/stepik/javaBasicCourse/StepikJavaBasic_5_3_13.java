package ru.stepik.javaBasicCourse;

import java.util.Scanner;

public class StepikJavaBasic_5_3_13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dSum = .0;
        while(scanner.hasNext()) {
            try {
                dSum = dSum + Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {};
        }
        System.out.format("%.6f", dSum);
    }
}
