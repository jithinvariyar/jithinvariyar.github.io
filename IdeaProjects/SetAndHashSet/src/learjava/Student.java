package learjava;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private int id;
    private String name;
    public Student(int id, String name) {
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
        return this.getId() == ((Student) obj).getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {
        Student alex1 = new Student(1, "Alex");
        Student alex2 = new Student(1, "Alex");
        HashSet< Student > students = new HashSet < Student > ();
        students.add(alex1);
        students.add(alex2);
        System.out.println("HashSet size = " + students.size());
        for(Student s: students){
            System.out.println(s.getName() + ": " + s.getId());
        }
        System.out.println(alex1.equals(alex2));
        System.out.println(alex1.hashCode());
        System.out.println(alex2.hashCode());
//        System.out.println("HashSet contains Alex = " + students.contains(new Student(1, "Alex")));
    }
}
