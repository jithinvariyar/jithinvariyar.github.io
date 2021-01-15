package learjava;

import java.util.*;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();
        for(int i =1 ; i <=100 ; i++){
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are " + squares.size() + " Squares, And " + cubes.size() + " Cubes.");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");
        Set<Integer> intersection = new HashSet<>(cubes);
        intersection.retainAll(squares);
        System.out.println("Intersection contains " + intersection.size() + " elements");
        for(int i : intersection){
            System.out.println(i + " is the square of " + (int) Math.sqrt(i) + " and the cube of " + (int) Math.cbrt(i));
        }
        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for(String s : words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all","nature","is","but","art","unknown","to","thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to","err","is","human","to","forgive","divine"};
        divine.addAll(Arrays.asList(divineWords));
        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);
        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference : ");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);


    }

    private static void printSet(Set<String> set){
        System.out.print("\t");
        for(String element : set){
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
