package com.example.problems;

import java.time.LocalTime;

/**
 * 12 hr clock
 * Input: Time, (am/pm), hrs to be added
 * Example: 11 am + 2 hrs = 1 pm
 */
public class TimeCalculator {
    public static void main(String[] args) {
        int currHrs = 11;
        boolean meridian = false;
        int hrsToAdd = 8;
        System.out.println("Calculated Time1: "+ calculateTime1(currHrs, meridian, hrsToAdd));
        System.out.println("Calculated Time2: "+ calculateTime2(currHrs, "PM", hrsToAdd));
    }

    private static String calculateTime1(int currHrs, boolean meridian, int hrsToAdd) {
        int hr24= meridian ? currHrs : currHrs + 12;
        int sum24Hrs = LocalTime.of(hr24, 00).plusHours(hrsToAdd).getHour();
        System.out.println("sum24Hrs: "+ sum24Hrs);
        String meridianStr;
        // Finding out the Meridien of time
        // ie. AM or PM
        if (sum24Hrs < 12) {
            meridianStr = "AM";
        }
        else
            meridianStr = "PM";

        sum24Hrs = sum24Hrs % 12;
        return sum24Hrs + " " + meridianStr;

    }

    private static String calculateTime2(int currHrs, String meridian, int hrsToAdd) {
        int hr24= meridian.equalsIgnoreCase("AM") ? currHrs : currHrs + 12;
        int sum24Hrs = LocalTime.of(hr24, 00).plusHours(hrsToAdd).getHour();
        System.out.println("sum24Hrs: "+ sum24Hrs);
        String meridianStr;
        // Finding out the Meridien of time
        // ie. AM or PM
        if (sum24Hrs < 12) {
            meridianStr = "AM";
        }
        else
            meridianStr = "PM";

        sum24Hrs %= 12;
        return sum24Hrs + " " + meridianStr;

    }

    private static String calculateTime3(int currHrs, String meridian, int hrsToAdd) {
        int hr24= meridian.equalsIgnoreCase("AM") ? currHrs : currHrs + 12;
        int sum24Hrs = LocalTime.of(hr24, 00).plusHours(hrsToAdd).getHour();
        System.out.println("sum24Hrs: "+ sum24Hrs);
        String meridianStr;
        // Finding out the Meridien of time
        // ie. AM or PM
        if (sum24Hrs < 12) {
            meridianStr = "AM";
        }
        else
            meridianStr = "PM";

        sum24Hrs %= 12;
        return sum24Hrs + " " + meridianStr;

    }
}


