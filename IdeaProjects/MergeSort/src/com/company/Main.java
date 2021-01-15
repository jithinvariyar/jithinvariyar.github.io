package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many elements you want to sort?");
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter the number");
            integerList.add(scanner.nextInt());
            scanner.nextLine();
        }
        Collections.sort(integerList);
        Collections.reverse(integerList);
        System.out.println("The sorted list is " + integerList);

    }
}
