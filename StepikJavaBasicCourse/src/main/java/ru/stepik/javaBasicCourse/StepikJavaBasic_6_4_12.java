package ru.stepik.javaBasicCourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StepikJavaBasic_6_4_12 {

    public static void main(String[] args) {

        List<Integer> listInteger = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            listInteger.add((int)(Math.random() * 100));
        }
        listInteger.forEach(System.out::println);

        BiConsumer<Integer, Integer> biConsumer = (min, max) -> {
            System.out.println("min value = " + min);
            System.out.println("max value = " + max);
        };
//        biConsumer.accept(100, 200);


        findMinMaxComparator instance = new findMinMaxComparator();

        findMinMaxTest(listInteger.stream(), instance);

/*
        System.out.println("min value = " +
                listInteger.stream()
                .min(instance::compare)
                .orElse(null));

        System.out.println("max value = " +
                listInteger.stream()
                        .max(instance::compare)
                        .orElse(null));
*/
    }


    public static <T> void findMinMaxTest(
            Stream<? extends T> stream,
            Comparator<? super T> order ) {

        List<T> listTmp = stream.collect(Collectors.toList());

        System.out.println("min value : " + listTmp.stream().min(order::compare).orElse(null));
        System.out.println("max value : " + listTmp.stream().max(order::compare).orElse(null));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> listTmp = stream.collect(Collectors.toList());

        minMaxConsumer.accept(
                listTmp.stream().min(order::compare).orElse(null),
                listTmp.stream().max(order::compare).orElse(null));
    }


    public static class findMinMaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer val1, Integer val2) {
            return val1.compareTo(val2);
        }
    }


}