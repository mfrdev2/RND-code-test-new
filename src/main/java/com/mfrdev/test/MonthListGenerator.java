package com.mfrdev.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MonthListGenerator {
   static String mainQuery = "SELECT p " +
            "FROM Payslip p " +
            "INNER JOIN ErpUserContract c ON p.contractId = c.contractId " +
            "WHERE p.paymentStatus IN ('','paid','partial_payment','due') ";
    public static void main(String[] args) {
        String startDateString = "2018-01-20";
        String endDateString = "2018-02-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter).plusMonths(1);

        LocalDate firstDate = getFirstDayOfMonth(startDate);
        LocalDate end = getLastDayOfMonth(endDate.plusMonths(1));

        System.out.println(firstDate + ":" + end);

        Map<String, Double> monthList = generateMonthList(startDate, endDate);
        //  monthList.put("SEPTEMBER-2018",100d);

        System.out.println(monthList);
        System.out.println(monthList.size());
        System.out.println(isNumeric("21"));



        Map<String, String> requestBody = getRequestBody();
        Map<String, String> queryBody = getQueryBody();


        String query = getQuery(requestBody);
        System.out.println(query);

    }

    private static String getQuery(Map<String, String> requestBody ) {
        StringBuilder stringBuilder = new StringBuilder(mainQuery);
        for (Map.Entry<String, String> entry : requestBody.entrySet()) {
            String key = entry.getKey();
            String query = getQueryBody().getOrDefault(key, "");
            stringBuilder.append(query);
        }
        return stringBuilder.toString();
    }

    public static Map<String, String> getRequestBody() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("payeeType", "individual");
        map.put("payee", "1");
        map.put("team", "1");
        map.put("fundSource", "gob");
        map.put("paymentStatus", "due");
        map.put("month", "2023-01-23");
        map.put("dateForm", "2023-01-23");
        map.put("dateTo", "2023-01-23");
        map.remove("mont");
        return map;
    }

    public static Map<String, String> getQueryBody() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("payeeType", " AND c.typeOfConsultant = :payeeType");
        map.put("payee", " AND c.userId = :userId");
        map.put("team", " AND c.departmentId = :departmentId");
        map.put("fundSource", " AND c.fundSource = :fundSource");
        map.put("month", " AND p.salaryMonth >= :dateForm" + " AND p.salaryMonth <= :dateTo");
        map.put("dateForm", " AND p.salaryMonth >= :dateForm");
        map.put("dateTo", " AND p.salaryMonth <= :dateTo");
        map.put("paymentStatus", " AND p.paymentStatus <= :paymentStatus");
        return map;
    }

    private final static Pattern pattern = Pattern.compile("-?\\d+");


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }


    public static LocalDate getLastDayOfMonth(LocalDate localDate) {
        return localDate.withDayOfMonth(
                localDate.getMonth().length(localDate.isLeapYear()));
    }

    public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
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
