package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

public class Supply implements Serializable {

    public String productName;
    public double productPrice;
    public int discount;
    public Date productAddedDate;
    public int weight;
    public Date productExpiryDate;
    public int productHeight;
    public int productWidth;
    public int productLength;
    public String productLocation;

    public Supply() {
    }

    public Supply(String productName, double productPrice, int discount, Date productAddedDate, int weight, Date productExpiryDate, int productHeight, int productWidth, int productLength, String productLocation) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discount = discount;
        this.productAddedDate = productAddedDate;
        this.weight = weight;
        this.productExpiryDate = productExpiryDate;
        this.productHeight = productHeight;
        this.productWidth = productWidth;
        this.productLength = productLength;
        this.productLocation = productLocation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getProductAddedDate() {
        return productAddedDate;
    }

    public void setProductAddedDate(Date productAddedDate) {
        this.productAddedDate = productAddedDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(Date productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public int getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(int productHeight) {
        this.productHeight = productHeight;
    }

    public int getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(int productWidth) {
        this.productWidth = productWidth;
    }

    public int getProductLength() {
        return productLength;
    }

    public void setProductLength(int productLength) {
        this.productLength = productLength;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

}
