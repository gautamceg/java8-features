package com.example;

import com.example.test.ScheduleDemo;
import com.example.test.Shift;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TestScheduleDemo {

    @Test
    void testSchedule(){
        // Load data
        final ScheduleDemo demo = new ScheduleDemo();
        Shift shift1 = new Shift(8, 10);
        Shift shift2 = new Shift(10, 11);
        Shift shift3 = new Shift(11, 12);
        Shift shift4 = new Shift(14, 18);
        Shift shift5 = new Shift(18, 19);
        Shift shift6 = new Shift(20, 22);
        List<Shift> inputData = List.of(shift1, shift2, shift3, shift4, shift5, shift6);
        demo.loadShiftData(inputData);
        final List<Shift> resultShifts = demo.getContinuousShiftList();
        Assertions.assertEquals(8, resultShifts.get(0).getStartTime());
        Assertions.assertEquals(12, resultShifts.get(0).getEndTime());
    }
}
