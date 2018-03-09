package ru.stepik.javaBasicCourse;

import java.math.BigInteger;

public class StepikJavaBasic_2_4_8 {

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(3));
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= value; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
