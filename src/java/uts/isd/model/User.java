package uts.isd.model;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {

    private String name;
    private String dob;
    private String phone;
    private String address;
    private String email;
    private String password;
    private int ID;
    
    public User() {
    }

    public User(int ID, String name, String dob, String phone, String address, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public int getID() {
        return ID;
    }
        
    public void setID(int ID) {
        this.ID = ID;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
