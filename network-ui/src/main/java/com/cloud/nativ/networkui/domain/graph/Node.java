package com.cloud.nativ.networkui.domain.graph;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-28 10:14 p.m.
 */
public class Node {

    private String id;

    private int area;

    private String elementType;

    public Node() {
        //
    }

    public Node(String id, int area, String elementType) {
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
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", elementType='" + elementType + '\'' +
                '}';
    }
}
