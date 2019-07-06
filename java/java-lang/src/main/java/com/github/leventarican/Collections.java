package com.github.leventarican;

import com.github.leventarican.model.Developer;
import com.github.leventarican.model.DeveloperFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collections {

    public void exec() {
        System.out.println("\nCollections:");

        Collection<Developer> c = new ArrayList<>();
        c.toArray();
        c.toArray(new Developer[c.size()]);

//        List<Developer> l = new ArrayList<>();
//        l.add(DeveloperFactory.java);
//        l.add(DeveloperFactory.scala);
//        l.set(1, DeveloperFactory.kotlin);
//        l.forEach(dev -> System.out.println(dev.getProgrammingLanguage()));
    }
}
