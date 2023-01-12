package com.cloud.nativ.networkgraph.service;

import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.repository.INodeRepository;
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

    public void updateNode(Node convert) {
        // @TODO
    }

    public void deleteNode(Node convert) {
        // @TODO
    }
}
