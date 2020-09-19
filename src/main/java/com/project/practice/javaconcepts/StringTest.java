package com.project.practice.javaconcepts;

public class StringTest {
    public static void main(String[] args) {
        String a = "123";
        //String b = "123";
        //String c = "123";


        String b = a;
        System.out.println(a==b);

        b="1233";

        System.out.println(a);
        System.out.println(b);
    }
}
