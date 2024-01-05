package com.example.problems;

import java.util.HashSet;
import java.util.Set;

public class CheckIsogram {
    public static void main(String[] args) {
        String input = "pen";
        System.out.println("isIsogram: " + isIsogram(input));
    }

    private static boolean isIsogram(String s) {
        boolean isogram = true;
        final char[] charArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (Character c : charArray) {
            if (set.contains(c)){
                isogram = false;
            }
            else {
                set.add(c);
            }
        }
        return isogram;

    }
}
