package com.example.core;
class Exc0 extends Exception{}
class Exc1 extends Exc0{}
public class Test {
    public static void main(String[] args) {
        try{
            throw new Exc1();
        } catch (Exc0 exc0) {
            System.out.println("cauthg");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
