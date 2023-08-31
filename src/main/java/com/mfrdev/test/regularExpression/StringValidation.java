package com.mfrdev.test.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {
    public static void main(String[] args) {
        String[] strings = {"ABC0", "DEF1", "1234", "AB01", "A001", "0A254","A10x14"};

       // String regex = "^(?:([A-Za-z]\\d+(?![A-Za-z]))\\d*|\\d{1,4})$";
       // String regex = "^(?:[A-Za-z]\\d+| [A-Za-z]+\\d+ |\\d{4})$";
        String regex = "^([A-Za-z]+)(\\d+)|\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        for (String s : strings) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                System.out.println("--------------------");
                System.out.println(s + " is valid");
                System.out.println();
                System.out.println(s +" Digit:: "+getDigitFormStr(s));
                System.out.println(s+ " OnlyStr:: "+getStrFormDStr(s));
                System.out.println();
            } else {
                System.out.println("-------------------------");
                System.out.println(s + " is invalid");
                System.out.println(s +" Digit:: "+getDigitFormStr(s));
                System.out.println(s+ " OnlyStr:: "+getStrFormDStr(s));
                System.out.println();
            }
        }
    }

    public static String getDigitFormStr(String str){
        return str.replaceAll("\\D+","");
    }
    public static String getStrFormDStr(String str){
        return str.replaceAll("[^A-Za-z]+", "");
    }

}
