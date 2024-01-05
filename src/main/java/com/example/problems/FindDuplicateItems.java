package com.example.problems;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateItems {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("alpha", "beta", "gama", "beta");
        final List<String> duplicates = getDuplicates(items);
        System.out.println("duplicates: "+duplicates);
        System.out.println("map duplicates: "+getDuplicateMap(items));
        System.out.println("Get duplicate names only : "+getDuplicateNameOnly(items));
        System.out.println("Get duplicate names only using frequency : "+getDuplicateNameOnlyUsingFrequency(items));
    }

    @NotNull
    private static List<String> getDuplicates(List<String> items) {
        Set<String> uniqueNames = new HashSet<>();
        final List<String> duplicates = items.stream()
                .filter(item -> !uniqueNames.add(item))
                .collect(Collectors.toList());
        return duplicates;
    }

    private static Map<String, Long> getDuplicateMap(List<String> items) {
        return items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Set<String> getDuplicateNameOnly(List<String> items) {
        return items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
    private static Set<String> getDuplicateNameOnlyUsingFrequency(List<String> items) {
        return items.stream()
                .filter(item -> Collections.frequency(items,item) > 1)
                .collect(Collectors.toSet());
    }
}
