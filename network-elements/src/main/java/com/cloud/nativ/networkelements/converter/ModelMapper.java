package com.cloud.nativ.networkelements.converter;

import com.cloud.nativ.networkelements.controller.NetworkDeviceController;
import com.cloud.nativ.networkelements.domain.entities.Connection;
import com.cloud.nativ.networkelements.domain.entities.Neighbor;
import com.cloud.nativ.networkelements.domain.entities.NetworkDevice;
import com.cloud.nativ.networkelements.domain.enums.ElementType;
import com.cloud.nativ.networkelements.dto.entities.NeighborDto;
import com.cloud.nativ.networkelements.dto.entities.NetworkDeviceDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:17 p.m.
 */
@Component
public class ModelMapper implements IModelMapper<NetworkDeviceDto, NetworkDevice> {

    /**
     * Convert DTO to Entity
     *
     * @param networkDeviceDto
     * @return networkDevice
     */
    @Override
    public NetworkDevice toEntity(NetworkDeviceDto networkDeviceDto) {

        NetworkDevice networkDevice = NetworkDevice.builder()//
                .ipAddress(networkDeviceDto.getAddress())//
                .elementType(ElementType.getEnumByValue(networkDeviceDto.getElementType()))//
                .build();

        Set<Connection> connections = networkDeviceDto.getNeighbors()//
                .stream()//
                .map(neighborDto -> new Connection(networkDevice, new Neighbor(neighborDto.getAddress()), neighborDto.getCost()))//
                .collect(Collectors.toSet());

        networkDevice.setConnections(connections);

        return networkDevice;
    }

    /**
     * Convert Entity to DTO
     *
     * @param networkDevice
     * @return networkDeviceDto
     */
    @Override
    public NetworkDeviceDto toDto(NetworkDevice networkDevice) {

        NetworkDeviceDto networkDeviceDto = NetworkDeviceDto.builder()//
                .address(networkDevice.getIpAddress())//
                .elementType(networkDevice.getElementType().getValue())//
                .build();

        Set<NeighborDto> neighbors = networkDevice.getConnections()//
                .stream()//
                .map(connection -> new NeighborDto(connection.getConnectionId().getNeighbor_ipaddress(), connection.getCost()))//
                .collect(Collectors.toSet());

        networkDeviceDto.setNeighbors(neighbors);

        return networkDeviceDto;
    }
}
