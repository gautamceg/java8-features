package com.example.problems;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,5};
        System.out.println("Missing number: " + findMissingNumber(numbers));

    }

    private static int findMissingNumber(int[] numbers) {
        int n = numbers[numbers.length - 1];
        int sum = (n * (n + 1))/2;
        int actualSum = 0;
        for (int number : numbers) {
            actualSum = actualSum + number;
        }
        return sum - actualSum;
    }
}
