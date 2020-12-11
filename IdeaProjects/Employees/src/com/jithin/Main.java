package com.jithin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee jithin = new Employee("Jithin Variyar",23);
        Employee jishnu = new Employee("Jishnu Variyar",25);
        Employee prasad = new Employee("Prasad MV",30);
        Employee praveen = new Employee("Praveen MV",28);
        Employee raji = new Employee("Raji MV",51);
        Employee saraswathi = new Employee("Saraswathi MV",58);

        List<Employee> employees = new ArrayList<>(Arrays.asList(jithin,jishnu,prasad,praveen,raji,saraswathi));
//        employees.forEach((employee)->{
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });
//        System.out.println("Employees over 30");
//        System.out.println("=================");
//        employees.forEach(employee -> {
//            if(employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }
//        });

//        System.out.println("Employees 30 and younger");
//        System.out.println("====================");
//        employees.forEach(employee -> {
//            if(employee.getAge() < 31){
//                System.out.println(employee.getName());
//            }
//        });
//        System.out.println("==============================");

        Function<Employee,String> capitalize = employee -> employee.getName().toUpperCase();
        Function<String,String> getFirstName = name->name.substring(0,name.indexOf(' '));
        Function<Employee,String> andThen = capitalize.andThen(getFirstName);

        Function<String,Employee> getLastName = name-> employees.get(0);
        Function<String,String> compose = capitalize.compose(getLastName);
        BiFunction<String,Employee,String> nameAge = (name, employee)->{
            String firstName = name.substring(0,name.indexOf(' '));
            int age = employee.getAge();
            return firstName + age;
        };
        System.out.println(andThen.apply(employees.get(0)));
        System.out.println(compose.apply("doesn't matter"));
        Function<Employee,String> getLastName1 = employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1);
        Function<Employee,String> getFirstName1 = employee -> employee.getName().substring(0,employee.getName().indexOf(' '));
//        employees.forEach(employee -> System.out.println(getLastName.apply(employee)));
        System.out.println(nameAge.apply(employees.get(0).getName(),employees.get(0)));
        Random random = new Random();
        if (random.nextBoolean())
            getAName(getFirstName1, employees, "FirstName");
        else
            getAName(getLastName1, employees, "SecondName");
        Supplier<Integer> supplier = ()-> random.nextInt(1000);
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(supplier.get());
        }

        IntPredicate above15 = i->i>15;
        IntPredicate below100 = i->i<100;

        System.out.println(above15.test(16));   //true
        System.out.println(below100.test(102)); //false
        System.out.println(below100.negate().test(102));  //This will print true because we nageted below100
        System.out.println(above15.and(below100).test(30)); //This will print true since we are testing a case which satisfies both predicates
        printBelowAndOver30("Above 30 employees",employees,employee -> employee.getAge() > 30);

        printBelowAndOver30("Employees 30 and younger",employees,employee -> employee.getAge() < 31);

        printBelowAndOver30("All Employees", employees, new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return true;
            }
        });
    }

    public static void getAName(Function<Employee,String> getName, List<Employee> employees, String note){
        System.out.println("\n" + note + "\n*******************************");
        employees.forEach(employee -> System.out.println(getName.apply(employee)));
        System.out.println("\n");
    }

    public static void printBelowAndOver30(String category,List<Employee> employees, Predicate<Employee> predicate){
        System.out.println(category + "\n=============================");
        for(Employee employee: employees){
            if(predicate.test(employee)){
                System.out.println(employee.getName());
            }
        }
        System.out.println("=============================");
    }
}
