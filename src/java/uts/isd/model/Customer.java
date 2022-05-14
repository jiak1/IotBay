package uts.isd.model;

public class Customer extends User {

    public Customer() {
        super();
    }

    public Customer(int ID, String name, String dob, String phone, String address, String email, String password, boolean adminaccess) {
        super(ID, name, dob, phone, address, email, password, adminaccess);
    }

}
