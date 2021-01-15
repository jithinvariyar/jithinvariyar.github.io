package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class copyTree extends SimpleFileVisitor<Path> {
    Path targetRoot;
    Path sourceRoot;

    public copyTree(Path targetRoot, Path sourceRoot) {
        this.targetRoot = targetRoot;
        this.sourceRoot = sourceRoot;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativePath = sourceRoot.relativize(dir);
        Path copyDir = targetRoot.resolve(relativePath);
        try {
            Files.copy(dir,copyDir);
        }catch (FileAlreadyExistsException e){
            System.out.println("Deleting the Already Existing tree");
            Files.walkFileTree(targetRoot,new DeleteTree());
            Main.flag = true;
            return FileVisitResult.SKIP_SUBTREE;
        }catch (IOException e){
            e.printStackTrace();
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativePath = sourceRoot.relativize(file);
        Path copyFile = targetRoot.resolve(relativePath);
        try {
            Files.copy(file,copyFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
