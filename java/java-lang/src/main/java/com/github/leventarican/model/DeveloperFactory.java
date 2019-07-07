package com.github.leventarican.model;

import java.util.ArrayList;
import java.util.List;

public class DeveloperFactory {
    private  List<Developer> developers = new ArrayList<>();

    public List<Developer> getSampleData() {

        ObjectOrientedProgrammingLanguage java = new ObjectOrientedProgrammingLanguage("java");
        ObjectOrientedProgrammingLanguage smalltalk = new ObjectOrientedProgrammingLanguage("smalltalk");
        Developer<ObjectOrientedProgrammingLanguage> dev0 = new Developer<ObjectOrientedProgrammingLanguage>();
        dev0.addProgrammingLanguage(java);
        dev0.addProgrammingLanguage(smalltalk);
        developers.add(dev0);

        FunctionalProgrammingLanguage kotlin = new FunctionalProgrammingLanguage("kotlin");
        Developer<FunctionalProgrammingLanguage> dev1 = new Developer<FunctionalProgrammingLanguage>();
        dev1.addProgrammingLanguage(kotlin);
        developers.add(dev1);

        return developers;
    }
}
