package com.cloud.nativ.networkgraph.service;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.graph.IGraphAlgorithm;
import com.cloud.nativ.networkgraph.repository.INodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:21 p.m.
 */
@Service
public class GraphService {

    private final INodeRepository nodeRepository;

    private final IGraphAlgorithm graphAlgorithm;

    public GraphService(INodeRepository nodeRepository, IGraphAlgorithm graphAlgorithm) {
        this.nodeRepository = nodeRepository;
        this.graphAlgorithm = graphAlgorithm;
    }

    public Graph findByArea(int area) {
        List<Node> nodes = findBy(area);
        if(CollectionUtils.isEmpty(nodes)){
            return new Graph();
        }
        return graphAlgorithm.build(nodes);
    }

    // @TODO : Redis Cache
    private List<Node> findBy(int area) {
        return nodeRepository.findBy(area);
    }
}
