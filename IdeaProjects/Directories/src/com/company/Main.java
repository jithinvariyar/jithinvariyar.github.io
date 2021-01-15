package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {

    public static boolean flag = false;
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        DirectoryStream.Filter<Path> customFilter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path);
             DirectoryStream<Path> filterDirStream = Files.newDirectoryStream(path,"*.txt");
             DirectoryStream<Path> customFilterDirStream = Files.newDirectoryStream(path,customFilter)){
            for(Path file : dirStream){
                System.out.println(file.getFileName());
            }
            System.out.println("==========");
            Iterator<Path> iterator = filterDirStream.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().getFileName());
            }
            System.out.println("==========");
            for(Path directory : customFilterDirStream){
                System.out.println(directory.getFileName());
            }
            String seperator = File.separator;
            System.out.println(seperator);
            seperator = FileSystems.getDefault().getSeparator();
            System.out.println(seperator);
            try {
                Path tempFile = Files.createTempFile("tempfile",".txt");
                System.out.println(tempFile.toAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException | DirectoryIteratorException e){
            e.printStackTrace();
        }

        System.out.println("************************************");
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        int i = 0;
        for(FileStore store: stores){
            i++;
            System.out.println(store);
            System.out.println(store.name());
        }
        System.out.println(i);

        System.out.println("=================================");
        Iterable<Path> rootPath = FileSystems.getDefault().getRootDirectories();
        for(Path path1 : rootPath){
            System.out.println(path1);
        }

        System.out.println("============================================");
        Path root = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(root, new PrintNames());
        } catch (IOException e){
            e.printStackTrace();
        }

        Path sourcePath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(sourcePath, new copyTree(copyPath,sourcePath));
            if(flag == true){
                Files.walkFileTree(sourcePath, new copyTree(copyPath,sourcePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
