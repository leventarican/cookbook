package com.github.leventarican.batchprocessing;

/**
 * a thing generates data.<br></br><br></br>
 *
 * a thing can be a machine.<br></br>
 * a thing can be a IoT device.<br></br>
 * a thing can be a small single board computer.<br></br>
 * a thing can be a ...<br></br>
 *
 * @author Levent
 */
public abstract class Thing<T> {

    private T data;

    public abstract void process();
}
