package com.example.java8.function;

import java.util.function.Function;

public class FunctionInterfaceEx {

    static Function<String, String> function = (name) -> name.toUpperCase();
    static Function<String ,String> addDefault = (name) -> name.concat("-default");
    static Function<String ,String> one = (name) -> name.concat("-one");
    static Function<String ,String> two = (name) -> name.concat("-two");
    static Function<String ,String> three = (name) -> name.concat("-three");

    public static void main(String[] args) {
        System.out.println(function.apply("java8"));
        System.out.println(addDefault.compose(function).apply("gautam"));

        System.out.println(function.andThen(one).andThen(two).andThen(three).apply("mohan"));
        System.out.println(function.compose(addDefault).andThen(one).andThen(two).andThen(three).apply("shyam"));

    }
}
