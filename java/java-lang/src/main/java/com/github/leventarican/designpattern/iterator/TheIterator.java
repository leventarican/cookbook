package com.github.leventarican.designpattern.iterator;

/**
 * Iterate over data.
 * @author Levent
 */
public class TheIterator {
    String[] data;

    public TheIterator(String[] data) {
        this.data = data;
        System.out.println("data length: " + data.length);
    }
    
    public IteratorForTheIterator getElements() {
        return new IteratorForTheIterator() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < data.length;
            }

            @Override
            public String next() {
                return data[i++];
            }
        };
    }
}

interface IteratorForTheIterator {
    public boolean hasNext();
    public String next();
}