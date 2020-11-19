package com.github.leventarican.cleanarchitecture.interfaceadapters.repository;

import com.github.leventarican.cleanarchitecture.applicationbusinessrules.port.DeveloperRepository;
import com.github.leventarican.cleanarchitecture.enterprisebusinessrules.Developer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author levent
 */
public class InMemory implements DeveloperRepository {

    private final Map<String, Developer> inMemory = new HashMap<>();
    
    @Override
    public Developer create(Developer developer) {
        inMemory.put(developer.getId(), developer);
        return developer;
    }

    @Override
    public List<Developer> findAll() {
        return new ArrayList<>(inMemory.values());
    }

}
