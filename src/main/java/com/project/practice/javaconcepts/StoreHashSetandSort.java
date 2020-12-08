package com.project.practice.javaconcepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

public class StoreHashSetandSort {

    public static void main(String[] args) {
        Set<Person> peoples = new HashSet<>();

        peoples.add(new Person("a", 5, "ad3", "o3"));
        peoples.add(new Person("a", 3, "ad1", "o1"));
        peoples.add(new Person("b", 2, "ad2", "o2"));
        peoples.add(new Person("d", 4, "ad4", "o4"));

        List<Person> per2 = peoples.stream().sorted(Comparator.comparing(Person::getName).
                thenComparingInt(Person::getSalary)).collect(Collectors.toList());

        System.out.println(per2);
    }

}

@Getter @Setter @AllArgsConstructor @ToString
class Person {
    String name;
    int salary;
    String address;
    String org;

}


