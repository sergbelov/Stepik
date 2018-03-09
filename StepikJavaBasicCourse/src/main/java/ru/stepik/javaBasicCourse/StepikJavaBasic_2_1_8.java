package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_2_1_8 {

    public static void main(String[] args) {
        System.out.println(leapYearCount(100));
        System.out.println(leapYearCount(400));
        System.out.println(leapYearCount(25));
    }

    public static int leapYearCount(int year) {
        return year / 4 + year / 400 - year / 100;
    }
}
