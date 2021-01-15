package com.company;

public class Main {

    public static void main(String[] args) {
	    MyClass myClass = new MyClass();
	    if(myClass instanceof TestInterface){
            System.out.println(myClass.test());
            TestInterface testInterface = (TestInterface)myClass;
            System.out.println(testInterface.test());
        }
    }
}
