package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * @link https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] result = twoSum3(nums, target);
        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int num2 = target - nums[i];
            if (map.containsKey(num2)) {
                result[0] = i;
                result[1] = map.get(num2);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public static int[] twoSum3(int[] nums, int target){
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j< nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
