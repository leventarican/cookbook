# Java Code Coverage: JaCoCo

__config__
* set code coverage with rules
* if coverage is not meets the expected value then you will receive: `[WARNING] Rule violated for bundle jacoco: complexity covered ratio is 0.33, but expected minimum is 0.60`

__run__
* generate results with: `mvn clean verify`. html, ... are located in: `target/site/jacoco/`

__add dependency: maven-plugin / jacoco cli__
* this is optional if you define jacoco maven plugin in `<build><plugins>...`
* run: `mvn clean verify org.jacoco:jacoco-maven-plugin:report`
* add dependency for jacoco:
```
<dependency>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.5</version>
    <type>maven-plugin</type>
</dependency>
```

__help__
`mvn help:describe -Dplugin=org.jacoco:jacoco-maven-plugin -Ddetail`
