package com.github.leventarican.benchmark;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author levent
 */
public class Benchmark {

    private static void benchmark() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 48; j < 123; j++) {
                char c = (char) j;
                line.append(c);
            }
        }

        for (int i = 0; i < 1000; i++) {
            Path path = Paths.get("generated." + i);
            System.out.println(path.toAbsolutePath());
            try ( Writer out = Files.newBufferedWriter(path, StandardCharsets.ISO_8859_1)) {
                out.write(line.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*
    creating 1000 files
    
    time elapsed [ms]: 272
    */
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        benchmark();
        long t2 = System.currentTimeMillis();
        System.out.println("time elapsed [ms]: " + (t2 - t1));
    }
}
