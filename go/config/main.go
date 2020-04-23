package main

import (
	"log"
	"reflect"

	"github.com/spf13/viper"
)

func init() {
	viper.SetConfigName("config")
	viper.SetConfigType("yaml")
	viper.AddConfigPath(".")
	err := viper.ReadInConfig()
	if err != nil {
		log.Fatalf("failed to read configuration# %s", err)
	}
}

func main() {
	java := viper.Get("java")
	log.Println("java config:", java)
	log.Println("java type:", reflect.TypeOf(java))
	log.Println(viper.Get("java.version"))
}