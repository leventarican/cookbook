package com.github.leventarican.batchprocessing.prototypes;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * generate folders, files, ...
 * <p>
 * </p>
 * NIO.2 java.nio.file since Java 7
 *
 * @author Levent
 */
public class GenerateFiles {

    public static String WORKING_DIR = "tmp";

    public static void generateFolders() throws IOException {
        FileSystem filesystem = FileSystems.getDefault();

        filesystem.getFileStores().forEach(fs -> {
            try {
                System.out.println("name: " + fs.name());
                System.out.println("type: " + fs.type());
                System.out.println("total: " + fs.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        IntStream.range(0, 80).forEach(i -> System.out.print("#"));
        System.out.println("");

        Path sampleFile = filesystem.getPath(WORKING_DIR + "/sample.file");
        System.out.println("sample file: " + sampleFile);

        IntStream.range(0, 80).forEach(i -> System.out.print("#"));
        System.out.println("");
        List<String> lines = Files.readAllLines(sampleFile);
        lines.forEach(System.out::println);

        IntStream.range(0, 80).forEach(i -> System.out.print("#"));
        System.out.println("");

        Path currentDir = filesystem.getPath(WORKING_DIR);
        String[] dates = generateDates();
        for (String date : dates) {
            Files.createDirectory(currentDir.resolve(date));
        }
    }

    public static String[] generateDates() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<String> dates = IntStream.range(0, 3).mapToObj(i -> formatter.format(now.plusDays(i))).collect(Collectors.toList());
        dates.forEach(System.out::println);
        return dates.toArray(new String[0]);
    }

    public static void prototype() {
        FileSystem filesystem = FileSystems.getDefault();
        Path sampleFile = filesystem.getPath(WORKING_DIR + "/sample.file");
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(sampleFile);
            for (byte b : bytes) {
                System.out.print(String.format("%c", b));
            }
            System.out.println("<< EOF");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for (Provider p : Security.getProviders()) {
            // SUN: MessageDigest.MD2 -> sun.security.provider.MD2
            p.getServices().stream()
                    .filter(s -> s.toString().contains("MD2"))
                    .forEach(System.out::println);
        }

//        Optional<MessageDigest> md2 = Optional.empty();
//        try {
//            md2.orElse(MessageDigest.getInstance("MD2"));
//        } catch (NoSuchAlgorithmException ex) {
//            System.out.println(ex);
//        }
//        if (md2.isPresent()) {
//            System.out.println("START.");
//            md2.get().update(bytes);
//            for (int i = 0; i < bytes.length; i++) {
//                md2.get().update(bytes, 0, i);
//            }
//            System.out.printf("%032X%n", new BigInteger(1, md2.get().digest()));
//            System.out.println("DONE.");
//        }

        try {
            byte[] clear = "ABC".getBytes();
            for (byte b : clear) {
                System.out.print(b);
            }
            System.out.println("<< EOF");
            
            MessageDigest md = MessageDigest.getInstance("MD2");
            md.update(clear);
            for (byte b : md.digest()) {
                System.out.print(b);
            }
            System.out.println("<< EOF");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
    }
}
