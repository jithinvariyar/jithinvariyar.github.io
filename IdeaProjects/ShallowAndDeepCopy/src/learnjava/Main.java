package learnjava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person miniMe = new Person("mini", "Me");
        Person bill = new Person("Billie", "Jean");

        List<Person> people = new ArrayList<>();
        people.add(miniMe);
        people.add(bill);

        List<Person> shallowCopy = new ArrayList<>(people); // if we add/remove from this list the other list is not affected (2 lists)
        shallowCopy.remove(miniMe); // removes miniMe from copy

        System.out.println("people= " + people); // prints both
        System.out.println("shallowCopy= " + shallowCopy); // prints Billie since miniMe was removed

// BOTH lists contain same references of elements so if we change the element both are affected
        bill.setFirstName("Bill");

        System.out.println("people= " + people); // prints both but this time Bill
        System.out.println("shallowCopy= " + shallowCopy); // prints Bill

        List<Person> deepCopy = new ArrayList<>();

        for(Person person : people) {
            Person copyPerson = new Person(person.getFirstName(), person.getLastName()); // copy whole person (new object)
            deepCopy.add(copyPerson);
        }

        deepCopy.get(0).setFirstName("Jithin");
        System.out.println("Deep copy= " +deepCopy);//prints both but first jithin
        System.out.println("people= " + people); // prints both but this time Bill
        System.out.println("shallowCopy= " + shallowCopy); // prints Bill

        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        ArrayList<Integer> myListCopy = new ArrayList<>();
        for(Integer i : myList){
            Integer copy = new Integer(i.intValue());
            myListCopy.add(copy);
        }
        System.out.println(myList);
        System.out.println(myListCopy);

    }
}
