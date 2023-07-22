package com.morrice256.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(
	"com.morrice256.demo.controller.*",
	"com.morrice256.demo.domain.*",
	"com.morrice256.demo.service.*"
)
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}