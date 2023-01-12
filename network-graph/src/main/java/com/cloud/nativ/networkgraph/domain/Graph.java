package com.cloud.nativ.networkgraph.domain;

import com.cloud.nativ.networkgraph.domain.entities.Edge;
import com.cloud.nativ.networkgraph.domain.entities.Node;
import java.util.HashSet;
import java.util.Set;


/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:56 p.m.
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public Graph() {
        //
    }

    public Graph(Set<Node> nodes, Set<Edge> edges){
        this.nodes = nodes;
        this.edges = edges;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
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
