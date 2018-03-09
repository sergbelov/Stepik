package ru.stepik.example;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        int sum = IntStream.iterate(1, n -> n + 1)
                .filter(n -> n % 5 == 0 && n % 2 != 0)
                .peek(System.out::println) // для отладки
                .limit(3)
//                .map(n -> n * n)
                .sum();

        System.out.println(sum);





        Path path = Paths.get("C:/TEMP");
        try {
//            Stream<Path> stream1 = Files.list(path);
            Stream<Path> stream1 = Files.walk(path);

//            stream1.forEach(System.out::println);

            List<Path> pathList = stream1.collect(Collectors.toList());
            pathList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(factorial(3));

/*
        IntStream stream = ...;
        stream . filter (n -> n > 100)
                . mapToObj ( Integer :: toString )
                . flatMapToInt (s -> s. chars ())
                . distinct ()
                . sorted ()
                . skip (3)
                . limit (2);
*/

    }


    public static BigInteger factorial(int n){
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> BigInteger.valueOf(i))
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}


