package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

    public int logID;
    public int userID;
    public int productID;
    public String details;
    public String email;
    public Date logDate;

    public Log() {
    }

    public Log(int userID, String details, String email, Date logDate) {
        this.userID = userID;
        this.details = details;
        this.email = email;
        this.logDate = logDate;
    }
    
    public Log(int userID, int productID, String details, String email, Date logDate) {
        this.userID = userID;
        this.productID = productID;
        this.details = details;
        this.email = email;
        this.logDate = logDate;
    }

    public Log(int logID, int userID, int productID, String details, String email, Date logDate) {
        this.logID = logID;
        this.userID = userID;
        this.productID = productID;
        this.details = details;
        this.email = email;
        this.logDate = logDate;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}
