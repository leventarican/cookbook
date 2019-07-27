package com.github.leventarican;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreator {
    public void exec() {
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
