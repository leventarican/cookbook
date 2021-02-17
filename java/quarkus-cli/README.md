# Quarkus: Command Mode

## Output
* run in dev mode: `mvn compile quarkus:dev`

```
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2021-02-16 23:50:41,446 INFO  [io.quarkus] (Quarkus Main Thread) quarkus-cli 0.0.1 on JVM (powered by Quarkus 1.11.3.Final) started in 0.959s. 
2021-02-16 23:50:41,450 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2021-02-16 23:50:41,450 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi]
Java version: 15
2021-02-16 23:50:41,529 INFO  [io.quarkus] (Quarkus Main Thread) quarkus-cli stopped in 0.058s
Quarkus application exited with code 100
Press Enter to restart or Ctrl + C to quit
```
* run with QUARKUS_PROFILE
* example `%staging` in `application.properties`
```
mvn -Dquarkus-profile=staging compile quarkus:dev
```
