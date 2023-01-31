package com.cloud.nativ.networkui.domain.graphql;

import com.cloud.nativ.networkui.domain.graph.Graph;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-29 5:26 p.m.
 */
public class Data {

    @JsonProperty("retrieveGraph")
    private Graph graph;


    public Data() {
        //
    }

    public Data(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public String toString() {
        return "Data{" +
                "graph=" + graph +
                '}';
    }
}
