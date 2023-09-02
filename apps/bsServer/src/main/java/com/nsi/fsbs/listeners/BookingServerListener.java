package com.nsi.fsbs.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.nsi.common.constants.KafkaConfigConstants.KAFKA_BOOKING_GROUP_ID;
import static com.nsi.common.constants.KafkaConfigConstants.KAFKA_BOOKING_TOPIC;

@Service
public class BookingServerListener {

//    @KafkaListener(topics = KAFKA_BOOKING_TOPIC, groupId = KAFKA_BOOKING_GROUP_ID)
//    public static void onBookingMessageReceived(String message){
//        System.out.println("FSBS Server: message from booking server: "+ message);
//    }

}
