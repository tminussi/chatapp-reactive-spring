package com.leapest.chatapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "messages")
data class Message(@Id val id: String?, val text: String, val room: String)
