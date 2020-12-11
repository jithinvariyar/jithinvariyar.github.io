package learnjava;

import java.util.*;

public class Main {
    private static Map<Integer,Location> locations = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> directions = new HashMap<>();
        locations.put(0 , new Location(0,"You are sitting in front of a computer learning Java",null));

        directions = new HashMap<>();
        directions.put("W",2);
        directions.put("W",2);
        directions.put("E",3);
        directions.put("S",4);
        directions.put("N",5);
//        locations.get(1).addExit("Q",0);
        locations.put(1 , new Location(1,"you are standing at the end of a road before a small brick building",directions));

        directions = new HashMap<>();
        directions.put("N",5);
//        locations.get(2).addExit("Q",0);
        locations.put(2 , new Location(2,"you are at the top of a hill",directions));

        directions = new HashMap<>();
        directions.put("W",1);
//        locations.get(3).addExit("Q",0);
        locations.put(3 , new Location(3,"You are inside a building, a well house for a small spring",directions));

        directions = new HashMap<>();
        directions.put("N",1);
        directions.put("W",2);
//        locations.get(4).addExit("Q",0);
        locations.put(4 , new Location(4,"You are in a valley beside a stream",directions));

        directions = new HashMap<>();
        directions.put("S",1);
        directions.put("W",2);
//        locations.get(5).addExit("Q",0);
        locations.put(5 , new Location(5,"You are in the forest",directions));

        Map<String,String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");
        int loc = 1;
        directions.remove("S");
        while (true){
            System.out.println(locations.get(loc).getDescription());
            directions.remove("S");
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
                Set<String> hry = new HashSet<>();

            }
        }
    }
}

