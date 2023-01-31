package com.cloud.nativ.networkgraph.graph;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Edge;
import com.cloud.nativ.networkgraph.domain.entities.GraphEdge;
import com.cloud.nativ.networkgraph.domain.entities.GraphNode;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-13 10:13 p.m.
 */
@Component
public class GraphAlgorithm implements IGraphAlgorithm {

    Logger logger = LoggerFactory.getLogger(GraphAlgorithm.class);

    private Graph graph;

    public GraphAlgorithm() {
        //
    }

    Function<Node, GraphNode> graphNodeFunction = node -> new GraphNode(node.getIpAddress(), node.getArea(), node.getElementType());

    BiFunction<Node, Edge, GraphEdge> graphEdgeBiFunction = ((node, edge) -> new GraphEdge(node.getIpAddress(), edge.getIpAddress(), edge.getCost()));

    @Override
    public Graph build(List<Node> nodes) {
        Set<GraphNode> graphNodes = new HashSet<>();
        Set<GraphEdge> graphEdges = new HashSet<>();

        if(CollectionUtils.isEmpty(nodes)) {
            logger.info("There is no graph to build. List of nodes is empty.");
            return new Graph();
        }

        for(Node node : nodes) {
            GraphNode graphNode = graphNodeFunction.apply(node);
            graphNodes.add(graphNode);
            for(Edge edge : node.getEdges()) {
                graphEdges.add(graphEdgeBiFunction.apply(node, edge));
            }
        }

        return new Graph(graphNodes, graphEdges);
    }

}
