package com.github.leventarican;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreator {
    public void exec() {
        charBased();
    }

    void charBased() {
        Path path = Paths.get("java.csv");
        System.out.println(path.toAbsolutePath());
        try (Writer out = Files.newBufferedWriter(path, StandardCharsets.ISO_8859_1) ) {
            out.write("developer; programming language; exp\n");
            out.write("foo; java; 10\n");
            out.write("bar; kotlin; 3\n");
            out.write("boost; cpp; 15\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void byteBased() {
        Path path = Paths.get("java.file");
        try (OutputStream out = Files.newOutputStream(path)) {
            for (int l=0; l<1_000_000; l++) {
                out.write("1".getBytes(StandardCharsets.ISO_8859_1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
