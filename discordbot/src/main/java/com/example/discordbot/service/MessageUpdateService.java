package com.example.discordbot.service;

import org.springframework.stereotype.Service;
import com.example.discordbot.listeners.EventListener;
import com.example.discordbot.listeners.MessageListener;
import discord4j.core.event.domain.message.MessageUpdateEvent;
import reactor.core.publisher.Mono;

@Service
public class MessageUpdateService extends MessageListener implements EventListener<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getEventType() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> execute(final MessageUpdateEvent event) {
        return Mono.just(event)
            .filter(MessageUpdateEvent::isContentChanged)
            .flatMap(MessageUpdateEvent::getMessage)
            .flatMap(super::processMessage);
    }
}
