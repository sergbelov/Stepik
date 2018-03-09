package ru.stepik.javaBasicCourse;

import java.util.*;

public class StepikJavaBasic_6_4_13_2 {

    public static void main(String[] args) {

        String input = "Мама мыла-мыла-мыла раму!";
//        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        Scanner scanner = new Scanner(input).useDelimiter("[^\\p{L}\\p{Digit}]+");
/*
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");
//                .useDelimiter("[\\s\\p{Punct}]+");
*/
        Map<String, Integer> words = new TreeMap<>();

        scanner.forEachRemaining(s -> words.merge(s.toLowerCase(), 1, Integer::sum));

        words.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(10)

//                .map(Map.Entry::getKey)
//                .forEach(System.out::println);

                .forEach(o -> System.out.println(o.getKey() +" : "+ o.getValue()));
    }

}