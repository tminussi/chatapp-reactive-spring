package com.leapest.chatapp.controller

import com.leapest.chatapp.dto.MessageBody
import com.leapest.chatapp.dto.MessageView
import com.leapest.chatapp.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/messages")
class MessageController(val messageService: MessageService) {

    @GetMapping(produces = [(MediaType.TEXT_EVENT_STREAM_VALUE)])
    fun allMessages(@RequestParam room: String): Flux<MessageView> {
        return this.messageService.findWithTailableCursorByRoom(room)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun newMessage(@RequestBody messageBody: MessageBody) {
        this.messageService.newMessage(messageBody)
    }

}





