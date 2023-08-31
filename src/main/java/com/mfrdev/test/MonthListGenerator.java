package com.mfrdev.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MonthListGenerator {
    public static void main(String[] args) {
        String startDateString = "2018-01-20";
        String endDateString = "2018-02-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter).plusMonths(1);

       LocalDate firstDate = getFirstDayOfMonth(startDate);
       LocalDate end = getLastDayOfMonth(endDate.plusMonths(1));

        System.out.println(firstDate+":"+end);

        Map<String, Double> monthList = generateMonthList(startDate, endDate);
      //  monthList.put("SEPTEMBER-2018",100d);

        System.out.println(monthList);
        System.out.println(monthList.size());
        System.out.println(isNumeric("21"));
    }

    private final static Pattern pattern = Pattern.compile("-?\\d+");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }


    public static LocalDate getLastDayOfMonth(LocalDate localDate){
        return localDate.withDayOfMonth(
                localDate.getMonth().length(localDate.isLeapYear()));
    }

    public static LocalDate getFirstDayOfMonth(LocalDate localDate){
        return localDate.withDayOfMonth(1);
    }

    public static Map<String, Double> generateMonthList(LocalDate startDate, LocalDate endDate) {
        Map<String, Double> monthList = new LinkedHashMap<>();

        while (!startDate.isAfter(endDate)) {
            String format = startDate.format(DateTimeFormatter.ofPattern("MMMM-yyyy"));
            monthList.put(format, 0D);
            startDate = startDate.plusMonths(1);
        }

        return monthList;
    }
}
