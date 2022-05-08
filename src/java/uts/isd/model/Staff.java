package uts.isd.model;

import java.io.Serializable;

public class Staff extends User implements Serializable {

    public String role;

    public Staff() {
        super();
    }

    public Staff(int ID, String role, String name, String dob, String phone, String address, String email, String password) {
        super(ID, name, dob, phone, address, email, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
