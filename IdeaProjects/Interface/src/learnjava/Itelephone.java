package learnjava;

import java.util.ArrayList;
import java.util.List;

public interface Itelephone {
    void powerOn();
    void dial(int phoneNumber);
    private static void test(){
        System.out.println("Test");
    }
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}

