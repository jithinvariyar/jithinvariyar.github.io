package com.jithin;

import static org.junit.Assert.*;

public class UtilitiesTest {
    Utilities utilities;

    @org.junit.Before
    public void setup(){
        utilities = new Utilities();
    }
    @org.junit.Test
    public void everyNthChar() {
        assertArrayEquals(new char[]{'e','l'},utilities.everyNthChar(new char[]{'h','e','l','l','o'},2));
        assertArrayEquals(new char[]{'h','e','l','l','o'},utilities.everyNthChar(new char[]{'h','e','l','l','o'},6));
    }

    @org.junit.Test
    public void removePairs() {
        String testString = "AABBCDDEFF";
        assertEquals("ABCDEF",utilities.removePairs(testString));
        assertEquals("ABCDE",utilities.removePairs("AAABBCCCDEE"));
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300,utilities.converter(10,5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_arithemeticException(){
        utilities.converter(10,0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertEquals("Jithin",utilities.nullIfOddLength("Jithin"));
        assertNull(utilities.nullIfOddLength("Jithu"));
    }
}