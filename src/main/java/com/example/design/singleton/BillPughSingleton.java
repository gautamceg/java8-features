package com.example.design.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        BillPughSingleton ins1 = BillPughSingleton.getInstance();
        BillPughSingleton ins2 = BillPughSingleton.getInstance();
        System.out.println(ins1.hashCode());
        System.out.println(ins2.hashCode());
    }
}
