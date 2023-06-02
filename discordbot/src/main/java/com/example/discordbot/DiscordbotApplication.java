package com.example.discordbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DiscordbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscordbotApplication.class, args);
	}

}
