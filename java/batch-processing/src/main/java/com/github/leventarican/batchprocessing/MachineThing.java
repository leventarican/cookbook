package com.github.leventarican.batchprocessing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Levent
 */
public class MachineThing extends Thing<MachineData> {

    private final List<MachineData> data = new ArrayList<>();
    private final static long MACHINE_RUN_TIME_SECONDS = 190_000_000L; // 1s = 1000_000_000

    /**
     * produce data.
     */
    @Override
    public void process() {
        int c = 0;
        Instant start = Instant.now();
        while (!(Duration.between(start, Instant.now()).toNanos() > MACHINE_RUN_TIME_SECONDS)) {
            data.add(new MachineData("header-" + (++c), "payload-" + c));
        }        
        System.out.println("data size: " + data.size());
    }

    /**
     * check folder size with: {@code du -h <folder>}.
     */
    @Override
    public void store() {
        Instant s = Instant.now();
        data.forEach((d) -> {
            try {
                Path target = FileSystems.getDefault().getPath("tmp/in").resolve(d.getHeader());
                if (!target.toFile().exists()) {
                    target.toFile().createNewFile();
                }
                Files.writeString(target, d.getPayload(), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        Instant e = Instant.now();
        System.out.println("data store duration[s]: " + Duration.between(s, e).toSeconds());
    }
}
