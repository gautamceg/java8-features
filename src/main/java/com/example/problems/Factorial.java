package com.example.problems;

public class Factorial {
    public static void main(String[] args) {
        System.out.print(getFactorial(4));
    }

    public static int getFactorial(int input){
        if(input == 0){
            return 1;
        }
        return input * getFactorial(input - 1);
    }
}
