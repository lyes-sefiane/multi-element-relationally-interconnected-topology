package com.cloud.nativ.networkgraph.service.graph;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import com.cloud.nativ.networkgraph.graph.IGraphAlgorithm;
import com.cloud.nativ.networkgraph.service.node.INodeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    public Graph findByArea(int area) {
        List<Node> nodes = nodeService.findBy(area);
        if(CollectionUtils.isEmpty(nodes)) {
            return new Graph();
        }
        return graphAlgorithm.build(nodes);
    }
}
