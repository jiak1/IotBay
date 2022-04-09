package uts.isd.model;

import java.io.Serializable;

public class Staff extends Account implements Serializable {

    public String role;

    public Staff() {
        super();
    }

    public Staff(String role, String name, String dob, String phone, String address, String email, String password) {
        super(name, dob, phone, address, email, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
