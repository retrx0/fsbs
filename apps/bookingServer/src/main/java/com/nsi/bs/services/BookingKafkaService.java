package com.nsi.bs.services;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.nsi.common.constants.KafkaConfigConstants.KAFKA_BOOKING_TOPIC;

@Service
@AllArgsConstructor
public class BookingKafkaService {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(KAFKA_BOOKING_TOPIC, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }
}
