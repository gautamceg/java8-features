package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int target = 9;
        int [] result = getTwoSum(num, target);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] getTwoSum(int[] num, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<num.length; i++){
            if (map.containsKey(target - num[i])){
                result[1] = i;
                result[0] = map.get(target - num[i]);
            }
            else {
                map.put(num[i], i);
            }
        }
        return result;
    }
}
