package learnjava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        Integer newInt = 34;
        System.out.println(newInt.valueOf(3));
        for(int i = 0 ; i <= 10 ; i++){
            intList.add(i);
        }
        for(int i = 0 ; i < intList.size() ; i++){
            int value = intList.get(i).intValue();
            System.out.println(value);
        }
    }
}
