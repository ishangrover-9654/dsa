package com.project.practice.javaconcepts;

public class ProtectedConcept {

    public static void main(String[] args) {

    }

    protected void method1(){ }


}


class CSuper {
    protected void method1(){ }
}

class Sub extends CSuper{
    CSuper a1 = new CSuper();

    public void method2(){
        a1.method1();
    }
}

class CAnother{
    CSuper a1 = new CSuper();

    public void method2(){
        a1.method1();
    }

}
