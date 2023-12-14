package com.example.springjava21;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJava21Application {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper()
				.registerModule(new JavaTimeModule())
				.findAndRegisterModules();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(SpringJava21Application.class, args);
	}

}
