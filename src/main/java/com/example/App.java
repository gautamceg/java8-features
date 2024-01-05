package com.example;

import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void DoPrint(Base o){
        o.print();
    }
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Base x = new Base();
        Base y = new Derive();
        Derive z = new Derive();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);

    }
}
class Base{
    public void print(){
        System.out.println("Base");
    }
}
class Derive extends Base{
    public void print(){
        System.out.println("Derive");
    }
}
