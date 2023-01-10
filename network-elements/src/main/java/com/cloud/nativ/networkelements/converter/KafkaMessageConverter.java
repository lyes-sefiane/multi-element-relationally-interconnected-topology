package com.cloud.nativ.networkelements.converter;

import com.cloud.nativ.networkcommon.messages.Message;
import com.cloud.nativ.networkcommon.messages.entities.Connection;
import com.cloud.nativ.networkcommon.messages.entities.NetworkElement;
import com.cloud.nativ.networkcommon.messages.enums.Status;
import com.cloud.nativ.networkelements.domain.entities.NetworkDevice;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 12:01 p.m.
 */
@Component
public class KafkaMessageConverter implements Converter<Pair<NetworkDevice, Status>, Message> {

    @Override
    public Message convert(Pair<NetworkDevice, Status> networkDevice) {

        Function<NetworkDevice, List<Connection>> connectionFunction = device -> device.getConnections()//
                .stream()//
                .map(connection -> Connection.newBuilder()//
                        .setCost(connection.getCost())//
                        .setIpAddress(connection.getNeighbor().getIpAddress())//
                        .build())//
                .collect(Collectors.toList());

        Function<NetworkDevice, NetworkElement> networkElementFunction = (device) -> NetworkElement.newBuilder()//
                .setIpAddress(device.getIpAddress())//
                .setElementType(device.getElementType().getValue())//
                .setConnections(connectionFunction.apply(device))//
                .build();

        return Message.newBuilder()//
                .setDate(LocalDate.now())//
                .setNetworkElement(networkElementFunction.apply(networkDevice.getKey()))//
                .setStatus(networkDevice.getValue().getValue())
                .build();
    }
}
