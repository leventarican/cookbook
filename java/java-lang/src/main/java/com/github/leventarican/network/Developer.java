package com.github.leventarican.network;

/**
 * a developer can develop in 1 or more programming languages.
 * 
 * @author levent
 */
public class Developer {
    long id;
    String name;
    ProgrammingLanguage[] languages;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Developer id: ").append(id).append("; name: ").append(name).append("; languages: ");
        for (ProgrammingLanguage language : languages) {
            builder.append(language.getName()).append("; ");
        }
        return builder.toString();
    }
}
