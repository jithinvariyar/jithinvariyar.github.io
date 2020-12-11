package learnjava;

import java.util.*;

public class MapProgram {

    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();
        languages.put("Java","A compiled, High level, Object oriented, Platform independent language");
        languages.put("Python","An interpreted, object oriented, high level, programing language with dynamic semantics");
        languages.put("Algol","an algorithmic language");
        languages.put("Basic","Beginners all purposes symbolic Instruction Code");
        System.out.println(languages.put("Lisp","Therein lies madness"));

        System.out.println(languages.get("Java"));
        languages.put("Java","This course is about Java");
        System.out.println(languages.get("Java"));
        if(languages.containsKey("Java")){
            System.out.println("There is a key already");
        }
        else{
            languages.put("Java","This line will not execute");
        }


        System.out.println("=====================================");
        for (String key : languages.keySet()){
            System.out.println(key + ": " + languages.get(key));
        }
        System.out.println(languages.keySet());
        System.out.println(languages.entrySet());
        languages.remove("Java");
        System.out.println(languages.keySet());
        if(languages.remove("Lisp","This is not the key of Lisp")){
            System.out.println("Lisp is removed from the list");
        }
        else{
            System.out.println("Lisp is not removed from the list");
        }

        System.out.println(languages.replace("Basic","Replaced the value of Basic")); //prints the old value

        System.out.println(languages.replace("Java","This is not the value of Java and java is not in the map")); //prints null

        System.out.println(languages.replace("Algol","This is not the value of algol","Now updated algol")); //This prints false coz old value does not matches.
        System.out.println(languages.replace("Algol","an algorithmic language","Now algol is updated")); //This prints true there is a key - value pair with key and oldValue.

        for (String key : languages.keySet()){
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
