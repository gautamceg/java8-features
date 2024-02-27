package com.example.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * int[] input = {1, 6, 3, 2, 5, 5, 7, 8, 4, 8, 2, 5, 9, 9, 1};int target = 10;
 * (1,9)(1,9)(6,4)(3,7)(2,8)(2,8)(5,5)(5,5)(5,5)(8,2)(8,2)(9,1)(9,1)
 */
public class SumExample {
    public static void main(String[] args) {
        int[] input = {1, 6, 3, 2, 5, 5, 7, 8, 4, 8, 2, 5, 9, 9, 1};
        int target = 10;
        List<Integer> list = Arrays.asList(1, 6, 3, 2, 5, 5, 7, 8, 4, 8, 2, 5, 9, 9, 1);
        for (int i=0; i<input.length; i++){
            int secondValue = target - input[i];
            if (list.contains(secondValue)){
                System.out.print("(" + input[i] + "," + secondValue + ") ");
            }
            else {

            }
        }
    }
}
