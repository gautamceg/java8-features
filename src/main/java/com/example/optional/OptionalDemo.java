package com.example.optional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OptionalDemo {
    public static void main(String[] args) {
        List<String> nonNullList = List.of("hello");
        List<String> nullList = null;

        //String test1 = Objects.requireNonNull(nullList).get(0);
        //System.out.println("test1: " + test1);  // NPE

        List<String> nullSafe = Optional.ofNullable(nullList).orElse(List.of(""));
        System.out.println("nullSafe: " + nullSafe.get(0));
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add(null);
        list.add("last");
        list.add(null);
        System.out.println("list: " + list);

        Set<String> set = new HashSet<>();
        set.add("first");
        set.add(null);
        set.add("last");
        set.add(null);
        System.out.println("set: " + set);
    }
}
