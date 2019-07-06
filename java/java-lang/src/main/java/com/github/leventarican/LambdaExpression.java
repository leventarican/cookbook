package com.github.leventarican;

import com.github.leventarican.model.Developer;
import com.github.leventarican.model.DeveloperFactory;
import com.github.leventarican.model.ProgrammingLanguage;

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
                return o1.getProgrammingLanguages().size() - o2.getProgrammingLanguages().size();
            }
        });
        developers.forEach( dev -> {
            List<ProgrammingLanguage> pl = dev.getProgrammingLanguages();
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
}
