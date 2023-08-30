package com.nsi.bs;

import com.nsi.bs.services.BookingKafkaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BookingServer {


    BookingKafkaService kafkaService;

    public BookingServer(BookingKafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookingServer.class, args);
    }

    @PostConstruct
    void sendSomeTestMessage(){
        for (int i = 0; i < 10; i++) {
            kafkaService.sendMessage("Message from Booking server "+ i);
        }
    }
}