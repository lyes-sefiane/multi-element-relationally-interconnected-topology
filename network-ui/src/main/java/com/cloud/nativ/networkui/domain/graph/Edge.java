package com.cloud.nativ.networkui.domain.graph;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-28 10:14 p.m.
 */
public class Edge implements Comparable<Edge> {

    private String source;

    private String target;

    private int cost;

    public Edge() {
        //
    }

    public Edge(String source, String target, int cost) {
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
    public int compareTo(Edge other) {
        return this.getSource().compareTo(other.getSource());
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", cost=" + cost +
                '}';
    }
}
