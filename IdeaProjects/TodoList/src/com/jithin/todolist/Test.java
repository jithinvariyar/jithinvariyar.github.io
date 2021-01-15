package com.jithin.todolist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("foo.txt");
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        bufferedWriter.write(String.format("%S", "foo"));
        bufferedWriter.close();
    }
}
