package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AlexK
 */
public class Product implements Serializable{

    
    public int productID;
    public String productName;
    public double productPrice;
    public double productTax;
    public String productAddedDate;
    public String productExpiryDate;
    public int productQuantity;
    public String productCategory;
    public String productLocation;
    
    //public int discount;
    //public int weight;
    //public int productHeight;
    //public int productWidth;
    //public int productLength;
    
    
    public Product() {
    }

    public Product(Integer productID, String productName, double productPrice, double productTax, String productAddedDate, String productExpiryDate, int productQuantity, String productCategory, String productLocation) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTax = productTax;
        this.productAddedDate = productAddedDate;
        this.productExpiryDate = productExpiryDate;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
        this.productLocation = productLocation;
    }

    public int getProductID() {
        return productID;
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
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

    public double getProductTax() {
        return productTax;
    }

    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }
    //public int getDiscount() {
    //   return discount;
    //}

    //public void setDiscount(int discount) {
    //    this.discount = discount;
    //}

    public String getProductAddedDate() {
        return productAddedDate;
    }

    public void setProductAddedDate(String productAddedDate) {
        this.productAddedDate = productAddedDate;
    }

    //public int getWeight() {
    //    return weight;
    //}

    //public void setWeight(int weight) {
    //    this.weight = weight;
    //}

    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    //public int getProductHeight() {
    //    return productHeight;
    //}

    //public void setProductHeight(int productHeight) {
    //    this.productHeight = productHeight;
    //}

    //public int getProductWidth() {
    //    return productWidth;
    //}

    //public void setProductWidth(int productWidth) {
    //    this.productWidth = productWidth;
    //}

    //public int getProductLength() {
    //    return productLength;
    //}

    //public void setProductLength(int productLength) {
    //    this.productLength = productLength;
    //}

    public int getProductQuantity() {
        return productQuantity;    
    }
    
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    
    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }
}
