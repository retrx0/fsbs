package com.nsi.bs.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.nsi.common.constants.KafkaConfigConstants.*;
@Service
public class KafkaListeners {

    @KafkaListener(topics = KAFKA_FSBS_TOPIC, groupId = KAFKA_GROUP_ID)
    public static void onMessage(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
