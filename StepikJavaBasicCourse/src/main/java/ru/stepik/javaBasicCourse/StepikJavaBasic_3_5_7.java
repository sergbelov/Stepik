package ru.stepik.javaBasicCourse;

import java.util.function.DoubleUnaryOperator;

public class StepikJavaBasic_3_5_7 {

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int i;
        int n = 1000000;
        double result, h;
        result = 0;
        h = (b - a) / n; //Шаг сетки
        for(i = 0; i < n; i++) {
            result += f.applyAsDouble(a + h * (i + 0.5)); //Вычисляем в средней точке и добавляем в сумму
        }
        result *= h;
        return result;
    }
}
