package com.company;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) {
        Path path1 = FileSystems.getDefault().getPath("FileTree/Dir2/Dir3");
        Path path2 = FileSystems.getDefault().getPath("FileTree/Dir2");
        System.out.println(path2.relativize(path1));
    }
}
