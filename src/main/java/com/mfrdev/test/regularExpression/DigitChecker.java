package com.mfrdev.test.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitChecker {
    public static boolean isNumberStr(String input) {
        if(input == null || input.isBlank()){
            return false;
        }
        // Define a regular expression pattern to match digits
        String regex = "\\d+";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Check if the input string contains only digits
        return matcher.matches();
    }

    public static void main(String[] args) {
        String testString1 = "12345"; // Contains only digits
        String testString2 = "abc123"; // Contains non-digit characters

        // Check the first string
        if (isNumberStr(testString1)) {
            System.out.println(testString1 + " contains only digits.");
        } else {
            System.out.println(testString1 + " contains non-digit characters.");
        }

        // Check the second string
        if (isNumberStr(testString2)) {
            System.out.println(testString2 + " contains only digits.");
        } else {
            System.out.println(testString2 + " contains non-digit characters.");
        }
    }
}
