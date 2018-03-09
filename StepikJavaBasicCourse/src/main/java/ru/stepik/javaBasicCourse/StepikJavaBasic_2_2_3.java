package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_2_2_3 {

    public static void main(String[] args) {
        System.out.println(charExpression(32));
        System.out.println(charExpression(29));
    }

    public static char charExpression(int a) {
        return (char)((int)'\\' + a);
    }
}
