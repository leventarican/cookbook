package com.github.leventarican.oodesign.interfaces;

/**
 * an interface specification with default methods; since java 8;
 * use default methods when its optional or intended to have a single implementation;
 * 
 * @author levent
 */
public interface MachineLearningEngineer {
    default public void mlframework() {
        System.out.println("every ML Engineer should at least know pytorch, keras, sklearn, tensorflow");
    }
}
