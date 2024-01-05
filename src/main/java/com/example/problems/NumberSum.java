package com.example.problems;

import java.util.Arrays;

public class NumberSum {
    public static void main(String[] args) {
        int[] nums = {1,5,6,9,10};

        final int summed = Arrays.stream(nums).sum();
        System.out.println("summed: "+summed);
    }
}
