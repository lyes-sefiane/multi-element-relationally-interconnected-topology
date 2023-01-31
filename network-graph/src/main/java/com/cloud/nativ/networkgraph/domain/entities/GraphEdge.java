package com.cloud.nativ.networkgraph.domain.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-14 12:32 p.m.
 */
@JsonPropertyOrder({"source", "target","cost"})
public class GraphEdge {

    private String source;

    private String target;

    private int cost;

    public GraphEdge(){
        //
    }

    public GraphEdge(String source, String target, int cost) {
        this.source = source;
        this.target = target;
        this.cost = cost;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphEdge)) return false;
        GraphEdge graphEdge = (GraphEdge) o;
        return getCost() == graphEdge.getCost() && getSource().equals(graphEdge.getSource()) && getTarget().equals(graphEdge.getTarget()) ||
                getCost() == graphEdge.getCost() && getSource().equals(graphEdge.getTarget()) && getTarget().equals(graphEdge.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getTarget(), getCost());
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", cost=" + cost +
                '}';
    }
}
