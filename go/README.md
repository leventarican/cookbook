# golang
* go language
* go compiles realy quick: the compiler look at the libs that are included.
* go concurrency is done with goroutines and channels. with channels data can pass between goroutines in synchronized / safely way.

## get go work (= install)
* download package from: https://golang.org/dl/
* decompress file: `tar -xzf go1.14.2.linux-amd64.tar.gz`
* add bin folder `go/bin` to your `PATH` variable e.g. in your `.profile` file. reload .profile if needed: `source ~/.profile`
```
$ go version
go version go1.14.2 linux/amd64
```

## quick start
* code, compile and run: `go run main.go`
