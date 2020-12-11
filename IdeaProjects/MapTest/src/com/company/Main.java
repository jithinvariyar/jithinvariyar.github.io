package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        Iterator<Integer> keyset = map.keySet().iterator();
        while (keyset.hasNext()){
            System.out.println(keyset.next());
        }
    }
}
