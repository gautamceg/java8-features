package com.example.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EmployeeSalary {
    public static void main(String[] args) {
        Employee e1 = new Employee("Tom", 35, 25000.0);
        Employee e2 = new Employee("John", 21, 18000.0);
        Employee e3 = new Employee("Harry", 40, 50000.0);
        Employee e4 = new Employee("Rohan", 37, 25000.0);
        List<Employee> list = Arrays.asList(e1,e2,e3,e4);

        final Double salary = list.stream()
                .filter(emp -> emp.getSalary() > 30)
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Sum of conditional salary1: "+ salary);
        final Double sum = list.stream()
                .map(Employee::getSalary)
                .filter(empSalary -> empSalary > 30)
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println("Sum of conditional salary2: "+ sum);

        String input = "I love Java Programming";
        //Output :"Programming Java love I"
        StringBuilder sb = new StringBuilder(input);
        System.out.println(sb.reverse());

        //Problem: find second-highest salary
        System.out.println("Problem: find second-highest salary");
        System.out.println(secondHighestSalary(list));

        final int evenNumSum = Stream.of(1, 2, 3, 4, 5)
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Even number sum: "+ evenNumSum);
    }

    private static Double secondHighestSalary(List<Employee> list){
        return list.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(Double.valueOf(0L));
    }
}

class Employee{
    private String name;
    public int age;
    private Double salary;

    public Employee(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }


    public Double getSalary() {
        return salary;
    }
}
