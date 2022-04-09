package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {

    public double amount;
    public double paid;
    public Date createdTS;
    public Date paidTS;
    public String status;

    public Invoice() {
    }

    public Invoice(double amount, double paid, Date createdTS, Date paidTS, String status) {
        this.amount = amount;
        this.paid = paid;
        this.createdTS = createdTS;
        this.paidTS = paidTS;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public Date getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(Date createdTS) {
        this.createdTS = createdTS;
    }

    public Date getPaidTS() {
        return paidTS;
    }

    public void setPaidTS(Date paidTS) {
        this.paidTS = paidTS;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
