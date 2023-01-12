package com.cloud.nativ.networkgraph.converter;

import com.cloud.nativ.networkcommon.messages.Message;
import com.cloud.nativ.networkcommon.messages.entities.Connection;
import com.cloud.nativ.networkgraph.domain.entities.Edge;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 2:56 p.m.
 */
@Component
public class NodeConverter implements Converter<Message, Node> {

    Function<Connection, Edge> edgeFunction = connection -> new Edge(connection.getIpAddress().toString(), connection.getCost());

    @Override
    public Node convert(Message message) {
        return new Node(message.getNetworkElement().getIpAddress().toString(),//
                message.getNetworkElement().getElementType().toString(),//
                message.getNetworkElement()//
                        .getConnections()//
                        .stream()//
                        .map(edgeFunction::apply)//
                        .collect(Collectors.toSet()));
    }
}
