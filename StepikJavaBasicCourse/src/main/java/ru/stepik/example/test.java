package ru.stepik.example;

import java.util.stream.IntStream;

public class test {

    public static void main(String[] args) {

        int sum = IntStream.iterate(1, n -> n +1)
                .filter(n -> n%5==0 && n%2 != 0)
                .limit(2)
//                .map(n -> n * n)
                .sum();

        System.out.println(sum);
    }
}
