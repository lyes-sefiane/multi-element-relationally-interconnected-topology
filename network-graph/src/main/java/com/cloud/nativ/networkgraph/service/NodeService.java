package com.cloud.nativ.networkgraph.service;

import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.exception.NodeNotFoundException;
import com.cloud.nativ.networkgraph.repository.INodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:47 p.m.
 */
@Service
public class NodeService {

    private final INodeRepository nodeRepository;

    public NodeService(INodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public Node saveNode(Node node) {
        return nodeRepository.save(node);
    }

    public Node updateNode(Node node, String ipAddress) {
        Node existingNode = nodeRepository.findBy(ipAddress).orElseThrow(NodeNotFoundException::new);
        BeanUtils.copyProperties(node, existingNode);
        return nodeRepository.save(existingNode);
    }

    public void deleteNode(Node node) {
        Node existingNode = nodeRepository.findBy(node.getIpAddress()).orElseThrow(NodeNotFoundException::new);
        nodeRepository.delete(existingNode);
    }
}
