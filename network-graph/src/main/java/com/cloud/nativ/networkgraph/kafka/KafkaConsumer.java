package com.cloud.nativ.networkgraph.kafka;


import com.cloud.nativ.networkcommon.messages.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-09 12:06 p.m.
 */
@Component
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "network-elements", groupId = "graph", autoStartup = "${listen.auto.start}")
    public void consumer(Message message){
        logger.info("> Received Message : {}", message);
    }

}
