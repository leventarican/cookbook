package com.github.leventarican.oodesign.interfaces;

/**
 * interfaces cannot contain any non-constant field.
 *
 * @author levent
 */
public interface Developer {
    public void code();
    public void setExperience(byte exp) throws IllegalArgumentException;
}
