package ru.stepik.javaBasicCourse;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StepikJavaBasic_6_2_10 {

    public static void main(String[] args) {

        int[] arrInt1 = {1,2,3};
        int[] arrInt2 = {1,2,3};

        List<Integer> listInt1 = new ArrayList<>();
        listInt1.add(1);
        listInt1.add(2);
        listInt1.add(3);
        List<Integer> listInt2 = new ArrayList<>();
        listInt2.add(1);
        listInt2.add(2);
        listInt2.add(3);


        System.out.println(arrInt2.equals(arrInt1));
        System.out.println(Arrays.equals(arrInt1, arrInt2));

        System.out.println(listInt1.equals(listInt2));
        System.out.println(Arrays.equals(listInt1.toArray(), listInt2.toArray()));

        for (int i : arrInt1) {
            System.out.println(i);
        }

        for (Integer i : listInt1) {
            System.out.println(i);
        }


    }

}
