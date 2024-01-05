package com.example.problems;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestNum {
    public static void main(String[] args) {
        int[] numbers = {8,6,9,7,5,3};
        System.out.println("SecondLargestNum:" + secondLargestNumber(numbers));

    }

    private static int secondLargestNumber(int[] numbers){
        return Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
    }
}
