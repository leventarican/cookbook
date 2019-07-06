package com.github.leventarican.model;

import java.util.ArrayList;
import java.util.List;

public class Developer<T extends ProgrammingLanguage> {
    private List<T> programmingLanguages = new ArrayList<>();
    public void addProgrammingLanguage(T lang) {
        programmingLanguages.add(lang);
    }
    public List<T> getProgrammingLanguages() {
        return programmingLanguages;
    }
}
