package com.jithin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        System.out.println(challenge1.matches("I want a bike."));
        String regExp2 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp2);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());
        System.out.println(challenge1.matches(regExp2));
        System.out.println(challenge2.matches(regExp2));

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s","_"));

        String challenge5 = "aaabccccccdddefffg";
        String regExp5 = "a{3}bc{6}d{3}ef{3}g";
        System.out.println(challenge5.matches(regExp5));
        regExp5 = "[a-z]*";
        System.out.println(challenge5.matches(regExp5));

        String regExp7 = "(?i)[a-z]+\\.(\\d+)[\t\n]";
        System.out.println("Kjisl.22".matches(regExp7));
        Pattern pattern8 = Pattern.compile(regExp7);
        Matcher matcher8 = pattern8.matcher("abcd.135\tuvqz.7\ttzik.999\n");
        while (matcher8.find()){
            System.out.println(matcher8.group(1));
            System.out.println(matcher8.start(1) + " & " + (matcher8.end(1) - 1));   //group 0 always referes to the entire string
        }


        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String regExp11 = "\\{(\\d,\\s\\d)\\}";
        Pattern pattern11 = Pattern.compile(regExp11);
        Matcher matcher11 = pattern11.matcher(challenge11);
        while (matcher11.find()){
            System.out.println(matcher11.group(1));
        }

        String regExp13 = "^\\d{5}($|.\\d{4}$)";
        System.out.println("11111-1111".matches(regExp13));
        System.out.println("11111".matches(regExp13));
    }
}
