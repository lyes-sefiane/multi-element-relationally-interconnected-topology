package com.cloud.nativ.networkui.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 5:13 p.m.
 */

public class Neighbor {

    @NotBlank(message = "address should not be empty.")
    private String address;

    @Range(min = 0l, message = "area should be a positive number.")
    private int cost;

    public Neighbor() {
        //
    }

    public Neighbor(String address, int cost) {
        this.address = address;
        this.cost = cost;
    }

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
