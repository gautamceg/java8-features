package com.example.java8.singleton;

// Java code to explain double check locking
class DoubleCheckSingleton{
    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
        // private constructor
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            //synchronized block to remove overhead
            synchronized (DoubleCheckSingleton.class) {
                if(instance==null) {
                    // if instance is null, initialize
                    instance = new DoubleCheckSingleton();
                }

            }
        }
        return instance;
    }
}
public class Singleton1 {
    public static void main(String[] args) {
        DoubleCheckSingleton s1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton s2 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton s3 = DoubleCheckSingleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}

