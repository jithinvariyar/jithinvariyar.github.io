package tcs.preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> vowels = new ArrayList<>(Arrays.asList("a","e","i","o","u"));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 words");
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        s1 = vowels(s1);
        s2 = consonent(s2);
        s3 = toUpper(s3);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    public static String vowels(String s){
        String[] array = s.split("");
        StringBuilder modified = new StringBuilder();
        for(int i = 0 ; i < array.length ; i++){
            if(vowels.contains(array[i].toLowerCase())){
                array[i] = "%";
            }
            modified.append(array[i]);
        }
        return modified.toString();
    }

    public static String consonent(String s){
        String[] array = s.split("");
        StringBuilder modified = new StringBuilder();
        for(int i = 0 ; i < array.length ; i++){
            if(vowels.contains(array[i].toLowerCase())){
            } else {
                array[i] = "#";
            }
            modified.append(array[i]);
        }
        return modified.toString();
    }

    public static String toUpper(String s){
        String[] array = s.split("");
        StringBuilder modified = new StringBuilder();
        for(int i = 0 ; i < array.length ; i++){
            array[i] = array[i].toUpperCase();
            modified.append(array[i]);
        }
        return modified.toString();
    }
}
