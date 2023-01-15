package com.cloud.nativ.networkgraph.domain.entities;

import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-14 12:29 p.m.
 */
public class GraphNode {

    private String ipAddress;

    private int area;

    private String elementType;

    public GraphNode() {
        //
    }

    public GraphNode(String ipAddress, int area, String elementType) {
        this.ipAddress = ipAddress;
        this.area = area;
        this.elementType = elementType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
        return getIpAddress().equals(graphNode.getIpAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIpAddress());
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "ipAddress='" + ipAddress + '\'' +
                ", area=" + area +
                ", elementType='" + elementType + '\'' +
                '}';
    }
}
