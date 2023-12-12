package com.rezarahmani.eventprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventProcessingApplication.class, args);
	}

}
