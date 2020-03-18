package com.github.leventarican;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Levent
 */
public class Files {

    void exec() {
        tree();
    }

    /**
     * will print something like this: 
     * 
     * src
     *  main
     *   java
     *    com
     *     github
     *      leventarican
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
