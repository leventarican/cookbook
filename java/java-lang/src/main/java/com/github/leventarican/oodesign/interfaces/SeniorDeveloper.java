package com.github.leventarican.oodesign.interfaces;

/**
 * abstract class restriction: cannot extends any other class
 *
 * @author levent
 */
public abstract class SeniorDeveloper implements Developer, MachineLearningEngineer {

    // by default value = 0
    protected byte experience;

    @Override
    public void setExperience(byte experience) {
        if (experience < 5) {
            throw new IllegalArgumentException();
        }
        this.experience = experience;
    }

}
