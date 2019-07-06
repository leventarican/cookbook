package com.github.leventarican.model;

import java.util.ArrayList;
import java.util.List;

public class DeveloperFactory {
    private  List<Developer> developers = new ArrayList<>();
    public List<Developer> getDevelopers() {
        ObjectOrientedProgrammingLanguage java = new ObjectOrientedProgrammingLanguage("java");
        ObjectOrientedProgrammingLanguage smalltalk = new ObjectOrientedProgrammingLanguage("smalltalk");
        FunctionalProgrammingLanguage kotlin = new FunctionalProgrammingLanguage("kotlin");

        Developer<ObjectOrientedProgrammingLanguage> dev0 = new Developer<ObjectOrientedProgrammingLanguage>();
        dev0.addProgrammingLanguage(java);
        dev0.addProgrammingLanguage(smalltalk);
        Developer<FunctionalProgrammingLanguage> dev1 = new Developer<FunctionalProgrammingLanguage>();
        dev1.addProgrammingLanguage(kotlin);

        developers.add(dev0);
        developers.add(dev1);

        return developers;
    }
}
