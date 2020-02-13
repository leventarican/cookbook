package com.github.leventarican.batchprocessing.prototypes;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * generate folders, files, ...
 * <p></p>
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
        
        IntStream.range(0, 80).forEach( i -> System.out.print("#") );
        System.out.println("");
        
        Path sampleFile = filesystem.getPath(WORKING_DIR+"/sample.file");
        System.out.println("sample file: " + sampleFile);
        
        IntStream.range(0, 80).forEach( i -> System.out.print("#") );
        System.out.println("");
        List<String> lines = Files.readAllLines(sampleFile);
        lines.forEach(System.out::println);

        IntStream.range(0, 80).forEach( i -> System.out.print("#") );
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
}
