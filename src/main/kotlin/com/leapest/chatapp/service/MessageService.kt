package com.leapest.chatapp.service

import com.leapest.chatapp.dto.MessageBody
import com.leapest.chatapp.dto.MessageView
import com.leapest.chatapp.model.Message
import com.leapest.chatapp.repository.MessageRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.LocalDateTime

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun findWithTailableCursorByRoom(room: String): Flux<MessageView> {
        return this.messageRepository.findWithTailableCursorByRoom(room)
                .map { it -> MessageView(it.text, "anonymous", LocalDateTime.now()) }
    }

    fun newMessage(messageBody: MessageBody) {
        this.messageRepository.save(Message(null, messageBody.text, messageBody.room)).subscribe()
    }
}

