package com.cloud.nativ.networkelements.service;

import com.cloud.nativ.networkcommon.messages.enums.Status;
import com.cloud.nativ.networkelements.converter.IModelMapper;
import com.cloud.nativ.networkelements.converter.KafkaMessageConverter;
import com.cloud.nativ.networkelements.domain.entities.Connection;
import com.cloud.nativ.networkelements.domain.entities.Neighbor;
import com.cloud.nativ.networkelements.domain.entities.NetworkDevice;
import com.cloud.nativ.networkelements.dto.entities.NetworkDeviceDto;
import com.cloud.nativ.networkelements.exception.NetworkDeviceAlreadyExistsException;
import com.cloud.nativ.networkelements.exception.NetworkDeviceNotFoundException;
import com.cloud.nativ.networkelements.kafka.KafkaProducer;
import com.cloud.nativ.networkelements.repository.INeighborRepository;
import com.cloud.nativ.networkelements.repository.INetworkDeviceRepository;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 2:31 p.m.
 */
@Service
@Transactional
public class NetworkDeviceService implements IService<NetworkDeviceDto> {

    private final INetworkDeviceRepository networkDeviceRepository;

    private final INeighborRepository neighborRepository;

    private final IModelMapper<NetworkDeviceDto, NetworkDevice> modelMapper;

    private final KafkaProducer kafkaProducer;

    private final KafkaMessageConverter kafkaMessageConverter;

    @Autowired
    public NetworkDeviceService(INetworkDeviceRepository networkDeviceRepository, INeighborRepository neighborRepository, IModelMapper<NetworkDeviceDto, NetworkDevice> modelMapper, KafkaProducer kafkaProducer, KafkaMessageConverter kafkaMessageConverter) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.neighborRepository = neighborRepository;
        this.modelMapper = modelMapper;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageConverter = kafkaMessageConverter;
    }

    /**
     * Find Network Devices
     *
     * @return networkDevicesDto
     */
    @Cacheable(cacheNames = "networkDevices")
    @Override
    public List<NetworkDeviceDto> findAll() {
        return networkDeviceRepository.findAll()
                .stream()
                .map(modelMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Find Network Device
     *
     * @param id
     * @return networkDeviceDto
     */
    @Cacheable(cacheNames = "networkDevice", key ="#id")
    @Override
    public NetworkDeviceDto findById(String id) {
        return modelMapper.toDto(networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new));
    }

    /**
     * Create Network Device
     *
     * @param networkDeviceDto
     * @return networkDeviceDto
     */
    @Caching(put = @CachePut(cacheNames = "networkDevice", key = "#networkDeviceDto.address"),
            evict = @CacheEvict(cacheNames = "networkDevices", allEntries = true))
    @Override
    public NetworkDeviceDto save(NetworkDeviceDto networkDeviceDto) {
        networkDeviceRepository.findById(networkDeviceDto.getAddress())//
                .ifPresent(networkDevice -> {
                    throw new NetworkDeviceAlreadyExistsException(networkDevice);
        });

        NetworkDevice networkDevice = modelMapper.toEntity(networkDeviceDto);
        Set<Neighbor> neighbors = getNeighbors(networkDevice);
        Neighbor neighborFromNetworkDeviceSelf = new Neighbor(networkDevice.getIpAddress());
        neighbors.add(neighborFromNetworkDeviceSelf);
        neighborRepository.saveAll(neighbors);
        NetworkDevice savedNetworkDevice = networkDeviceRepository.save(networkDevice);

        if (savedNetworkDevice != null) {
            kafkaProducer.sendMessage(kafkaMessageConverter.convert(Pair.of(savedNetworkDevice, Status.NEW)));
        }

        return modelMapper.toDto(savedNetworkDevice);
    }

    /**
     * Update Network Device
     *
     * @param networkDeviceDto
     * @param id
     * @return networkDeviceDto
     */
    @Caching(put = @CachePut(cacheNames = "networkDevice", key = "#id"),
            evict = @CacheEvict(cacheNames = "networkDevices", allEntries = true))
    @Override
    public NetworkDeviceDto update(NetworkDeviceDto networkDeviceDto, String id) {
        NetworkDevice existingNetworkDevice = networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new);
        NetworkDevice receivedNetworkDevice = modelMapper.toEntity(networkDeviceDto);
        BeanUtils.copyProperties(receivedNetworkDevice, existingNetworkDevice);
        Set<Neighbor> neighbors = getNeighbors(receivedNetworkDevice);
        neighborRepository.saveAll(neighbors);
        if (existingNetworkDevice != null) {
            kafkaProducer.sendMessage(kafkaMessageConverter.convert(Pair.of(existingNetworkDevice, Status.UPDATE)));
        }
        return modelMapper.toDto(networkDeviceRepository.save(existingNetworkDevice));
    }

    /**
     * Delete Network Device
     *
     * @param id
     */
    @Caching(evict = {
            @CacheEvict(cacheNames = "networkDevices", allEntries = true),
            @CacheEvict(cacheNames = "networkDevice", key = "#id")
    })
    @Override
    public void delete(String id) {
        NetworkDevice networkDeviceToDelete = networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new);
        networkDeviceRepository.delete(networkDeviceToDelete);
        neighborRepository.findById(id).ifPresent(neighborRepository::delete);
        if(networkDeviceToDelete != null) {
            kafkaProducer.sendMessage(kafkaMessageConverter.convert(Pair.of(networkDeviceToDelete, Status.DELETE)));
        }
    }

    /**
     * Get Neighbors
     *
     * @param networkDevice
     * @return Neighbors
     */
    private Set<Neighbor> getNeighbors(NetworkDevice networkDevice) {
        return networkDevice.getConnections()//
                .stream()//
                .map(Connection::getNeighbor)//
                .collect(Collectors.toSet());
    }

}
