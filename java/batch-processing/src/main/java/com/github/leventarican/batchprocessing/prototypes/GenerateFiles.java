package com.github.leventarican.batchprocessing.prototypes;

import java.io.IOException;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    /**
     * one-way hash function, checksum using MD2 algorithm for a file.
     * 
     * @throws java.security.NoSuchAlgorithmException when MD2 is not supported.
     */
    public static String checksum() throws NoSuchAlgorithmException {
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

        Optional<MessageDigest> md2 = Optional.empty();
        try {
            md2 = Optional.of(MessageDigest.getInstance("MD2"));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        if (md2.isPresent()) {
            byte[] checksum = md2.get().digest(bytes);
            
            // Java Stream API: there is no ByteStream like IntStream
            // http://mail.openjdk.java.net/pipermail/lambda-dev/2013-March/008535.html
            
            StringBuilder sb = new StringBuilder();
            for (byte b : checksum) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        } else {
            // we dont want to return null value thus throw exception.
            throw new NoSuchAlgorithmException();
        }
    }
    
    /**
     * Check if MD2 provider is supported.
     * 
     * SUN: MessageDigest.MD2 -> sun.security.provider.MD2
     */
    public static void providerMD2() {
        for (Provider p : Security.getProviders()) {
            p.getServices().stream()
                    .filter(s -> s.toString().contains("MD2"))
                    .forEach(System.out::println);
        }
    }
}
