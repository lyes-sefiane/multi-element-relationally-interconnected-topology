package com.cloud.nativ.networkgraph.service;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.repository.INodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:21 p.m.
 */
@Service
public class GraphService {

    private final INodeRepository nodeRepository;

    public GraphService(INodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }
    public Graph buildGraph() {
        List<Node> nodes = findAllNodes();
        return buildGraph(nodes);
    }

    private Graph buildGraph(List<Node> nodes) {
        // @TODO
        return null;
    }

    // Cache <-
    private List<Node> findAllNodes() {
        return nodeRepository.findAll();
    }
}
