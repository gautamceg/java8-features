package com.example.java8.singleton;

// Java code for Bill Pugh Singleton Implementation
class InnerClassSingleton{
    private InnerClassSingleton() {
        // private constructor
    }

    // Inner class to provide instance of class
    private static class InnerSingleton {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerSingleton.INSTANCE;
    }
}
public class Singleton2 {
    public static void main(String[] args) {
        InnerClassSingleton s1 = InnerClassSingleton.getInstance();
        InnerClassSingleton s2 = InnerClassSingleton.getInstance();
        InnerClassSingleton s3 = InnerClassSingleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

}
