package com.example.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListExample
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));

        List<String> combinedList = Stream.of(listOne, listTwo)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(combinedList);
    }
}
