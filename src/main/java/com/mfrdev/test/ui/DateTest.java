package com.mfrdev.test.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        // Example: Get day start and end for each day from a specific date until today
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2022-10-10"); // Replace with your desired start date
            Date currentDate = new Date();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (calendar.getTime().before(currentDate) || calendar.getTime().equals(currentDate)) {
                Date dayStart = getDayStart(calendar.getTime());
                Date dayEnd = getDayEnd(calendar.getTime());

                System.out.println("Date: " + sdf.format(calendar.getTime()));
                System.out.println("Day Start: " + dayStart);
                System.out.println("Day End: " + dayEnd);
                System.out.println();

                // Move to the next day
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Set time to midnight
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getDayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Set time to 23:59:59.999
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }

}
