package com.cloud.nativ.networkelements.kafka;


import com.cloud.nativ.networkcommon.messages.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-06 9:06 p.m.
 */
@Component
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private static final String TOPIC = "network-elements";

    public KafkaProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message) {

        logger.info("$$$$ => Producing message: {}", message);

        CompletableFuture<SendResult<String, Message>> future = this.kafkaTemplate.send(TOPIC,  message);

        future.thenApply(result -> {
                    logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
                    return result.getRecordMetadata().offset();
                })
                .exceptionally(ex -> {
                    logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
                    return (long) ex.hashCode();
                });
    }
}
