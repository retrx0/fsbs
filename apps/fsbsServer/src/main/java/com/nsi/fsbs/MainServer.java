package com.nsi.fsbs;

import com.nsi.common.dto.UserRegistrationDTO;
import com.nsi.fsbs.services.kafka.impl.KafkaService;
import com.nsi.fsbs.services.web.impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MainServer {

	private final KafkaService kafkaService;

	private final UserService userService;

	public MainServer(KafkaService kafkaService, UserService userService) {
		this.kafkaService = kafkaService;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainServer.class, args);
	}

	@PostConstruct
	void sendSomeMessages(){
//		for (int i = 0; i < 10; i++) {
//			kafkaService.sendMessage("Message from main server "+ i);
//		}
		UserRegistrationDTO newUser = new UserRegistrationDTO();
		newUser.setFirstName("Abdul");
		newUser.setLastName("Iliyasu");
		newUser.setEmail("abdulrahmaniliyasu86@gmail.com");
		newUser.setPhoneNumber("+36303517656");
		newUser.setGender("Male");
		newUser.setSex('M');
		newUser.setCountryCode("");
		newUser.setUserId("1");
		newUser.setPictureUrl("");
		newUser.setDeleted(true);
		userService.registerNewUserAccount(newUser);

	}

}
