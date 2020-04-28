package main

import (
	"fmt"
)

type Point struct {
	X int
	Y int
}

func (p Point) Add(pp Point) Point {
	return Point{p.X + pp.X, p.Y + pp.Y}
}

func main() {
	fmt.Println("go has no classes. you define methods on types.")
	p := Point{1, 1}
	pp := Point{2, 2}
	r := p.Add(pp)
	fmt.Println(r.X, r.Y)
}