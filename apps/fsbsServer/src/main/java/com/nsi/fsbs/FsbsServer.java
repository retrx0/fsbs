package com.nsi.fsbs;

import com.nsi.fsbs.services.kafka.impl.KafkaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FsbsServer {

	private final KafkaService kafkaService;

	public FsbsServer(KafkaService kafkaService) {
		this.kafkaService = kafkaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FsbsServer.class, args);
	}

	@PostConstruct
	void init(){
		kafkaService.sendMessage("helllooooo");
	}

}
