package com.example.design.singleton;

/**
 * @link - https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public final class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance = null;

    public static ThreadSafeSingleton getInstance(){
        if (instance == null){
            synchronized (ThreadSafeSingleton.class){
                if (instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton ins1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton ins2 = ThreadSafeSingleton.getInstance();
        System.out.println(ins1.hashCode());
        System.out.println(ins2.hashCode());
    }


}
