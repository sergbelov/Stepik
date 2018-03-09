package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_2_1_6 {

    public static void main(String[] args) {
        System.out.println(booleanExpression(false, false, false, false));
        System.out.println(booleanExpression(true, true, true, true));
        System.out.println(booleanExpression(false, false, true, true));
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a^b && c^d) | (a^c && b^d) | (a^d && b^c);
    }
}
