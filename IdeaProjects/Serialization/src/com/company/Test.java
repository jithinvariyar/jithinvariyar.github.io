package com.company;

import java.io.Serializable;

public class Test implements Serializable {
    int ID;
    Foo foo;
    private long serialVersionUID = 1L;

    public Test(int ID , Foo foo) {
        this.ID = ID;
        this.foo = foo;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}
