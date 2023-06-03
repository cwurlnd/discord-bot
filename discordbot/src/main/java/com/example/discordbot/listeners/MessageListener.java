package com.example.discordbot.listeners;

import java.util.Random;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {

    private String[] games = { "CS:GO", "Dead by Daylight", "GTFO", "Sea of Thieves", "Phasmophobia" };
    private int randomNum = 0;
    private String chosenGame = "UNKNOWN";

    public Mono<Void> processMessage(final Message eventMessage) {
        return Mono.just(eventMessage)
                .filter(message -> {
                    final Boolean isNotBot = message.getAuthor()
                            .map(user -> !user.isBot())
                            .orElse(false);
                    return isNotBot;
                })
                .filter(message -> {
                    final String myMessage = message.getContent();
                    Random generator = new Random();
                    randomNum = generator.nextInt(games.length);
                    chosenGame = games[randomNum];
                    return myMessage.equalsIgnoreCase("!choosegame");
                })
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel
                        .createMessage(String.format("The game I have chosen is ... %s!", chosenGame)))
                .then();
    }
}
