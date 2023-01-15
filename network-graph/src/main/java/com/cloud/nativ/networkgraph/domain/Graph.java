package com.cloud.nativ.networkgraph.domain;

import com.cloud.nativ.networkgraph.domain.entities.GraphEdge;
import com.cloud.nativ.networkgraph.domain.entities.GraphNode;
import java.util.HashSet;
import java.util.Set;


/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:56 p.m.
 */
public class Graph {

    private Set<GraphNode> nodes = new HashSet<>();
    private Set<GraphEdge> edges = new HashSet<>();

    public Graph() {
        //
    }

    public Graph(Set<GraphNode> nodes, Set<GraphEdge> neighbors){
        this.nodes = nodes;
        this.edges = neighbors;
    }

    public Set<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public Set<GraphEdge> getEdges() {
        return edges;
    }

    public void setEdges(Set<GraphEdge> neighbors) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
