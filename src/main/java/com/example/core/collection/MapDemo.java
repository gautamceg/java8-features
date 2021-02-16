package com.example.core.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        final Map<String,String > headers = new HashMap<>();
        headers.put("one","hey");
        final InputModel input = new InputModel();
        input.setHeaders(headers);
        updateMap(input);
        System.out.println("Updated headers: " + headers);

    }

    private static void updateMap(final InputModel input) {
        final Map<String,String > headers = input.getHeaders();
        headers.put("two", "2");
    }
}
