package com.cloud.nativ.networkgraph.domain.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-14 12:29 p.m.
 */
@JsonPropertyOrder({"id", "area","elementType"})
public class GraphNode {

    private String id;

    private int area;

    private String elementType;

    public GraphNode() {
        //
    }

    public GraphNode(String id, int area, String elementType) {
        this.id = id;
        this.area = area;
        this.elementType = elementType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphNode)) return false;
        GraphNode graphNode = (GraphNode) o;
        return getId().equals(graphNode.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", elementType='" + elementType + '\'' +
                '}';
    }
}
