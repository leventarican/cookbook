package main

import (
	"log"

	"github.com/spf13/viper"
)

func init() {
	viper.SetConfigFile(".env")
	viper.ReadInConfig()
}

func main() {
	log.Println("GO_VERSION:", viper.Get("GO_VERSION"))
	log.Println("PROGRAMMING_LANG:", viper.Get("PROGRAMMING_LANG"))
	log.Println("ENVIRONMENT:", viper.Get("ENVIRONMENT"))
}