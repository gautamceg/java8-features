package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void papiDateTimeFormatParseTest(){
        DateTimeFormatter PAPI_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        final String startDateTime ="2021-06-14T10:15:00.000Z";
        LocalDateTime sdt = LocalDateTime.parse(startDateTime, PAPI_DATE_TIME_FORMATTER);
        sdt = sdt.plusMinutes(120);
        System.out.println("sdt: "+sdt);
    }
}
