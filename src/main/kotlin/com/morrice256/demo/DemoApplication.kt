package com.morrice256.demo

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(
	"com.morrice256.demo.controller.*",
	"com.morrice256.demo.domain.*",
	"com.morrice256.demo.service.*"
)
class DemoApplication {

	@Value("\${spring.profiles.active}")
	var profileActive: String = ""

	@Value("\${demo.value}")
	var demoValue: String = ""

	@PostConstruct
	fun showProfileActive() {
		println("================================")
		println(" ")
		println("Profile Active: ${profileActive} - ${demoValue}" )
		println(" ")
		println("================================")
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}