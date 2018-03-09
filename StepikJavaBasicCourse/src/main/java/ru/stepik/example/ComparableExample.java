package ru.stepik.example;

import java.util.TreeSet;

public class ComparableExample {

    public static void main(String[] args) {
        TreeSet<ComparableTest> ex = new TreeSet<ComparableTest>();
        ex.add(new ComparableTest("Stive Global", 221));
        ex.add(new ComparableTest("Stive Global", 121));
        ex.add(new ComparableTest("Nancy Summer", 3213));
        ex.add(new ComparableTest("Aaron Eagle", 3123));
        ex.add(new ComparableTest("Barbara Smith", 88786));

        for (ComparableTest e : ex) {
            System.out.println("Str: " + e.str + ", number: " + e.number);
        }

//        ex.stream().forEach(System.out::println();
    }


    static class ComparableTest implements Comparable {

        String str;
        int number;

        ComparableTest(String str, int number) {
            this.str = str;
            this.number = number;
        }

/*
// сортировка по возрастанию
    @Override
    public int compareTo(Object obj) {
        ComparableTest entry = (ComparableTest) obj;

        int result = str.compareTo(entry.str);
        if(result != 0) {
            return result;
        }

        result = number - entry.number;
        if(result != 0) {
            return (int) result / Math.abs( result );
        }
        return 0;
    }
*/

/*
// сортировка по убыванию
    @Override
    public int compareTo(Object obj) {
        ComparableTest entry = (ComparableTest) obj;

        int result = entry.str.compareTo(str); // значения меняются местами
        if(result != 0) {
            return result;
        }

        result = entry.number - number; // значения меняются местами
        if(result != 0) {
            return (int) result / Math.abs( result );
        }
        return 0;
    }
*/

        @Override
        public int compareTo(Object obj) {
            ComparableTest entry = (ComparableTest) obj;

// сначала ищем позицию пробела с помощью функции indexOf(),
//после начиная с найденной позиции выкусываем подстроку
            String str1 = str.substring(str.indexOf(" "));
            String str2 = entry.str.substring(entry.str.indexOf(" "));

            // после получения подстрокой производим сравнение
            int result = str1.compareTo(str2);
            if (result != 0) {
                return result;
            }

            result = number - entry.number;
            if (result != 0) {
                return (int) result / Math.abs(result);
            }
            return 0;
        }

    }
}