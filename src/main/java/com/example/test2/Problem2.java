package com.example.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given two strings:
 * S1=’Today is Thursday’
 * S2=’Thirsty’
 * Write an algorithm called canConstruct(S1, S2): boolean that returns a true if the word in S2 can be constructed using the letters in S1.
 * In the example above, a true should be returned since all the letters in T-H-I-R-S-T-Y can be found in S1.
 * If, for example, S2 was ‘DATE’, a false would be returned since there is no ‘E’ in S1.
 */
public class Problem2 {
    public static void main(String[] args) {
        String s1="Today is Thursday";
        String s2= "Thirsty";
        final char[] s1CharArray = s1.toCharArray();
        Arrays.asList(s1CharArray);

        List<Character> charListS1 =  getCharList(s1.toLowerCase());
        List<Character> charListS2 =  getCharList(s2.toLowerCase());

        final List<Character> collect = charListS2.stream().filter(charListS1::contains).collect(Collectors.toList());
        System.out.println("Collect: " + collect.size());
        System.out.println("Result = " + (collect.size() == charListS2.size()));

    }

    private static List<Character> getCharList(String s1) {
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i< s1.length(); i++){
            charList.add(s1.charAt(i));
        }
        return charList;
    }
}
