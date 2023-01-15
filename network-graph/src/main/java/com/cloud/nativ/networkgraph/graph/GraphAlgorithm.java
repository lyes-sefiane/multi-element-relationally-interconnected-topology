package com.cloud.nativ.networkgraph.graph;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Edge;
import com.cloud.nativ.networkgraph.domain.entities.GraphEdge;
import com.cloud.nativ.networkgraph.domain.entities.GraphNode;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-13 10:13 p.m.
 */
@Component
public class GraphAlgorithm implements IGraphAlgorithm {

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
            // or Create custom exception ?
            throw new RuntimeException("There is no graph to build. List of nodes is empty.");
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
