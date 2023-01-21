package com.cloud.nativ.networkui.domain;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 5:13 p.m.
 */
public class Neighbor {

    private String address;

    private int cost;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "address='" + address + '\'' +
                ", cost=" + cost +
                '}';
    }
}
