package com.github.leventarican;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

    private List<Developer> devs = new ArrayList<>();

    public void exec() {
        init();
        process();
        end();

        devs.forEach( dev -> {
            System.out.println("asd");
        });
    }

    private void init() {
        devs.add(new Developer("java"));
        devs.add(new Developer("kotlin"));
    }

    private void process() {
        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                if (o1.getProgrammingLanguage().equals("java")) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    private void end() {

    }
}
