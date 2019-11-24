package com.github.leventarican;

import com.github.leventarican.model.Developer;
import com.github.leventarican.model.DeveloperFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {
    private  List<Developer> developers = new ArrayList<>();

    private void init() {
        DeveloperFactory factory = new DeveloperFactory();
        developers = factory.getSampleData();
    }

    private void withoutLambda() {
        System.out.println("without lambda:");
        Collections.sort(developers, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getProgrammingLanguages().size() - o2.getProgrammingLanguages().size();
            }
        });
        developers.forEach( dev -> {
            List<com.github.leventarican.model.ProgrammingLanguage> pl = dev.getProgrammingLanguages();
            pl.forEach( lang -> System.out.println(lang.getName()));
        });
    }

    private void withLambda() {
        System.out.println("with lambda:");
//        for (Developer developer : developers.stream()
//                .filter(dev -> "java".equals(dev.getProgrammingLanguages()))
//                .sorted(Comparator.comparing(Developer::getProgrammingLanguage))
//                .toArray(Developer[]::new)) {
//            System.out.println(developer.getProgrammingLanguage());
//        }
    }
    
    private void compile(ProgrammingLanguage pl) {
        pl.code();
    }
    
    /**
     * one abstract method.
     * overriding methods allowed.
     * multiply default methods allowed .
     */
    @FunctionalInterface
    interface ProgrammingLanguage {
        void code();

        @Override
        public String toString();
        
        default void version() {
            System.out.println("defaultl version: 0.0.1");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("\nLambdaExpression:");

        var app = new LambdaExpression();
//        app.init();
//        app.withoutLambda();
//        app.withLambda();
        
        app.compile(new ProgrammingLanguage() {
            @Override
            public void code() {
                System.out.println("code <= Java 7.");
            }
        });
        
        app.compile(() -> {
            System.out.println("code >= Java 8.");
        });
    }
}
