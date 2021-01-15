package com.jithin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {System.out.println("printing from runnable");}).start();
        Employee jithin = new Employee("Jithin",23);
        Employee jishnu = new Employee("Jishnu",25);
        Employee prasad = new Employee("Prasad",30);
        Employee praveen = new Employee("Praveen",28);
//
        List<Employee> employees = new ArrayList<>(Arrays.asList(jithin,jishnu,prasad,praveen));
        Collections.sort(employees, (emp1,emp2)-> emp1.getName().compareTo(emp2.getName()));
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
//        for(Employee employee: employees){
//            System.out.println(employee.getName());
//        }
//        String result = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(),employees.get(1).getName());
//        UpperConcat uc = (s1,s2)-> { String  res = s1.toUpperCase() + s2.toUpperCase();
////        return res;};
//        String result = doStringStuff(uc,employees.get(0).getName(),employees.get(1).getName());
//        System.out.println(result);

        AnotherClass anotherClass = new AnotherClass();
        String result = anotherClass.doSomething();
        System.out.println(result);
    }

    public static final String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        int i=0;
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    System.out.println("i's value inside anonymous class: " +i);
                    return s1.toUpperCase()+s2.toUpperCase();
                }
            };
            return Main.doStringStuff(uc,"String1","String2");
        }
//        return Main.doStringStuff((s1,s2)->{
//            System.out.println("lambda expression's class name is: " + getClass().getSimpleName());
//            return s1.toUpperCase() + s2.toUpperCase();},"String1","String2");
//        System.out.println("AnotherClass class name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("AnonymousClass class name is: " + getClass().getSimpleName());
//                return (s1.toUpperCase() + s2.toUpperCase());
//            }
//        },"String1","String2");
    }
}