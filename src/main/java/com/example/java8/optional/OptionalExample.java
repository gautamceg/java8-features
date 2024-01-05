package com.example.java8.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Item i1 = new Item(1, "Item 1");
        Item i2 = new Item(2, null);

        System.out.println("Testing-1:" + Optional.ofNullable(i1.getName()).isPresent());
        System.out.println("Testing-2:" + Optional.ofNullable(i2.getName()).map(String::toUpperCase).orElse("empty"));


    }
}

class Item{
    private int id;
    private String name;

    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
