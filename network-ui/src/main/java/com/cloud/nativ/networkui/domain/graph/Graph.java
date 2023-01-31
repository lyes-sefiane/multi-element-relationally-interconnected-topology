package com.cloud.nativ.networkui.domain.graph;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-28 10:13 p.m.
 */
public class Graph {

    @JsonProperty("nodes")
    List<Node> nodes = new ArrayList<>();

    @JsonProperty("links")
    List<Edge> links = new ArrayList<>();

    public Graph() {
        //
    }

    public Graph(List<Node> nodes, List<Edge> links) {
        this.nodes = nodes;
        this.links = links;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getLinks() {
        return links;
    }

    public void setLinks(List<Edge> links) {
        this.links = links;
        Collections.sort(links);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", links=" + links +
                '}';
    }
}
