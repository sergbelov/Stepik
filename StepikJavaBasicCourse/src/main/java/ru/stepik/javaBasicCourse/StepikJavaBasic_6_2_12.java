package ru.stepik.javaBasicCourse;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class StepikJavaBasic_6_2_12 {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("1");
        set.add("3");
        set.add("2");

        Iterator<String> iterator = set.iterator();


        for (Iterator<String> it = iterator; it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }

}
