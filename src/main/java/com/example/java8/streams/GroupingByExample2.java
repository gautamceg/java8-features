package com.example.java8.streams;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByExample2 {
    public static void main(String[] args) {
        testDuplicates();
    }

    private static void testDuplicates() {
        Person p1 = new Person("John", 30, "John-Father", 1, List.of("c1", "c2"), "RETRY");
        Person p2 = new Person("Rob", 35, "Rob-Father", 2, List.of("c3", "c4"), "NEW");
        Person p3 = new Person("John", 30, "John-Father", 3, List.of("c1", "c2"), "NEW");
        Person p4 = new Person("Tim", 45, "Tim-Father", 4, List.of("c5", "c6"), "NEW");
        Person p5 = new Person("John", 30, "John-Father", 5, List.of("c1", "c2"), "NEW");
        final List<Person> personList = List.of(p1, p2, p3, p4, p5);
        final List<Person> duplicates = getDuplicates(personList);
        System.out.println("Duplicates: " + duplicates);
    }

    private static List<Person> getDuplicates(final List<Person> personList) {
        return getDuplicatesMap(personList).values().stream()
                .filter(duplicates -> duplicates.size() > 1)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Person::getOrder).reversed())
                .skip(1)
                .collect(Collectors.toList());
    }

    private static Map<String, List<Person>> getDuplicatesMap(List<Person> personList) {
        return personList.stream().collect(groupingBy(Person::uniqueAttributes));
    }

    static class Person {
        private String name;
        private int age;
        private String fatherName;
        private int order;
        private List<String> children;

        private String status;

        String uniqueAttributes() {
            String childrenStr = children == null ? "" : String.join(",", children).toLowerCase();
            String uniqueAttributes = String.format("%s:%s:%s", name, fatherName, childrenStr);
            System.out.println("unique attributes: " + uniqueAttributes);
            return uniqueAttributes;
        }

        public Person(
                String name, int age, String fatherName, int order, List<String> children, String status) {
            this.name = name;
            this.age = age;
            this.fatherName = fatherName;
            this.order = order;
            this.children = children;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public List<String> getChildren() {
            return children;
        }

        public void setChildren(List<String> children) {
            this.children = children;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Person{"
                    + "name='"
                    + name
                    + '\''
                    + ", age="
                    + age
                    + ", fatherName='"
                    + fatherName
                    + '\''
                    + ", order="
                    + order
                    + ", children="
                    + children
                    + ", status='"
                    + status
                    + '\''
                    + '}';
        }
    }
}
