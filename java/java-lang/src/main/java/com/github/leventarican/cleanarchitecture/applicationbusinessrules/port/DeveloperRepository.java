package com.github.leventarican.cleanarchitecture.applicationbusinessrules.port;

import com.github.leventarican.cleanarchitecture.enterprisebusinessrules.Developer;
import java.util.List;

/**
 * @author levent
 */
public interface DeveloperRepository {
    Developer create(Developer developer);
    List<Developer> findAll();
}
