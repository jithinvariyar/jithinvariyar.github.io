package com.jithin.learjava;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }

    }

//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try(BufferedWriter locFile = Files.newBufferedWriter(locPath);
//            BufferedWriter dirFile = Files.newBufferedWriter(dirPath)){
//            for(Location location : locations.values()){
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for(String direction : location.getExits().keySet()){
//                    if(!direction.equalsIgnoreCase("Q")){
//                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }




    static {
        Path locpath = FileSystems.getDefault().getPath("locations.dat");
        boolean eof = false;
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locpath)))) {
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidClassException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try (Scanner locScanner = new Scanner(Files.newBufferedReader(locPath));
//             Scanner dirScanner = new Scanner(Files.newBufferedReader(dirPath))){
//            locScanner.useDelimiter(",");
//            while (locScanner.hasNextLine()){
//                int locationID = locScanner.nextInt();
//                locScanner.skip(locScanner.delimiter());
//                String description = locScanner.nextLine();
//                locations.put(locationID,new Location(locationID,description,null));
//            }
//            while (dirScanner.hasNextLine()){
//                String input = dirScanner.nextLine();
//                String[] inputSplit = input.split(",");
//                int locationID = Integer.parseInt(inputSplit[0]);
//                String direction = inputSplit[1];
//                int destination = Integer.parseInt(inputSplit[2]);
//                locations.get(locationID).getExits().put(direction,destination);
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
        return locations.put(key, value);
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