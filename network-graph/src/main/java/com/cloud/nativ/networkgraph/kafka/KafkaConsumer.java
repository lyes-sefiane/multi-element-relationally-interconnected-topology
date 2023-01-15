package com.cloud.nativ.networkgraph.kafka;


import com.cloud.nativ.networkcommon.messages.Message;
import com.cloud.nativ.networkcommon.messages.enums.Status;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.service.node.INodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
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

    private final INodeService nodeService;

    private final Converter<Message, Node> nodeConverter;
    public KafkaConsumer(INodeService nodeService, Converter<Message, Node> nodeConverter){
        this.nodeService = nodeService;
        this.nodeConverter = nodeConverter;
    }

    @KafkaListener(topics = "network-elements", groupId = "graph", autoStartup = "${listen.auto.start}")
    public void consumer(Message message) {
        Status status = Status.getEnumByValue(message.getStatus().toString());
        switch (status) {
            case NEW:
                logger.info("> Received Message : {}", message);
                nodeService.saveNode(nodeConverter.convert(message));
                break;
            case UPDATE:
                logger.info("> Received Message : {}", message);
                nodeService.updateNode(nodeConverter.convert(message), message.getNetworkElement().getIpAddress().toString());
                break;
            case DELETE:
                logger.info("> Received Message : {}", message);
                nodeService.deleteNode(nodeConverter.convert(message));
                break;
            case UNKNOWN:
                throw new UnsupportedOperationException("Unable to process message. Reason : Unknown status");

        }

    }

}
