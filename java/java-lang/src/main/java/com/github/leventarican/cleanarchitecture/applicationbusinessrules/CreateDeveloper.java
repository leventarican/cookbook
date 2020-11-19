package com.github.leventarican.cleanarchitecture.applicationbusinessrules;

import com.github.leventarican.cleanarchitecture.applicationbusinessrules.port.DeveloperRepository;
import com.github.leventarican.cleanarchitecture.enterprisebusinessrules.Developer;

/**
 * use case: create a developer and save to a repository.
 *
 * @author levent
 */
public class CreateDeveloper {

    private DeveloperRepository repository;

    public CreateDeveloper(DeveloperRepository repository) {
        this.repository = repository;
    }

    public Developer create(Developer developer) {
        int salt = (int) (Math.random() * 100);
        var dev = Developer.builder()
                .setExperience(developer.getExperience())
                .setProgrammingLang(developer.getProgrammingLang())
                .setId(developer.getId())
                .setPassword(developer.getPassword() + salt)
                .build();
        repository.create(dev);
        return dev;
    }
}
