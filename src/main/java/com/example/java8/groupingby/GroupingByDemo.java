package com.example.java8.groupingby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("hello", "NEW"),
                new Item("world", "NEW"),
                new Item("football", "IN_PROGRESS"),
                new Item("cricket", "COMPLETED"),
                new Item("swimming", "COMPLETED")
        );

        final Map<String, List<Item>> map = items.stream().collect(
                Collectors.groupingBy(Item::getStatus, Collectors.toList()));
        System.out.println(map);

    }
}
class Item{
    private String name;
    private String status;

    public Item(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
