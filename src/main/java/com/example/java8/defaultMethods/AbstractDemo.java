package com.example.java8.defaultMethods;

interface Int1{
    void A();
}

abstract class Abs22{
    void A(){
        //
    }
}

public class AbstractDemo extends Abs22 implements Int1{
    @Override
    public void A() {

    }
}

