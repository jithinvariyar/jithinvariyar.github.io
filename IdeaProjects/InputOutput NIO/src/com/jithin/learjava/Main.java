package com.jithin.learjava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");
        vocabulary.put("UP","U");
        vocabulary.put("DOWN","D");
        int loc = 56;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            System.out.println("Available exits are : ");
            System.out.println(locations.get(loc).getExits().keySet());
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1){
                String[] splitArray = direction.split(" ");
                for (String s : splitArray){
                    if(vocabulary.containsKey(s)){
                        direction = vocabulary.get(s);
                        break;
                    }
                }
            }
            if(locations.get(loc).getExits().containsKey(direction)) {
                loc = locations.get(loc).getExits().get(direction);
            }
            else{
                System.out.println("You can not go in that direction");
            }
        }
    }
}
