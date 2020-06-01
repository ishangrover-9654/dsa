package com.project.practice.javaconcepts;

public class MultipleDefaultOps {
    public static void main(String[] args) {
        A a = new AImpl();
        a.printA();

        B b = () -> System.out.println("Lamba B");

        b.printB();
        }
    }


interface A{
    default void printA(){
        System.out.println("A");
    }

    default void printB(){
        System.out.println("B");
    }
}

interface B{
    default void printA(){
        System.out.println("A");
    }

    void printB();
}

class AImpl implements A{

}

/*class BImpl implements B{

}*/


