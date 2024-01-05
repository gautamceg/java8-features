package com.example.java8.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        Item i1 = new Item("1", "Red", "New", LocalDate.of(3022, 1, 1));
        Item i2 = new Item("2", "Blue", "New", LocalDate.of(2023, 1, 1));
        Item i3 = new Item("3", "Green", "New", LocalDate.of(3024, 1, 1));
        Item i4 = new Item("4", "Red", "Retry", LocalDate.of(2020, 1, 1));
        Item i5 = new Item("5", "Green", "Retry", LocalDate.of(2021, 1, 1));
        Item i6 = new Item("6", "Yellow", "New", LocalDate.of(3021, 1, 1));
        Item i7 = new Item("7", "Yellow", "Retry", LocalDate.of(2021, 1, 1));
        List<Item> items = Arrays.asList(i1, i2, i3, i4, i5, i6, i7);

        GroupingExample ge = new GroupingExample();
        ge.findLatestItem1(items);

    }

    private void findLatestItem1(List<Item> items) {
        final List<String> oldIds = items
                .stream()
                .collect(Collectors.groupingBy(Item::getColour))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry ->
                        entry.getValue()
                                .stream()
                                .sorted(Comparator.comparing(Item::getDate).reversed())
                                .skip(1)
                                .map(Item::getId)
                                .collect(Collectors.toList())
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("output: " + oldIds);
    }

    private void findLatestItem(List<Item> items) {
        final Map<String, List<Item>> listMap = items
                .stream()
                .collect(Collectors.groupingBy(Item::getColour));

        final List<String> finalIgnoreList = new ArrayList<>();

        for (Map.Entry<String, List<Item>> entry : listMap.entrySet()) {
            final List<Item> itemList = entry.getValue();
            if (itemList.size() > 1) {
                final List<String> ignoredIds = itemList.stream()
                        .sorted(Comparator.comparing(Item::getDate).reversed())
                        .skip(1)
                        .map(Item::getId)
                        .collect(Collectors.toList());
                finalIgnoreList.addAll(ignoredIds);
            }

        }


        System.out.println("output: " + finalIgnoreList);
        //output: [4, 7, 5]
    }


}

class Item {
    private String id;
    private String colour;
    private String status;
    private LocalDate date;

    public Item(String id, String colour, String status, LocalDate date) {
        this.id = id;
        this.colour = colour;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", colour='" + colour + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
