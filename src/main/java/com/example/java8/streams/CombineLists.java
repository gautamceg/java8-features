package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineLists {
    public static void main(String[] args) {
        List<Shift> shifts = Arrays.asList(new Shift("1", "oneShift"), new Shift("2", "twoShift"));
        List<Overtime> overtimes = Arrays.asList(new Overtime("1", "oneOver"), new Overtime("3", "threeOver"));

        List<Schedule> schedules = shifts.stream()
                .map(shift -> overtimes.stream()
                        .filter(overtime -> shift.getId().equals(overtime.getId()))
                        .map(overtime -> new Schedule(shift.getId(), shift.getName() + overtime.getName()))
                        .findAny()
                        .orElse(new Schedule(shift.getId(), shift.getName()))
                ).collect(Collectors.toList());
        System.out.println(schedules);

        final List<Shift> shiftList = shifts.stream()
                .peek(shift -> {
                            overtimes.stream()
                                    .filter(overtime -> overtime.getId().equals(shift.getId()))
                                    .peek(overtime -> shift.setName(shift.getName() + overtime.getName()));
                        }
                ).collect(Collectors.toList());
        System.out.println(shiftList);
    }
}

class Shift {
    private String id;
    private String name;

    Shift(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Overtime {
    private final String id;
    private final String name;

    Overtime(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Schedule {
    private String id;
    private String name;

    Schedule(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}