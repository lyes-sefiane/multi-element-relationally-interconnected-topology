package com.cloud.nativ.networkgraph.service.node;

import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.exception.NodeNotFoundException;
import com.cloud.nativ.networkgraph.repository.INodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:47 p.m.
 */
@Service
public class NodeService implements INodeService {

    private final INodeRepository nodeRepository;

    public NodeService(INodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Cacheable(cacheNames = "nodes")
    @Override
    public List<Node> findAll() {
        return nodeRepository.findAll(Sort.by(Sort.Direction.ASC, "ipAddress"));
    }

    @Caching(put = @CachePut(cacheNames = "node", key = "#node.id"),
            evict = @CacheEvict(cacheNames = "nodes", allEntries = true))
    @Override
    public Node saveNode(Node node) {
        return nodeRepository.save(node);
    }

    @Caching(put = @CachePut(cacheNames = "node", key = "#node.id"),
            evict = @CacheEvict(cacheNames = "nodes", allEntries = true))
    @Override
    public Node updateNode(Node node, String ipAddress) {
        Node existingNode = nodeRepository.findBy(ipAddress).orElseThrow(NodeNotFoundException::new);
        BeanUtils.copyProperties(node, existingNode);
        return nodeRepository.save(existingNode);
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "nodes", allEntries = true),
            @CacheEvict(cacheNames = "node", key = "#node.id")
    })
    @Override
    public void deleteNode(Node node) {
        Node existingNode = nodeRepository.findBy(node.getIpAddress()).orElseThrow(NodeNotFoundException::new);
        nodeRepository.delete(existingNode);
    }
}
