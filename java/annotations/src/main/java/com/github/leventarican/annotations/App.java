package com.github.leventarican.annotations;

/**
 * @author Levent
 */
public class App {
    public static void main(String[] args) {
        var annotation = UsingDeveloperAnnotation.class.getAnnotation(DeveloperAnnotation.class);
        System.out.println("annotations: " + annotation.name() + "; " + annotation.programmingLanguage());
        
        if (annotation.programmingLanguage().equals("java")) {
            System.out.println("default value of field programmingLanguage is java.");
        }
    }
}
