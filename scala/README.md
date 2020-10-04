* get scale, decrompress it, add `bin/` directory to your `PATH`
* run scala cli with `scala`

# lazy evaluation
* init val with _lazy_
```
scala> val list1 = List(1, 2, 3)
list1: List[Int] = List(1, 2, 3)

scala> val out = list1.map(x => x*2)
out: List[Int] = List(2, 4, 6)

scala> println(out)
List(2, 4, 6)

scala> val list2 = List(1, 2, 3)
list2: List[Int] = List(1, 2, 3)

scala> lazy val out2 = list2.map(x => x*2)
out2: List[Int] = <lazy>

scala> print(out2)
List(2, 4, 6)
```

