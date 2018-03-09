package ru.stepik.javaBasicCourse;

import java.time.DayOfWeek;

public class StepikJavaBasic_6_1_10 {

    public static void main(String[] args) {

        Example example1 = new Example();
        Example<?> example2 = new Example<Object>();
        Example<Object> example3 = new Example<Object>();
        Example<DayOfWeek> example4 = new Example<DayOfWeek>();
        Example<? extends Integer> example5 = new Example<Integer>();
        Example<CharSequence> example6 = new Example<CharSequence>();

    }

    public static class Example<X> {
    }
}
