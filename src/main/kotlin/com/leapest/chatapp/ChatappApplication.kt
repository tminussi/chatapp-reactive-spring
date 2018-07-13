package com.leapest.chatapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatappApplication

fun main(args: Array<String>) {
    runApplication<ChatappApplication>(*args)
}
