package learjava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapTest {
    private String name;
    private int id;
    public MapTest(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass())      //or if (!(obj instanceof Student))
            return false;
        if (obj == this)
            return true;
        return this.name.equals(((MapTest) obj).getName()) ;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {
        MapTest alex1 = new MapTest("Alex",1);
        MapTest alex2 = new MapTest("Alex",1);
        MapTest alex3 = new MapTest("Alex",3);
        Map<MapTest,Integer> mapTest = new HashMap<>();
        mapTest.put(alex1,4);
        mapTest.put(alex2,6);
        mapTest.put(alex3,13);
        System.out.println("HashMap size = " + mapTest.size());
        for(Map.Entry<MapTest,Integer> s : mapTest.entrySet()){
            System.out.println(s.getKey().getName() + ": " + s.getValue());
        }

        System.out.println(alex1.equals(alex2));
        System.out.println(alex1.hashCode());
        System.out.println(alex2.hashCode());
        System.out.println(alex3.hashCode());

//        System.out.println("HashSet contains Alex = " + students.contains(new Student(1, "Alex")));
    }
}
