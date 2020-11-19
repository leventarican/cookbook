package com.github.leventarican.solid.liskovsubstitution.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author levent
 */
public class Main {

    public static void main(String[] args) {
        List<Furniture> furnitures = new ArrayList<>();

        furnitures.add(new Couch());
        furnitures.add(new Cupboard());

        furnitures.forEach(f -> {
            f.use();
        });

        // now how so use sit method in Cupboard class?!
        // introduce an abstract class / class based in interface: FurnitureRelaxing
        List<FurnitureRelaxing> relaxing = new ArrayList<>();
        relaxing.add(new Couch());
        relaxing.forEach(f -> {
            f.sit();
        });
    }

}

interface Furniture {

    default void use() {
        System.out.println("using furniture ...");
    }
}

abstract class FurnitureRelaxing implements Furniture {

    void sit() {
        System.out.println("sitting ...");
    }
}

class Cupboard implements Furniture {
}

class Couch extends FurnitureRelaxing {

}
