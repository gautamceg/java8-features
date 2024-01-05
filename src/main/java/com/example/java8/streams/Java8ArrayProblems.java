package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8ArrayProblems {
    public static void secondHighestElement(int[] numbers) {
        final int result = Arrays.stream(numbers).distinct().sorted().skip(1).findFirst().getAsInt();
        System.out.println("secondHighestElement: "+result);
    }
    public static void fetchCommonElements(int[] arr1, int[] arr2) {
        final List<Integer> commonElements = Arrays.stream(arr1)
                .filter(arr1Element -> Arrays.stream(arr2).anyMatch(arr2Element -> arr2Element == arr1Element))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("commonElements: "+ commonElements);
    }
    public static void main(String[] args) {
        int[] numbers = {5,2,8,3,1,1};
        //find second highest number
        secondHighestElement(numbers);

        //fetchCommonElements
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,6,7,8,1};
        fetchCommonElements(arr1, arr2);

    }
}
