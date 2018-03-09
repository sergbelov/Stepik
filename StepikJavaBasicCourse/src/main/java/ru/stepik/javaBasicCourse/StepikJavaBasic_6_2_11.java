package ru.stepik.javaBasicCourse;

import java.util.ArrayList;
import java.util.Collection;

public class StepikJavaBasic_6_2_11 {

    public static void main(String[] args) {
        Collection<?> collection = new ArrayList();
        Object object = new Object();

        collection.size();
        collection.clear();
        collection.toArray();
        collection.iterator();
        collection.remove(object);
        collection.contains(object);
    }

}
