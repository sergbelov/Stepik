package question;

import java.util.*;

public class authorizationTest1 {

    static class A1{
        public static <T> T getFirstValue(T[] array){return array[0];}
    }

    class A2<T extends List<Number>>{}

    public static void main(String[] args) {

        Long[] a1_1 = {1L, 2L};
        long b1_1 = A1.getFirstValue(a1_1);

        Object[] a1_2 = new Object[10];
        Object b1_2 = A1.getFirstValue(a1_2);

//        int[] a = {1};
//        int b = A.getFirstValue(a);

//        Set<Integer> a = new HashSet<>();
//        Integer b = A.getFirstValue(a);

//        List<Integer> a = new ArrayList<>();
//        Integer b = A.getFirstValue(a);



        A2<ArrayList<Number>> a2_1;
        A2<List<Number>> a2_2;

//        A2<LinkedList<Object>> a2_3;
//        A2<List<Long>> a;
//        A2<LinkedList<Long>> a;
    }

}
