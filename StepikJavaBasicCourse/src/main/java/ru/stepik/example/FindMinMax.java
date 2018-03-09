package ru.stepik.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static ru.stepik.example.FindMinMax.BigDecimalMax.getBigDecimalMax;
import static ru.stepik.example.FindMinMax.BigDecimalMax.getBigDecimalMin;

public class FindMinMax {

    public static void main(String[] args) {

        List<BigDecimalMax.forTest> lst = new ArrayList<>();
        Random rn = new Random();
        BigDecimalMax bdm = new BigDecimalMax();

        for (int i = 1; i < 10; i++) {
//            lst.add(bdm.new forTest(i, BigDecimal.valueOf(rn.nextLong())));
            lst.add(bdm.new forTest(i, BigDecimal.valueOf((int) (Math.random() * 100))));
        }
        lst.forEach(System.out::println);

        System.out.println("======================");
        System.out.println("MinValue = " + getBigDecimalMin(lst));
        System.out.println("MaxValue = " + getBigDecimalMax(lst));

    }


    public static class BigDecimalMax {

        public static forTest getBigDecimalMin(List<forTest> list) {
            findMinMaxValue instance = new findMinMaxValue();
            return list.stream()
//                .filter(t -> t.id % 2 == 0)
                    .min(instance::compare)
                    .orElse(null);
        }

        public static forTest getBigDecimalMax(List<forTest> list) {
            findMinMaxValue instance = new findMinMaxValue();
            return list.stream()
//                .filter(t -> t.id % 2 == 0)
                    .max(instance::compare)
                    .orElse(null);
        }

        public static class findMinMaxValue implements Comparator<forTest> {

            @Override
            public int compare(forTest val1, forTest val2) {
                return val1.value.compareTo(val2.value);
//          return val2.value.compareTo(val1.value);
            }
        }


        class forTest {
            public int id;
            public BigDecimal value;

            forTest(int id, BigDecimal value) {
                this.id = id;
                this.value = value;
            }

            @Override
            public String toString() {
                return "forTest{" +
                        "id=" + id +
                        ", value=" + value +
                        '}';
            }
        }
    }
}