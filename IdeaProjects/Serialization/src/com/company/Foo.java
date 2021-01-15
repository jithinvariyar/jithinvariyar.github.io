package com.company;

import java.io.Serializable;

public class Foo implements Serializable {
    private String name;

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name= " + name;
    }
}
