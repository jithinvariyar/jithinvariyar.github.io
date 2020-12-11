package learnjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> srcList = new ArrayList<String>(3);
        srcList.add("Ram");
        srcList.add("Sam");
        srcList.add("Tim");
        ArrayList<String> destList = new ArrayList<String>(srcList);
        System.out.println(destList);
        destList.add("1");
        destList.add("2");
        destList.add("3");
        destList.add("4");
        Collections.copy(destList , srcList);
        System.out.println(destList);
        List<String> newDestList = new ArrayList<>(2);
        Collections.copy(newDestList,srcList);
    }
}
