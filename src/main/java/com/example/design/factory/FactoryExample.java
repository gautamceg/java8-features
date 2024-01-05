package com.example.design.factory;

public class FactoryExample {
    public static void main(String[] args) {
        ProfessionFactory factory = new ProfessionFactory();
        final Profession profession = factory.getProfession("Teacher");
        profession.print();

    }
}
