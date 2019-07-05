package com.github.leventarican;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {
    private  List<Developer> developers = new ArrayList<>();

    public void exec() {
        System.out.println("\nLambdaExpression:");

        init();
        withoutLambda();
        withLambda();
    }

    private void init() {
        DeveloperFactory factory = new DeveloperFactory();
        developers = factory.getDevelopers();
    }

    private void withoutLambda() {
        System.out.println("without lambda:");
        Collections.sort(developers, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getProgrammingLanguage().length() - o2.getProgrammingLanguage().length();
            }
        });
        developers.forEach( dev -> {
            System.out.println(dev.getProgrammingLanguage());
        });
    }

    private void withLambda() {
        System.out.println("with lambda:");
        for (Developer developer : developers.stream()
                .filter(dev -> "java".equals(dev.getProgrammingLanguage()))
                .sorted(Comparator.comparing(Developer::getProgrammingLanguage))
                .toArray(Developer[]::new)) {
            System.out.println(developer.getProgrammingLanguage());
        }
    }
}
