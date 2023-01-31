package com.cloud.nativ.networkgraph.domain;

import com.cloud.nativ.networkgraph.domain.entities.GraphEdge;
import com.cloud.nativ.networkgraph.domain.entities.GraphNode;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashSet;
import java.util.Set;


/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:56 p.m.
 */
@JsonPropertyOrder({"nodes", "links"})
public class Graph {

    private Set<GraphNode> nodes = new HashSet<>();
    private Set<GraphEdge> links = new HashSet<>();

    public Graph() {
        //
    }

    public Graph(Set<GraphNode> nodes, Set<GraphEdge> links){
        this.nodes = nodes;
        this.links = links;
    }

    public Set<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public Set<GraphEdge> getLinks() {
        return links;
    }

    public void setLinks(Set<GraphEdge> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", links=" + links +
                '}';
    }
}
