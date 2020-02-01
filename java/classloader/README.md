# classloader
* we want to access a _remote_ class (Utility) with class loader
* both classes have no package defined
* the _system classpath classloader_ loads classes from directories and jars specified by 
    * `CLASSPATH` environment variable
    * `java.class.path` system property
    * `-classpath` or `-cp` command line option

## compile and run
``` 
javac Main.java
javac extern/Utility.java
java -cp extern/:. Main
``` 
__output__
``` 
Main
Utility
``` 
