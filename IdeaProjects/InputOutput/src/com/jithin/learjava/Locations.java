package com.jithin.learjava;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException{
//        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
//            for(Location location : locations.values()){
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()){
//                    if(!direction.equalsIgnoreCase("Q")){
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
            for(Location location : locations.values()){
                locFile.writeObject(location);
            }
        }
    }
    static {
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }

            }
        } catch (IOException io) {
            System.out.println("IOException " + io.getMessage());
        } catch (ClassNotFoundException cnf){
            System.out.println("Class not found: " + cnf.getMessage());
        }
    }
//            while (!eof){
//                try {
//                    int locationID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    Map<String,Integer> exits = new LinkedHashMap<>();
//                    int numExits = locFile.readInt();
//                    for (int i = 0 ; i < numExits ; i++){
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction,destination);
//                    }
//                    locations.put(locationID , new Location(locationID , description,exits));
//                } catch (EOFException e){
//                    eof = true;
//                }
//            }




//        try (BufferedReader locFile = new BufferedReader(new FileReader("locations.txt"));
//             BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
//            String input;
//            while ((input = locFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int locationID = Integer.parseInt(data[0]);
//                String description = data[1];
//                Map<String, Integer> tempExit = new LinkedHashMap<>();
//                locations.put(locationID, new Location(locationID, description,tempExit));
//            }
//
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int locationID = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                Location location = locations.get(locationID);
//                location.addExit(direction , destination);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
