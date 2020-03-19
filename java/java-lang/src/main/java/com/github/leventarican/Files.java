package com.github.leventarican;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Levent
 */
public class Files {

    void exec() {
//        tree();
        attributes();
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

}
