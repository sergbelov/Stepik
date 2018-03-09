package ru.stepik.javaBasicCourse;

import java.util.stream.IntStream;

public class StepikJavaBasic_6_4_11 {

    public static void main(String[] args) {
//        System.out.println(mid(123456));
        pseudoRandomStream(13).forEach(System.out::println);
    }


    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> mid(n * n) )
                .limit(10); // Отладка

/*
        return IntStream.iterate(seed, n -> (n * n / 10) % 1000)
                .limit(10); // отладка
*/
/*
        return IntStream.iterate(seed, n -> ((n * n) % 10000) / 10)
                .limit(10); // отладка
*/
    }

    public static int mid(int val){
/*
        int r = (val - (val / 10000) * 10000) / 10;
        System.out.println("n = " + Math.sqrt(val));
        System.out.println("n*n = " + val);
        System.out.println("res = " + r);
*/

//        return (val - (val / 10000) * 10000) / 10;

        return (val % 10000) / 10;
    }

}