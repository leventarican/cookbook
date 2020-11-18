package com.github.leventarican.oodesign.composition;

/**
 *
 * @author levent
 */
public class Developer implements Employee {

    @Override
    public void work() {
        System.out.println(String.format("name: %s; work: coding.", Developer.class.getName()));
    }
    
}
