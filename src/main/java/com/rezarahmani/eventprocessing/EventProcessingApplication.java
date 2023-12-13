package com.rezarahmani.eventprocessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootApplication
@EnableScheduling
public class EventProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventProcessingApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public PodamFactory podamFactory() {
		return new PodamFactoryImpl();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
