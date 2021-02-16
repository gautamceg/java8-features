package com.example.java8.multithreading;

import java.util.*;
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * RUNNING
         * FAILED
         * TERMINATED
         * COMPLETED
         */
        final ExecutorService executorService = Executors.newFixedThreadPool(4);

        final Callable<Map<String, Integer>> running = () -> doSomething("RUNNING");
        final Callable<Map<String, Integer>> failed = () -> doSomething("FAILED");
        final Callable<Map<String, Integer>> terminated = () -> doSomething("TERMINATED");
        final Callable<Map<String, Integer>> completed = () -> doSomething("COMPLETED");
        final List<Callable<Map<String, Integer>>> callableList = Arrays.asList(running, failed, terminated, completed);

        try {
            final List<Future<Map<String, Integer>>> futureList = executorService.invokeAll(callableList);
            final Map<String, Integer> finalResult = new HashMap<>();
            for (Future future : futureList){
                if (future.isDone()){
                    final Map<String, Integer> map = (Map<String, Integer>) future.get(200, TimeUnit.MILLISECONDS);
                    finalResult.putAll(map);
                }
            }
            System.out.println("Result: " + finalResult);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        finally {
            executorService.shutdown();
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        }

    }

    private static Map<String, Integer> doSomething(final String status){
        final Random random = new Random(100);
        final int num = random.nextInt(1000);
        final Map<String, Integer> map = new HashMap<>();
        map.put(status, num);
        System.out.println(Thread.currentThread().getName());
        return map;
    }
}
