package com.company;

import java.nio.charset.StandardCharsets;

public class Tes {
    public static void main(String[] args) {
        String str = "hai";
        System.out.println(str.length());
        byte[] array = str.getBytes(StandardCharsets.UTF_16);
        System.out.println(array.length);
    }


}
