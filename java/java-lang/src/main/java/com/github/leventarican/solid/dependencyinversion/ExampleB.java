package com.github.leventarican.solid.dependencyinversion;

import java.util.Random;

/**
 * high-level modules should not depend on low-level modules.
 *
 * @author levent
 */
public class ExampleB {

    public static void main(String[] args) {
        var prefs = new SharedPreferences();
        var a = new App(prefs);
        a.save();
        
        var shared = new SharedPreferencesGood();
        var b = new AppGood(shared);
        b.save();
        b.repo = new Sqllite();
        b.save();
    }
}

// # bad design
// #############################################################################
// low level
class SharedPreferences {

    void save(String value) {
        System.out.println(String.format("value %s saved to shared preferences", value));
    }
}

// high level
class App {

    // what if we want to change from shared prefs to sqllite?
    SharedPreferences pref;

    public App(SharedPreferences pref) {
        this.pref = pref;
    }

    void save() {
        var id = "id: " + (int) (Math.random() * 100);
        pref.save(id);
    }

}

// # good design
// #############################################################################
interface Repository {

    default void save(String value) {
        System.out.println(String.format("value %s saved to repository", value));
    }
}

class SharedPreferencesGood implements Repository {

}

class Sqllite implements Repository {

    @Override
    public void save(String value) {
        System.out.println(String.format("# sqllite: value saved: %s", value));
    }
}

class AppGood {

    // dependency to low-level shared preferences solved. 
    // dependency inversed: shared preferences depends on repository.
    Repository repo;

    public AppGood(Repository repo) {
        this.repo = repo;
    }

    void save() {
        var id = "id: " + (int) (Math.random() * 100);
        repo.save(id);
    }

}
