package com.cloud.nativ.networkelements.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-06 8:58 p.m.
 */
@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${kafka.topic.partitions}")
    private int partitionCount;

    @Value("${kafka.topic.replicas}")
    private int replicasCount;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName)
                .partitions(partitionCount)
                .replicas(replicasCount)
                .build();
    }

}
