package com.paul.testannotation;

import java.io.Serializable;

public class Person implements Serializable {
    public String personName;
    public int personAge;

    public Person(String personName, int personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }
}
