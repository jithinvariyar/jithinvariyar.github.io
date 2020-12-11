package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        Path filePath = FileSystems.getDefault().getPath("file.txt");
        printFile(filePath);
        filePath = FileSystems.getDefault().getPath("directory","directoryFile.txt");
//      filePath = Paths.get("directory/directoryFile.txt");
        printFile(filePath);

        filePath = Paths.get("/home","jithin","Documents","IdeaProjects","outsideFile.txt");
        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        filePath = Paths.get(".","directory","..","directory","directoryFile.txt");
        printFile(filePath);
        Path notValidPath = Paths.get("notExists.txt");
        System.out.println(filePath.toAbsolutePath().normalize());
        System.out.println(Files.exists(filePath));
        System.out.println(Files.exists(notValidPath));
        System.out.println(Files.notExists(notValidPath));
    }
    public static void printFile(Path path){
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
