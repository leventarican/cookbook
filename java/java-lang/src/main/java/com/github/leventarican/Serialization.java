package com.github.leventarican;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author levent
 */
public class Serialization implements Serializable {
    
    int a = 100;
    // exclude field b; not part of the serialization (= the persistant state of the object)
    transient int b = 200;

    @Override
    public String toString() {
        var s = String.format("class: %s; a: %d, b: %d", Serialization.class.getName(), a, b);
        return s;
    }

    public static void main(String[] args) {
        var f = new File("serialized.object");
        var path = f.getAbsolutePath();
        System.out.println(path);

        // serialize
        var o = new Serialization();
        try {
            var fileout = new FileOutputStream(f);
            var out = new ObjectOutputStream(fileout);
            
            out.writeObject(o);
            out.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        // deserialize
        try {
            var filein = new FileInputStream(f);
            var in = new ObjectInputStream(filein);
            
            var deserialized = (Serialization) in.readObject();
            System.out.println(deserialized);
//            class: com.github.leventarican.Serialization; a: 100, b: 0
            in.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
