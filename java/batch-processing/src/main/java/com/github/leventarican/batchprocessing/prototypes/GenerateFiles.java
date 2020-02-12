package com.github.leventarican.batchprocessing.prototypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * generate folders, files, ...
 * 
 * @author Levent
 */
public class GenerateFiles {
    
    public static void generateFolders() {
        String[] dates = generateDates();
        // TODO: make dirs
    }
    
    public static String[] generateDates() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<String> dates = IntStream.range(0, 3).mapToObj(i -> formatter.format(now.plusDays(i))).collect(Collectors.toList());
        dates.forEach(System.out::println);
        return dates.toArray(new String[0]);
    }
}
