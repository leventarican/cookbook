package com.github.leventarican;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Levent
 */
public class Files {

    void exec() {
//        tree();
//        attributes();
//        treePro();
        cleanup(".this");
    }

    private void attributes() {
        try {
            String dir = ".";
            Path start = Path.of(dir);
            java.nio.file.Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.getFileName() + ": " + attrs.lastModifiedTime());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    static void cleanup(String extension) {
        Path workingDir = Paths.get(".");
        System.out.println(workingDir.toAbsolutePath());

        try {
            java.nio.file.Files.walk(workingDir, 2)
                    .filter(java.nio.file.Files::isRegularFile)
                    .filter(f -> f.toFile().getName().endsWith(extension))
                    .forEach((path) -> {
                        try {
                            java.nio.file.Files.deleteIfExists(path);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    });
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * will print something like this:
     *
     * src main java com github leventarican
     */
    static void tree() {
        try {
            String dir = ".";
            Path root = Path.of(dir);
            int depth = root.getNameCount();

            java.nio.file.Files.walk(root, 10)
                    .filter(p -> p.toFile().isDirectory())
                    .map(p -> "  ".repeat(p.getNameCount() - depth)
                    .concat(p.getFileName().toString()))
                    .forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * walk directories, skip target/ folder.
     */
    static void treePro() {
        try {
            String dir = ".";
            Path root = Path.of(dir);
            AtomicInteger depth = new AtomicInteger(root.getNameCount());

            java.nio.file.Files.walkFileTree(root, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                    int dirDepth = dir.getNameCount() - depth.get();

                    if (dir.getFileName().startsWith("target")) {
                        return FileVisitResult.SKIP_SUBTREE;
                    } else {
                        System.out.println(" ".repeat(dirDepth).concat(dir.getFileName().toString()));
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
