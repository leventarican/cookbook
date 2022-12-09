README.md

# run
* one first run `.gradle/` folder is created
```bash
# by default task hello will be executed

# 
gradle hello run task in execution phase
gradle :hello run task in configuration phase
gradle -q hello

# another example
gradle -q code
```

# system environment
```bash
gradle -version

------------------------------------------------------------
Gradle 7.6
------------------------------------------------------------

Kotlin:       1.7.10
Groovy:       3.0.13
Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
JVM:          11.0.15 (Azul Systems, Inc. 11.0.15+10-LTS)
OS:           Linux 5
```

# settings.gradle.kts and build.gradle.kts
* Beside the build script files, Gradle defines a settings file. 
* The settings file is executed during the initialization phase.

# phases
A Gradle build has three distinct phases.
* Initialization
* Configuration
* Execution

# additional information

Kotlin Multiplatform Gradle plugin
* https://kotlinlang.org/docs/multiplatform-dsl-reference.html
```java
kotlin("multiplatform")
```

Gradle provides build-in _core_ plugins.
* https://docs.gradle.org/current/userguide/plugin_reference.html
* https://docs.gradle.org/current/javadoc/org/gradle/plugin/use/PluginDependenciesSpec.html
```
// Applying a core plugin
plugins {
    // Core plugins must be specified without a version number
    java
    // or
    id("java")
}
```

Applying a plugin means actually executing the plugin’s Plugin.apply(T) on the Project you want to enhance with the plugin. Applying plugins is _idempotent_.
* https://docs.gradle.org/current/userguide/plugins.html

GPT
> apply() method is a useful tool for applying configuration to projects

# sources
* https://docs.gradle.org/current/userguide/build_lifecycle.html