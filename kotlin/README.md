# Kotlin Lang

## Compile and Run
```
kotlinc main.kt
kotlin MainKt

kotlinc main.kt && kotlin MainKt

kotlinc main.kt -include-runtime -d main.jar
java -jar main.jar
```

## Generics
* Variance
* Covariance (out): Producer of `T`
* Contravariance (in): Consumer of `T`
* Conventions
```
E = element
T = type
K = key
V = value
```

## Links
asynchronous or non-blocking programming \
https://kotlinlang.org/docs/coroutines-overview.html  

keywords: `by`, `as`, ... \
https://kotlinlang.org/docs/keyword-reference.html
