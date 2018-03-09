package ru.stepik.javaBasicCourse;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StepikJavaBasic_6_4_8 {

    public static void main(String[] args) throws IOException {

//        ByteStream
//        CharStream
//        StringStream
//        FloatStream

        LongStream longStream = LongStream.empty();

        DoubleStream doubleStream = DoubleStream.iterate(1, n -> n + 0.25).limit(10);
        doubleStream.forEach(System.out::println);

        IntStream intStream = IntStream.iterate(1, n -> n +1).limit(10);
        intStream.forEach(System.out::println);

        Path path = Paths.get("C:/TEMP");
        Stream<Path> stream = Files.walk(path);
        stream.forEach(System.out::println);

    }

}