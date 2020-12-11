package learjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<TestClass> strings = new ArrayList<>();
        List<TestClass> unmod = Collections.unmodifiableList(strings);
        strings.add(new TestClass("Jithin",34));
        System.out.println(strings.get(0).getName());
        System.out.println(unmod.get(0).getName() + " " + unmod.get(0).getId());
        unmod.get(0).setName("Hacked");
        System.out.println(strings.get(0).getName());

    }

}
