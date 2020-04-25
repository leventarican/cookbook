package main

import (
	"testing"
)

func TestMulti(t *testing.T) {
	got := Demo()
	
	if got != 2 {
		t.Errorf("expected 2, got: %v", got)
	}
}