package com.example.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * In Bakery department: From 8 to 10
 * In Checkout department: From 10 to 12
 * In Diary department: From 14 to 19
 *
 * Sudo Code
 * 1. Sort the given list of shifts
 * 2. outer for-loop to interate on the list
 * 3. get the startTime and endTime for the current shift
 * 4. inner for-loop to compare each shift with rest of shifts in the list
 * 5. if currentShift.getEndTime() == nextShift.getStartTime()
 * 6.    endTime = nextShift.getEndTime();
 *       currentShift = nextShift;
 *       i=j;
 * 7. Add the shiftSegment to result shift List
 * 8. return the result shift list
 */
public class ScheduleDemo {
    private final List<Shift> inputShifts = new ArrayList<>();

    public static void main(String[] args) {
        // Load data
        ScheduleDemo demo = new ScheduleDemo();
        Shift shift1 = new Shift(8, 10);
        Shift shift2 = new Shift(10, 11);
        Shift shift3 = new Shift(11, 12);
        Shift shift4 = new Shift(14, 18);
        Shift shift5 = new Shift(18, 19);
        Shift shift6 = new Shift(20, 22);
        List<Shift> inputData = List.of(shift1, shift2, shift3, shift4, shift5, shift6);
        demo.loadShiftData(inputData);
        System.out.println("Continuous shift" + demo.getContinuousShiftList());
        System.out.println("Continuous shift1" + demo.getContinuousShiftList1());
    }

    public List<Shift> getContinuousShiftList1() {
        //sort the shift
        final List<Shift> shiftList = inputShifts.stream()
                .sorted(Comparator.comparing(Shift::getStartTime))
                .collect(Collectors.toList());
        LinkedList<Shift> result = new LinkedList<>();
        result.addFirst(shiftList.get(0));
        // loop to compare
        for (Shift shift : shiftList){
            Shift last = result.getLast();
            System.out.println("\nLast: "+last);
            System.out.println("Current: "+shift);
            if (shift.getStartTime() == last.getEndTime()){
                last.setEndTime(shift.getStartTime());
                result.removeLast();
                result.addLast(last);
            }
            if (shift.getStartTime() > last.getEndTime()){
                result.addLast(shift);
            }
            System.out.println("So far added: "+result);
        }
        return result;
    }

    public List<Shift> getContinuousShiftList() {
        //sort the shift
        final List<Shift> shiftList = inputShifts.stream()
                .sorted(Comparator.comparing(Shift::getStartTime))
                .collect(Collectors.toList());
        List<Shift> result = new ArrayList<>();
        // loop to compare
        for (int i = 0; i < shiftList.size(); i++) {
            System.out.println("Shift " + i + "");
            Shift currentShift = shiftList.get(i);
            int startTime = currentShift.getStartTime();
            int endTime = currentShift.getEndTime();
            Shift shiftSegment = new Shift();
            for (int j = i+1; j <= shiftList.size()-1; j++) {
                System.out.println("-- Shift " + j + "");
                Shift nextShift = shiftList.get(j);
                if (currentShift.getEndTime() == nextShift.getStartTime()) {
                    endTime = nextShift.getEndTime();
                    currentShift = nextShift; // move the current position to the next position
                    i=j;  // to move the outer for loop forward to merge the continuous shift
                }
            }
            shiftSegment.setStartTime(startTime);
            shiftSegment.setEndTime(endTime);
            result.add(shiftSegment);
        }
    return result;
    }


    public void loadShiftData(List<Shift> shiftList){
        inputShifts.addAll(shiftList);
    }

    public List<Shift> getShiftData() {
        return inputShifts;
    }

}
