package com.nsi.fsbs.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static com.nsi.common.constants.KafkaConfigConstants.KAFKA_FSBS_BOOTSTRAP_ADDRESS;
import static com.nsi.common.constants.KafkaConfigConstants.KAFKA_FSBS_TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_FSBS_BOOTSTRAP_ADDRESS);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(KAFKA_FSBS_TOPIC)
                .partitions(10)
                .replicas(1)
                .build();
    }
}
