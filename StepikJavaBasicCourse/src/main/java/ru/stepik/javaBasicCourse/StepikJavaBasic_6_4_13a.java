package ru.stepik.javaBasicCourse;
/*
Алексей Владыкин
Команда курса
Решение #16120670
16 сентября 2016 г., 23:52
 */
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StepikJavaBasic_6_4_13a {

    public static void main(String[] args) throws IOException {
        // Для чтения входного потока используем Scanner.
        // Поскольку словами мы считаем последовательности символов,
        // состоящие из букв или цифр, то в качестве разделителя слов Scanner'у
        // указываем регулярное выражение, означающее
        // "один или более символ, не являющийся ни буквой, ни цифрой".
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        // Пройдем по всем словам входного потока и составим Map<String, Integer>,
        // где ключом является слово, преобразованное в нижний регистр,
        // а значением - частота этого слова.
        Map<String, Integer> freqMap = new HashMap<>();
        scanner.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));

        freqMap.entrySet().stream()                 // получим стрим пар (слово, частота)
                .sorted(descendingFrequencyOrder()) // отсортируем
                .limit(10)                          // возьмем первые 10
                .map(Map.Entry::getKey)             // из каждой пары возьмем слово
                .forEach(System.out::println);      // выведем в консоль
    }

    // Создание Comparator'а вынесено в отдельный метод, чтобы не загромождать метод main.
    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
        // Нам нужен Comparator, который сначала упорядочивает пары частоте (по убыванию),
        // а затем по слову (в алфавитном порядке). Так и напишем:
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}
