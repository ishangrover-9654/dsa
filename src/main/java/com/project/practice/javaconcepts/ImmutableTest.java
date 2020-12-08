package com.project.practice.javaconcepts;

import java.util.ArrayList;
import java.util.List;

/**
 * Better example
 * https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/
 */
public class ImmutableTest {
    public static void main(String[] args) {
        Address address = new Address("Hobitton", "Shire");

        List<String> stuff = new ArrayList<>();
        stuff.add("Sword");
        stuff.add("Ring of Power");

        Hobbit hobbit = new Hobbit("Frodo Baggins", address, stuff);

        System.out.println("Hobbit country: " + hobbit.getAddress().getCountry());
        System.out.println("Hobbit city: " + hobbit.getAddress().getCity());
        System.out.println("Hobbit stuff: " + hobbit.getStuff());

        Address hobbitAddress = hobbit.getAddress();


        List<String> hobbitStuff = hobbit.getStuff();
        hobbitStuff.remove("Ring of Power");
        hobbitStuff.remove("Sword");

        System.out.println();
        //System.out.println("Immutability has been hacked!"); if getStuff returns stuff
        // Instead of new ArrayList
        System.out.println();

        System.out.println("Hobbit country: " + hobbit.getAddress().getCountry());
        System.out.println("Hobbit city: " + hobbit.getAddress().getCity());
        System.out.println("Hobbit stuff: " + hobbit.getStuff());
    }
}

final class Hobbit {
    private String name;
    private Address address;
    private List<String> stuff;

    // all args constructor:
    public Hobbit(String name, Address address, List<String> stuff) {
        this.name = name;
        this.address = new Address(address.getCountry(), address.getCity());
        //this.stuff = new ArrayList<>(stuff);
        this.stuff =  stuff;
    }

    // getters:
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getStuff() {
        return new ArrayList<>(stuff);
        //return stuff;
    }
}

class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}

/*class Gandalf extends Hobbit {
    private String hackedName;

    public Gandalf(String name, Address address, List<String> stuff) {
        super(name, address, stuff);
        hackedName = name;
    }

    public void hackTheImmutability(String newNameValue) {
        hackedName = newNameValue;
        System.out.println("Immutability has been hacked!");
    }

    @Override
    public String getName() {
        return hackedName;
    }
}*/
