package com.jithin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N48","N36","B12","B6",
                "G53","G49","G60","G50","g36",
                "I26","I17","I29","O71"
        );
        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(string->string.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberStream = Stream.of("N48","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNumberStream);
        System.out.println("-----------------------------------------");
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        Employee jithin = new Employee("Jithin Variyar",23);
        Employee jishnu = new Employee("Jishnu Variyar",25);
        Employee raji = new Employee("Raji M V",51);
        Employee praveen = new Employee("Praveen M V",28);
        Employee prasad = new Employee("Prasad M V",31);

        Department hr = new Department("Human Resources");
        hr.addEmployees(raji);
        hr.addEmployees(prasad);
        hr.addEmployees(praveen);

        Department accounts = new Department("Accounting");
        accounts.addEmployees(jishnu);
        accounts.addEmployees(jithin);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounts);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("-------------------------");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2)->e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
    }
}
