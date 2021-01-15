package com.jithin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String alphaNumeric = "abcdeF45Bt6YTRSabceHhello";
        System.out.println(alphaNumeric.replaceAll("abcde","Y"));
        System.out.println(alphaNumeric.replaceAll("^abcde","Y"));
        System.out.println(alphaNumeric.replaceAll(".","Y"));
        System.out.println(alphaNumeric.replaceAll("hello$","X"));
        System.out.println(alphaNumeric.replaceAll("[abc]","Character replaced"));
        System.out.println(alphaNumeric.replaceAll("[^abc]","Character replaced"));
        System.out.println(alphaNumeric.replaceAll("[abc][de]","HAHA"));

        String test = "aaa123abc";
        String regExpTest = "a+\\d{3}[abc]{3}";
        String regExpTest1 = "\\d{3}";
        System.out.println("************************");
        System.out.println(test.matches(regExpTest));
        System.out.println(test.matches(regExpTest1));
        System.out.println(test.replaceAll(regExpTest1,"V"));
        System.out.println(alphaNumeric.matches("^abcde"));
        System.out.println(alphaNumeric.matches("^abcdeF45Bt6YTRSabceHhello")); //all characters should match to matches to satisfy!!!
        System.out.println(alphaNumeric.replaceAll("[A-Z]","NANA"));
        System.out.println(alphaNumeric.replaceAll("[a-z]","HIHI"));
        System.out.println(alphaNumeric.replaceAll("[1-9]","*"));

        System.out.println("harry".replaceAll("[Hh]arry","Harry"));
        System.out.println(alphaNumeric.replaceAll("[a-f3-8]","K"));
        System.out.println(alphaNumeric.replaceAll("(?i)[a-f3-8]","K"));

        System.out.println(alphaNumeric.replaceAll("\\d","X"));
        System.out.println(alphaNumeric.replaceAll("\\D","X"));

        String hasWhiteSpace = "I have blanks \t a tab and a new line as well\n";
        System.out.println(hasWhiteSpace.replaceAll("\\s","*"));
        System.out.println(hasWhiteSpace.replaceAll("\\S","*"));

        System.out.println(alphaNumeric.replaceAll("\\w","x"));
        System.out.println(hasWhiteSpace.replaceAll("\\W","Y"));

        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));
        String alphaNumeric1 = "abcdeeeeFFGtd6568UtfdsbsUFHv5";
        System.out.println(alphaNumeric1.replaceAll("^abcde{3}","S"));
        System.out.println(alphaNumeric1.replaceAll("^abcde+","S"));
        System.out.println(alphaNumeric1.replaceAll("^abcde*","S"));
        System.out.println(alphaNumeric1.replaceAll("^abcde{3,5}","S"));
        System.out.println(alphaNumeric1.replaceAll("e+F*G","#"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Matcher = "<h2>";
        Pattern pattern = Pattern.compile(h2Matcher);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurence " + count + ": " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(h2GroupPattern);

    }
}
