# apache ant: hands-on
* check if you have ant: `ant -version`
* in order to use ant you need a so called build.xml
* if you a build file then just call ant: `ant`. you can also explicitely define the build file: `ant -f building.xml`
* use verbose for more info: `ant -verbose`
```
Buildfile: /cookbook/java/ant/start/build.xml

compile:
     [echo] compilation complete

BUILD SUCCESSFUL
Total time: 0 seconds
```
* an ant build file consists of targets and tasks (like javac, echo, ...)
* to execute a specific target call with: `ant <target>` or multiple targets: `ant clean compile`

## run from command line
```
java -cp build/classes/ com.github.leventarican.ant.Main c c++
Ant
arg-0: c
arg-1: c++
```
