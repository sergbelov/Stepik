package ru.stepik.javaBasicCourse;

import java.util.*;

public class StepikJavaBasic_6_2_14 {

    public static void main(String[] args) {

        Set<Integer> set1 = new LinkedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        Set<Integer> setNew = symmetricDifference(set1, set2);

        Iterator iteratorNew = setNew.iterator();
        while (iteratorNew.hasNext()){
            System.out.println(iteratorNew.next());
        }
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setNew = new HashSet<>(set1);
        setNew.addAll(set2);

        Set<T> setOverlap = new HashSet<>(set1);
        setOverlap.retainAll(set2);

        setNew.removeAll(setOverlap);

        return (Set<T>) setNew;
    }
}
