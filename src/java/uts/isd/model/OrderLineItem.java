package uts.isd.model;

import java.io.Serializable;

public class OrderLineItem implements Serializable {
    public int id;
    public double cost;
    public int quantity;
    public String name;
    public String storageLocation;
    public double tax;

    public OrderLineItem() {
    }

    public OrderLineItem(int id,double cost, int quantity, String name, String storageLocation, double tax) {
        this.id=id;
        this.cost = cost;
        this.quantity = quantity;
        this.name = name;
        this.storageLocation = storageLocation;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
