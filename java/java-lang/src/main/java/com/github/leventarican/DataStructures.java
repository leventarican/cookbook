package com.github.leventarican;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data structures in Java: list, set, map, ...
 * @author Levent
 */
public class DataStructures {
    
    Logger log = Logger.getLogger(DataStructures.class.getSimpleName());
    
    public void exec() {
        list();
        set();
        map();
    }
    
    private void list() {
        List<String> programminglang = new ArrayList<>();
        programminglang.add("java");
        programminglang.add("python");
        programminglang.add("cpp");
        
        log.log(Level.INFO, "list number of elements: {0}", programminglang.size());
        
        for (String pl : programminglang) {
            log.log(Level.INFO, pl);
        }
    }
    
    private void set() {
        log.log(Level.INFO, "set");
        
        Set unique = new HashSet();
        unique.add("java");
        unique.add("java");
        log.log(Level.INFO, "expected:2 - actual:{0}", unique.size());
    }
    
    private void map() {
        log.log(Level.INFO, "map");
        
        var m = new HashMap();
        m.put(0, "java");
        m.put(1, "kotlin");
        m.values().stream().forEach(c -> {
            System.out.println(c);
        });
    }
}
