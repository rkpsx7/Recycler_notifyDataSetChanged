package com.example.recycler_notifydatasetchanged;

public class Model {
    String name,address;
    int age;

    public Model(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}
