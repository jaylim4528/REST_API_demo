package com.demo.restapi.restapidemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class RestApiDemoApplication

fun main(args: Array<String>) {
    runApplication<RestApiDemoApplication>(*args)
}
