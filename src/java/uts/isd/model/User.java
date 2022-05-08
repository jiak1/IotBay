package uts.isd.model;

import java.io.Serializable;

public class Account implements Serializable {

    public String name;
    public String dob;
    public String phone;
    public String address;
    public String email;
    public String password;

    public Account() {
    }

    public Account(String name, String dob, String phone, String address, String email, String password) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
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
