package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_2_4_9 {

    public static void main(String[] args) {
        int[] arrInt = mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3});
        for (int i : arrInt){
            System.out.println(i);
        }
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];

        int i=0, j=0;
        for (int r=0; r<res.length; r++) {

            if (i > a1.length-1) {
                int a = a2[j];
                res[r] = a;
                j++;
            }
            else if (j > a2.length-1) {
                int a = a1[i];
                res[r] = a;
                i++;
            }
            else if (a1[i] < a2[j]) {
                int a = a1[i];
                res[r] = a;
                i++;
            }
            else {
                int b = a2[j];
                res[r] = b;
                j++;
            }
        }
        return res;
    }
}
