package com.example.design.singleton;

public class Gautam{
    private static Gautam instance = null;

    private Gautam(){
    }

    public static Gautam getSingletonInstance(){
        if(instance == null){
            synchronized(Gautam.class){
                instance = new Gautam();
            }
        }
        return instance;
    }

}
