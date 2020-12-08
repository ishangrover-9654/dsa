package com.project.practice.javaconcepts;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapCustomObjectAdd {
    public static void main(String[] args) {
        TreeMap<CustomOb, String> treeMap = new TreeMap<>(
                Comparator.comparing(CustomOb::getData).reversed());
        treeMap.put(new CustomOb("1"), "1st");
        treeMap.put(new CustomOb("2"), "2nd");
        treeMap.put(new CustomOb("3"), "3rd");
        treeMap.put(new CustomOb("4"), "4th");

        treeMap.forEach((key, val) -> System.out.println(key.getData()));
    }
}

@AllArgsConstructor
@Getter
class CustomOb  {

    String data;
}
