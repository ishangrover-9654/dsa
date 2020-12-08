package com.project.practice.javaconcepts;

public class SingltonConcepts {
    public static void main(String[] args) {

    }
}

class Singleton{
    private static volatile Singleton INSTANCE;
    private Singleton(){}
    public static Singleton getInstance(){
        if (INSTANCE==null){
            synchronized (Singleton.class){
                if (INSTANCE==null)
                    return new Singleton();
            }
            return new Singleton();
        }
        return INSTANCE;
    }
}
