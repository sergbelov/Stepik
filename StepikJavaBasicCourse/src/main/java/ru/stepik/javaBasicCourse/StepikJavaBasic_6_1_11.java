package ru.stepik.javaBasicCourse;

import java.util.Optional;

public class StepikJavaBasic_6_1_11 {

    public static void main(String[] args) {
        Example example = new Example<>();
    }

    public static class Example<X> {
        public void someMethod(Object obj) {
            X obj2X = (X)obj;
            Optional<X> optional = Optional.empty();

//            X x = new X();
//            X[] x = new X();
//            if (obj instanceof X) {}
//            if (obj instanceof Optional<X>) {}
        }
    }
}
