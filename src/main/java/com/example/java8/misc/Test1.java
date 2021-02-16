package com.example.java8.misc;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        //list1
        List<Integer> list1 = Arrays.asList(new Integer[]{1,8,19,2,4});
        Collections.sort(list1);
        System.out.println(list1);

        //list2
        List<Integer> list2 = Arrays.asList(1,1,8,19,2,4);
        Collections.sort(list2);
        System.out.println(list2);

        //list3
        List<String> list3 = Arrays.asList("A", "Z", "K", "B");
        Collections.sort(list3);
        System.out.println(list3);

        //set1
        Set<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(5);
        set1.forEach(System.out::println);
        System.out.println("Get 5 from set1: "+ set1);
    }
}
