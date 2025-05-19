package com.cloud.nativ.networkui.domain;

import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 5:12 p.m.
 */
public class NetworkElement {

    @NotBlank(message = "address should not be empty.")
    private String address;

    @NotBlank(message = "elementType should not be empty.")
    private String elementType;

    @Range(min = 0l, message = "area should be a positive number.")
    private int area;

    @Valid
    private List<Neighbor> neighbors = new ArrayList<>();

    public NetworkElement(){
        //
    }
    public NetworkElement(String address, String elementType, int area, List<Neighbor> neighbors) {
        this.address = address;
        this.elementType = elementType;
        this.area = area;
        this.neighbors = neighbors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Neighbor> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Neighbor> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "NetworkElement{" +
                "address='" + address + '\'' +
                ", elementType='" + elementType + '\'' +
                ", area=" + area +
                ", neighbors=" + neighbors +
                '}';
    }
}
