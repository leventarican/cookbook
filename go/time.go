package main

import (
	"log"
	"time"
)

func main() {
	t0 := time.Now()
	time.Sleep(time.Second * 2)
	log.Println("elapsed time:", time.Since(t0))

	t1 := time.Now()
	log.Printf("elapsed time: %v", t1.Sub(t0))
}
