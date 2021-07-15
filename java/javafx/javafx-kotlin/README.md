# JavaFX with Kotlin
* create a sample maven project
```bash
mvn archetype:generate \
        -DarchetypeGroupId=org.openjfx \
        -DarchetypeArtifactId=javafx-archetype-simple \
        -DarchetypeVersion=0.0.3 \
        -DgroupId=com.github.leventarican \
        -DartifactId=javafx-kotlin \
        -Dversion=1.0.0 \
        -Djavafx-version=15.0.1
```
* now if you want you can check / run the sample app for java
```bash
# mvn clean package
mvn clean javafx:run
```
* convert project to kotlin. follow the descriptions in the link bellow. You need to use `kotlin-maven-plugin`
* when using intellij ensure to set the right maven version in your environment then you can build the project also in terminal
* afterwards run main function in `Main.kt` in intellij

## Links
* https://openjfx.io/openjfx-docs/#maven
* https://kotlinlang.org/docs/maven.html