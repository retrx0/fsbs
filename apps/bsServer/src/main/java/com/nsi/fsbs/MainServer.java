package com.nsi.fsbs;

import com.nsi.common.dto.UserRegistrationDTO;
import com.nsi.common.model.UserRole;
import com.nsi.common.model.jpa.User;
import com.nsi.common.model.jpa.UserMetadata;
import com.nsi.fsbs.repository.UserRepository;
import com.nsi.fsbs.services.kafka.impl.KafkaService;
import com.nsi.fsbs.services.web.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MainServer {

	private final KafkaService kafkaService;

	private final UserService userService;
	private final UserRepository userRepository;

	public MainServer(KafkaService kafkaService, UserService userService,
					  UserRepository userRepository) {
		this.kafkaService = kafkaService;
		this.userService = userService;
		this.userRepository = userRepository;
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
		newUser.setEmail("abdulrahmaniliyasu@gmail.com");
		newUser.setPhoneNumber("+36303517656");
		newUser.setGender("Male");
		newUser.setSex('M');
		newUser.setCountryCode("NG");
		newUser.setUserId(2L);
		newUser.setPictureUrl("");
		newUser.setDeleted(true);
		newUser.setRoles(List.of(UserRole.USER, UserRole.ADMIN));
		newUser.setPassword("password");
//		userService.registerNewUserAccount(newUser);

		UserMetadata userMetadata = new UserMetadata();



		User fetchedUser = userRepository.getById(1L);
		log.info("Fetched User: {}", fetchedUser);

	}

}
