package com.example.core;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        AA a1 = new AA();
        a1.name = "coffee";
        AA a2 = new AA();
        a2.name = "tea";
        TreeSet set = new TreeSet();
        set.add(a1); set.add(a2);
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getClass());
        }
    }
}

class AA implements Comparable{
    public String name;
    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
