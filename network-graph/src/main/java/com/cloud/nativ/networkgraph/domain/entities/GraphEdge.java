package com.cloud.nativ.networkgraph.domain.entities;

import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-14 12:32 p.m.
 */
public class GraphEdge {

    private String source;

    private String destination;

    private int cost;

    public GraphEdge(){
        //
    }

    public GraphEdge(String source, String destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
        return getCost() == graphEdge.getCost() && getSource().equals(graphEdge.getSource()) && getDestination().equals(graphEdge.getDestination()) ||
                getCost() == graphEdge.getCost() && getSource().equals(graphEdge.getDestination()) && getDestination().equals(graphEdge.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getDestination(), getCost());
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                '}';
    }
}
