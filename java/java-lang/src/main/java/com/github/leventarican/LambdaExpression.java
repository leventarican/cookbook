package com.github.leventarican;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

    private List<Developer> devs = new ArrayList<>();

    public void exec() {
        init();
        withoutLambda();
        withLambda();
    }

    private void init() {
        devs.add(new Developer("java"));
        devs.add(new Developer("kotlin"));
        devs.add(new Developer("basic"));
        devs.add(new Developer("python"));
        devs.add(new Developer("smalltalk"));
        devs.add(new Developer("cpp"));

    }

    private void withoutLambda() {
        System.out.println("without lambda:");
        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getProgrammingLanguage().length() - o2.getProgrammingLanguage().length();
            }
        });
        devs.forEach( dev -> {
            System.out.println(dev.getProgrammingLanguage());
        });
    }

    private void withLambda() {
        System.out.println("with lambda:");
        for (Developer developer : devs.stream()
                .filter(dev -> "java".equals(dev.getProgrammingLanguage()))
                .sorted(Comparator.comparing(Developer::getProgrammingLanguage))
                .toArray(Developer[]::new)) {
            System.out.println(developer.getProgrammingLanguage());
        }
    }
}
