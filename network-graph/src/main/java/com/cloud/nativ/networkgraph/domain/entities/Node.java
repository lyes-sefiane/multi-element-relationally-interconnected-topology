package com.cloud.nativ.networkgraph.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:47 p.m.
 */
@Document
public class Node {
    @Id
    private String id;
    private String ipAddress;

    private int area;

    private String elementType;

    private Set<Edge> edges = new HashSet<>();

    public Node(String ipAddress, int area, String elementType, Set<Edge> edges) {
        this.ipAddress = ipAddress;
        this.area = area;
        this.elementType = elementType;
        this.edges = edges;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", area=" + area +
                ", elementType='" + elementType + '\'' +
                ", edges=" + edges +
                '}';
    }
}
