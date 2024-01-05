package com.example.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Example {
    public static void main(String[] args) {

        LocalDateTime ed = LocalDateTime.now().minusMinutes(5);
        System.out.println(ed.isAfter(LocalDateTime.now()));
    }
}
