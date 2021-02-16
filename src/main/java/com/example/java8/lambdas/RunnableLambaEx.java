package com.example.java8.lambdas;

public class RunnableLambaEx {

    public static void main(String[] args) {
        //Prior Java8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Prior java8 run method");
            }
        };
        new Thread(runnable).start();

        //java8 lambda
        Runnable runnable1Lambda1 = () -> {
            System.out.println("Lambda 1");
        };
        Runnable runnable1Lambda2 = () -> System.out.println("Lambda 2");

        new Thread(runnable1Lambda1).start();
        new Thread(runnable1Lambda2).start();
        new Thread(() -> System.out.println("Lambda 3")).start();
    }

}
