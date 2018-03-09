package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_2_2_9 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(-2));
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        return value == 0 ? false : ( value & (value - 1) ) == 0;
    }
}
