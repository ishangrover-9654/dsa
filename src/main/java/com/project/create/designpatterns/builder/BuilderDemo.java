package com.project.create.designpatterns.builder;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class BuilderDemo {


    public static void main(String[] args) {

        Base base = new BaseBuilder().fieldC("C").fieldB("B").fieldA("A").Build();
        System.out.println(base);
    }
}

@AllArgsConstructor @ToString
class Base {
    String fieldA;
    String fieldB;
    String fieldC;
}

class BaseBuilder {
    String fieldA;
    String fieldB;
    String fieldC;
    public BaseBuilder fieldA (String fieldA){
        this.fieldA = fieldA;
        return this;
    }

    public BaseBuilder fieldB (String fieldB){
        this.fieldB = fieldB;
        return this;
    }

    public BaseBuilder fieldC (String fieldC){
        this.fieldC = fieldC;
        return this;
    }

    public Base Build (){
        return new Base(fieldA, fieldB, fieldC);
    }

}
