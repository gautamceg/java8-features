package com.example.test3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Result2 {

    public static void main(String[] args) {
        List<String> dates = List.of("1st Mar 1974", "22nd Mar 1974");
        preprocessDate(dates);
    }

    public static List<String> preprocessDate(List<String> dates) {
        // Write your code here
        for(String date: dates){
            final String[] input = date.split(" ");
            //1st Mar 1974
            String day = input[0];
            String month = input[1];
            String year = input[2];

            int formattedDay = Integer.valueOf(day.substring(0, day.length()-2));
            String formattedMonth = month;
            final String formattedDayInt = (formattedDay < 10 ? "0" : "") + formattedDay;
            final String inputDate = year + "-" + formattedMonth + "-" + formattedDayInt;
            System.out.println(inputDate);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
            String resultDate = LocalDate.parse(inputDate, dateTimeFormatter).toString();

        }
        return dates;

    }
}
