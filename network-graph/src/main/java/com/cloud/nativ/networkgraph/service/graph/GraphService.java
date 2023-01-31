package com.cloud.nativ.networkgraph.service.graph;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.graph.IGraphAlgorithm;
import com.cloud.nativ.networkgraph.service.node.INodeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:21 p.m.
 */
@Service
public class GraphService implements IGraphService {

    private final INodeService nodeService;

    private final IGraphAlgorithm graphAlgorithm;

    public GraphService(INodeService nodeService, IGraphAlgorithm graphAlgorithm) {
        this.nodeService = nodeService;
        this.graphAlgorithm = graphAlgorithm;
    }

    @Override
    public Graph buildByArea(int area) {
        List<Node> nodes = nodeService.findAll()//
                .stream()//
                .filter(node -> node.getArea() == area)//
                .collect(Collectors.toList());
        return graphAlgorithm.build(nodes);
    }

    @Override
    public Graph buildAll() {
        List<Node> nodes = nodeService.findAll();
        return graphAlgorithm.build(nodes);
    }
}
