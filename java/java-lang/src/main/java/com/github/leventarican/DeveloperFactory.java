package com.github.leventarican;

import java.util.ArrayList;
import java.util.List;

public class DeveloperFactory {

    public static Developer java = new Developer("java");
    public static Developer scala = new Developer("scala");
    public static Developer kotlin = new Developer("kotlin");

    private  List<Developer> developers = new ArrayList<>();
    public List<Developer> getDevelopers() {
        developers.add(new Developer("java"));
        developers.add(new Developer("kotlin"));
        developers.add(new Developer("basic"));
        developers.add(new Developer("python"));
        developers.add(new Developer("smalltalk"));
        developers.add(new Developer("cpp"));
        return developers;
    }
}
