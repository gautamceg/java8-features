package com.example.leetcode;

import java.util.Arrays;

public class SortColor {
    public static void main(String[] args) {
        int[] color = {2,0,2,1,1,0};
        int[] sortedColor = sortColor(color);
        Arrays.stream(sortedColor).forEach(System.out::println);
    }

    //brute force approach Time complexity = O(n2)
    private static int[] sortColor(int[] color){
        for (int i=0; i<color.length;i++){
            for (int j=i+1; j<color.length;j++){
                if (color[i] >= color[j]){
                    int temp = color[i];
                    color[i] = color[j];
                    color[j] = temp;
                }
            }
        }
        return color;
    }
}

