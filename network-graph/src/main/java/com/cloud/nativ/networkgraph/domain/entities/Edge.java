package com.cloud.nativ.networkgraph.domain.entities;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:47 p.m.
 */
public class Edge {

    private String ipAddress;

    private int cost;


    public Edge(String ipAddress, int cost) {
        this.ipAddress = ipAddress;
        this.cost = cost;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "ipAddress='" + ipAddress + '\'' +
                ", cost=" + cost +
                '}';
    }
}
