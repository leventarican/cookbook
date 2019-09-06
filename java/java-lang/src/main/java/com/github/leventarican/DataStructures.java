package com.github.leventarican;

import java.util.ArrayList;
import java.util.List;
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
}
