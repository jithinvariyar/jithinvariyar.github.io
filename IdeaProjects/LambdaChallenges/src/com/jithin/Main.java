package com.jithin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts){
                System.out.println(part);
            }
        };

        runnable.run();
        Function<String,String> function = s -> {
            StringBuilder returnVal1 = new StringBuilder();
            for(int i = 0 ; i < s.length() ; i++){
                if(i % 2 == 1){
                    returnVal1.append(s.charAt(i));
                }
            }
            return returnVal1.toString();
        };

        System.out.println(everySecondCharacter(function,"1234567890"));

        Supplier<String> iLoveJava = ()->"I love Java";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia","emily","Isla","Ava",
                "oliver","Jack","Charlie","harry",
                "Jacob"
        );
        topNames2015.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);
        long countANames = topNames2015.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .filter(String::isBlank)
                .count();
        System.out.println(countANames);

        System.out.println("**************************");
        topNames2015.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .sorted()
//                .count();            //Since Java 9 .count() does not ensure that peek() will occur. If you're getting no output refer to another terminal operation.
                .collect(Collectors.toList());  //This terminal operation will ensure that peek() will occur!
        System.out.println(Integer.MAX_VALUE);
    }

    public static String everySecondCharacter(Function<String,String> function, String source){
        return function.apply(source);
    }

 }
