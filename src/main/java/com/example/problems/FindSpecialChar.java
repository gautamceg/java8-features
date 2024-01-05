package com.example.problems;

public class FindSpecialChar {
    public static void main(String[] args) {
        String input = "CloudTech#!*";
        int count = 0;
        String specialCharRemoved = "";

        for (int i = 0; i <input.length(); i++) {
            if (!Character.isAlphabetic(input.charAt(i)) || Character.isDigit(input.charAt(i))
                                                         || Character.isSpaceChar(input.charAt(i))){
                count++;

            }
            else {
                specialCharRemoved = specialCharRemoved + input.charAt(i);
            }
        }
        if (count == 0) {
            System.out.println("No special characters");
        }
        else {
            System.out.println("Special characters count: " + count);
            System.out.println("Special characters removed: " + specialCharRemoved);
        }

        //is Rotation
        String str1 = "ABCD";
        String str2 = "CDAB";
        System.out.println("Is Rotation: " + isRotation(str1, str2));
    }

    private static boolean isRotation(String s1, String s2){
        return (s1.length() == s2.length()) && ((s1 + s1).contains(s2));
    }
}
