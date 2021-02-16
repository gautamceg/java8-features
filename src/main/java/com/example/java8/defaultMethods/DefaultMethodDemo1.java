package com.example.java8.defaultMethods;

//When two interface has same default method then non-abstract class will be asked to implement it
interface JustInt1{
    default void print(){
        System.out.println("JustInt1 - Default");
    }
}
interface JustInt2{
    default void print(){
        System.out.println("JustInt2 - Default");
    }
}
abstract class JustAbs implements JustInt1, JustInt2{
    @Override
    public void print() {
        System.out.println("JustAbs - Default");
    }
}
public class DefaultMethodDemo1 implements JustInt1, JustInt2{
    @Override
    public void print() {
        System.out.println("Implemented - Default");
    }
}
