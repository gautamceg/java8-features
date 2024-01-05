package com.example.problems;

import java.util.Scanner;

public class NumberToWordConverter {
    private static String numberToWord(int a){
        String word = "";
        String[] unitArray = {"zero","one","two","three","four","five","six","seven","eight","nine","ten",
                "eleven","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tensArray = {"zero","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","hundred"};
        if (a == 0){
            System.out.println("Zero");
        }
        if (a<0){
            String num = ""+a;
            num = num.substring(1);
            return "minus" + numberToWord(Integer.parseInt(num));
        }
        if ((a/1000000) >0){
            word = word + numberToWord(a/1000000) +"Million";
            a = a%1000000;
        }
        if ((a/1000) >0){
            word = word + numberToWord(a/1000) +"Thousand";
            a = a%1000;
        }
        if ((a/1000) >0){
            word = word + numberToWord(a/100) +"Hundred";
            a = a%100;
        }
        if (a>0){
            if (a<20){
                word = word + unitArray[a];
            }
            else {
                word = word + tensArray[a/10];
                if ((a%10) >0 ){
                    word = word + " - " + unitArray[a%10];

                }
            }
        }
        return word;
    }
    public static void main(String[] args) {
        System.out.println("Enter Number: ");
        Scanner sc = new Scanner(System.in);
        int number = 0;
        number = sc.nextInt();
        String word = numberToWord(number);

        System.out.println(word);


    }
}
