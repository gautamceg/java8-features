package com.example.java8.streams;
/***
 * Reference - https://github.com/gautamceg/functional-programming-with-java/blob/master/code.md
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,13,15,1,2,3,5,4,5,6,7,8,9,10);

        Integer sum = numbers.stream().filter(num -> num%2==0).reduce(0, (a, b) -> a + b);
        System.out.println("sum="+sum);
        //another way
        Integer sum1 = numbers.stream().reduce(0, SumOfList::sum);
        System.out.println("sum1="+sum1);
        // map and reduce
        Integer mapReduce = numbers.stream().map( x -> x * x).reduce(0, (x,y) -> x + y);
        System.out.println("mapReduce="+mapReduce);
        // distinct
        numbers.stream().distinct().forEach(System.out::println);
        // sorted
        numbers.stream().distinct().sorted().forEach(System.out::println);
        // doubleList
        List<Integer> squareNumbers = squareNumbers(numbers);
        System.out.println("squareNumbers="+squareNumbers);


    }

    private static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber){
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }
}
