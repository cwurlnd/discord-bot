package com.example.discordbot.service;

import org.springframework.stereotype.Service;
import com.example.discordbot.listeners.EventListener;
import com.example.discordbot.listeners.MessageListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateService extends MessageListener implements EventListener<MessageCreateEvent> {

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(final MessageCreateEvent event) {
        return processMessage(event.getMessage());
    }
}
