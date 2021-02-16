package com.example.core.array;

public class TestValue {

    public static void main(String[] args) {
        String[] color = {"red", "blue", "green"};
        update(color);
        for(String c : color){
            System.out.println(c);
        }

    }

    private static void update(String[] color){
        color[0]= "white";
    }
}
