package com.example.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FaqInterview {
    public static void main(String[] args) {
        String input = "ILoveJavaProgrammingException";
        String[] arr = input.split("");
        // #1) Count all characters
        final Map<String, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("#1. CountChar: " + map);

        // #2) Find all duplicate elements in the string
        final List<String> duplicates = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("#2. duplicates: "+ duplicates);

        // #3) Find all unique elements in the string
        final List<String> uniques = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("#3. uniques: " + uniques);

        // #4) Find first non-repeated element in the string
        final String firstNonRepeated = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println("#4) firstNonRepeated: " + firstNonRepeated);

        // #5) Find second-highest element in the array
        int[] numbers = {3,9,4,25,68,88,35};
        final Integer secondHighestNumber = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("#5. secondHighestNumber: " + secondHighestNumber);

        // #6.1) Find longest element in the array
        String[] strArray = {"java", "SpringBoot", "SQL", "Microservices"};
        final String longestString = Arrays.stream(strArray)
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println("#6.1. longest-String: " + longestString);

        // #6.2) Find second-longest element in the array
        final String secondLongestString = Arrays.stream(strArray)
                .sorted((str1, str2) -> str1.length() > str2.length() ? -1 : 1)
                .skip(1)
                .findFirst()
                .get();
        System.out.println("#6.2. second-longest: " + secondLongestString);

        // #7) String.join() example
        final String joined = String.join("-", strArray);
        System.out.println("#7. Joined: " + joined);

        // #8) Skip and Limit example (2-9)
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);


    }
}
