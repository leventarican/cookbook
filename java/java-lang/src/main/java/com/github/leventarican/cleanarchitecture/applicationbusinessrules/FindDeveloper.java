package com.github.leventarican.cleanarchitecture.applicationbusinessrules;

import com.github.leventarican.cleanarchitecture.applicationbusinessrules.port.DeveloperRepository;
import com.github.leventarican.cleanarchitecture.enterprisebusinessrules.Developer;
import java.util.List;

/**
 * use case: find all developers from a repository.
 *
 * @author levent
 */
public class FindDeveloper {

    private DeveloperRepository repository;

    public FindDeveloper(DeveloperRepository repository) {
        this.repository = repository;
    }

    public List<Developer> findAll() {
        return repository.findAll();
    }
}
