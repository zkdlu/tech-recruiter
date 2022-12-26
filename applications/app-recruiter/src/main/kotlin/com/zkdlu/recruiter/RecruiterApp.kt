package com.zkdlu.recruiter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class RecruiterApp

fun main(args: Array<String>) {
    runApplication<RecruiterApp>(*args)
}