package ru.stepik.javaBasicCourse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepikJavaBasic_2_3_10 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        Pattern pattern  = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder(matcher.replaceAll("").toUpperCase());

        StringBuilder resultRev = new StringBuilder(result);
        resultRev.reverse();

        return resultRev.toString().equals(result.toString());
    }
}
