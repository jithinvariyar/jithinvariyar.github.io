package com.company;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class copyFile {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("Example/Dir1/file1.txt");
        try {
            long size = Files.size(path);
            System.out.println(size);
            System.out.println(Files.getLastModifiedTime(path));

            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(attr.size());
            System.out.println(attr.lastAccessTime());
            System.out.println(attr.lastModifiedTime());
            System.out.println(attr.isDirectory());
            System.out.println(attr.isRegularFile());
            System.out.println(attr.creationTime());
        } catch (IOException e){
            e.printStackTrace();
        }
//        Path newFilePath = FileSystems.getDefault().getPath("Example/file2.txt");
//        Path newDir = FileSystems.getDefault().getPath("Example","Dir4");
//        Path newDirs = FileSystems.getDefault().getPath("Example/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
//        try {
////            Files.createFile(newFilePath);
//            Files.createDirectories(newDirs);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//        Path deleteFilePath = FileSystems.getDefault().getPath("Example","Dir1/copyFile.txt");
//        try {
//            Files.deleteIfExists(deleteFilePath);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//        Path sourceFile = FileSystems.getDefault().getPath("Example","file1.txt");
//        Path copyFile = FileSystems.getDefault().getPath("Example","file1Copy.txt");
//        Path movFile = FileSystems.getDefault().getPath("Example/Dir1/copyFile.txt");
//        try {
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);
//            Files.move(copyFile,movFile);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
    }
}
