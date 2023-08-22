package com.nsi.bs.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.nsi.common.constants.KafkaConfigConstants.KAFKA_FSBS_TOPIC;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(KAFKA_FSBS_TOPIC)
                .partitions(10)
                .replicas(1)
                .build();
    }
}
