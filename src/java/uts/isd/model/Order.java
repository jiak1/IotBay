package uts.isd.model;

import java.io.Serializable;

public class Order implements Serializable {

    public String status;

    public Order() {
    }

    public Order(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
