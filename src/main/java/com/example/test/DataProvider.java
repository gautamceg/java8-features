package com.example.test;

import java.util.ArrayList;
import java.util.List;



public class DataProvider {

    private List<Shift> inputShifts = new ArrayList<>();

    public void loadShiftData(Shift shift){
        inputShifts.add(shift);
    }

    public List<Shift> getShiftData() {
        return inputShifts;
    }
}
