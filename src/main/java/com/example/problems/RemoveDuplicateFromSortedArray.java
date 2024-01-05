package com.example.problems;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] num = {0,0,1,1,1,2,2,3,3,4,5,5};
        System.out.println("removeDuplicate: " + removeDuplicate(num));

    }

    public static int removeDuplicate(int[] num) {
        int j=0;
        for (int i=0; i<num.length; i++){
            if (num[j] != num[i]){
                num[++j] = num[i];
            }
        }
        return ++j;
    }
}
