package uts.isd.model.dao;

//import uts.isd.model.Account;
//import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import uts.isd.model.User;
import uts.isd.model.Product;
/* 
* DBManager is the primary DAO class to interact with the database. /* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {
    private Statement st;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    //private Statement stProd;
    private PreparedStatement readProdSt; //related to productDB
    private PreparedStatement updateProdSt; //related to productDB
    private PreparedStatement deleteProdSt; //related to productDB
    private String readQuery =  "SELECT * FROM IOTUSER.USERDB WHERE EMAIL=? AND PASSWORD=?";
    private String updateQuery = "UPDATE IOTUSER.USERDB SET \"NAME\"=? ,PASSWORD=? ,PHONE=? WHERE USERID=?";
    private String deleteQuery = "DELETE FROM IOTUSER.USERDB WHERE EMAIL= ?";
    private String readProductByCatOrLocaleQuery = "SELECT * FROM IOTUSER.PRODUCTDB WHERE LOCATION=? AND CATEGORY=?"; //related to productDB
    private String readProductQuerySearch = "SELECT * FROM IOTUSER.PRODUCTDB WHERE \"NAME\" LIKE ?"; //related to productDB
    private String updateProduct = "UPDATE IOTUSER.PRODUCTDB SET \"NAME\"=? , PRICE=?, TAX=?, ADDED_DT=?, EXPIRY_DT=?, QUANTITY=?, CATEGORY=?, LOCATION=? WHERE PRODUCTID=? "; //related to productDB
    private String deleteProduct = "DELETE FROM IOTUSER.PRODUCTDB WHERE PRODUCTID=?"; //related to productDB
    
    public DBManager(Connection conn) throws SQLException {       
       conn.setAutoCommit(true);
       st = conn.createStatement(); 
       //stProd = conn.createStatement(); 
       readSt =  conn.prepareStatement(readQuery);
       updateSt = conn.prepareStatement(updateQuery);
       deleteSt = conn.prepareStatement(deleteQuery);
       updateProdSt = conn.prepareStatement(updateProduct);
       readProdSt = conn.prepareStatement(readProductQuerySearch);
       deleteProdSt = conn.prepareStatement(deleteProduct);
    }

    //Find user by email and password in the database   
    public User findUser(String email, String password) throws SQLException {       
        readSt.setString(1, email);
        readSt.setString(2, password);
        ResultSet rs = readSt.executeQuery();
        
        while (rs.next()) {
            String useremail = rs.getString(6);
            String userpass = rs.getString(7);
            if (email.equals(useremail) && password.equals(userpass)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String dob = rs.getString(3);
                String phone = rs.getString(4);
                String address = rs.getString(5);
                boolean adminaccess = rs.getBoolean(8);
    
                return new User(ID, name, dob, phone, address, email, password, adminaccess);
            }
        }
        return null;
    }
    
    //Check if a user exists in the database
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "Select * from IOTUSER.USERDB where EMAIL = '" + email + "' and PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String accountEmail = rs.getString(6);
            String accountPass = rs.getString(7);
            
            if(accountEmail.equals(email) && accountPass.equals(password)){
                return true;
            }
        }
        return false;
    }
    //Add a user-data into the database   
    public void addUser(String name, String dob, String phone, String address, String email, String password) throws SQLException {                   //code for add-operation       
        String columns = "INSERT INTO IOTUSER.USERDB(NAME,DOB, PHONE, ADDRESS, EMAIL, PASSWORD, ADMINACCESS)";
        String values = "VALUES('" + name + "','" + dob + "','" + phone + "','" + address + "','" + email + "','" + password + "', false)";
        st.executeUpdate(columns + values); 
    }

    //update a user details in the database   
    public void updateUser(String name, String password, String phone, int ID) throws SQLException {       
       //code for update-operation   
       //"UPDATE IOTUSER.USERDB SET \"NAME\"=? ,PASSWORD=? ,PHONE=? WHERE USERID=?";
        
        updateSt.setString(1, name);
        updateSt.setString(2, password);
        updateSt.setString(3, phone);
        updateSt.setString(4, Integer.toString(ID)); 
        
        int row = updateSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }       

    //delete a user from the database   
    public void deleteUser(String email) throws SQLException{       
       //code for delete-operation   
        deleteSt.setString(1, email);
        int row = deleteSt.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }
    
    //Fetch All: List all users
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.USERDB";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> users = new ArrayList();

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String dob = rs.getString(3);
            String phone = rs.getString(4);
            String address = rs.getString(5);
            String email = rs.getString(6);
            String password = rs.getString(7);
            boolean adminaccess = rs.getBoolean(8);
            users.add(new User(ID, name, dob, phone, address, email, password, adminaccess));
        }
        return users;
    }
    
    //below are the ProductDB related modules
    
    //Check selected product has sufficient quantity
    public boolean checkProductQty(int prodID, int qty) throws SQLException {
        String fetch = "Select * from IOTUSER.PRODUCTDB where PRODUCTID = " + prodID + " and QUANTITY >=" + qty + "";
        //ResultSet rs = stProd.executeQuery(fetch);
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int productID = Integer.parseInt( rs.getString(1));
            int quantity = Integer.parseInt(rs.getString(7));
            
            if(productID == (int)prodID && quantity >= (int)qty){
                return true;
            }
        }
        return false;
    }
    
    //Add a product into the database   
    public void addProduct(String name, double price, double tax, String added_dt, String expiry_dt, int quantity, String category, String location) throws SQLException {                   //code for add-operation       
        String columns = "INSERT INTO IOTUSER.PRODUCTDB(\"NAME\", PRICE, TAX, ADDED_DT, EXPIRY_DT, QUANTITY, CATEGORY, LOCATION)";
        String values = "VALUES('" + name + "'," + price + "," + tax + ",'" + added_dt + "','" + expiry_dt + "'," + quantity + ",'" + category + "','" + location + "')";
        //stProd.executeUpdate(columns + values); 
        st.executeUpdate(columns + values); 
    }
    
    //update a products details in the database   
    public void updateProduct(Product product, String name, String price, String tax, String added_dt, String expiry_dt, String quantity, String category, String location, int productID) throws SQLException {       
        updateProdSt.setString(1, name.equals("") ? product.getProductName() :  name );
        updateProdSt.setString(2, price.equals("") ? Double.toString(product.getProductPrice()):  price );
        updateProdSt.setString(3, tax.equals("") ? Double.toString(product.getProductTax()):  tax );
        updateProdSt.setString(4, added_dt.equals("") ? product.getProductAddedDate():  added_dt );
        updateProdSt.setString(5, expiry_dt.equals("") ? product.getProductExpiryDate():  expiry_dt );
        updateProdSt.setString(6, quantity.equals("") ? Integer.toString(product.getProductQuantity()):  quantity );
        updateProdSt.setString(7, category.equals("") ? product.getProductCategory() :  category );
        updateProdSt.setString(8, location.equals("") ? product.getProductLocation():  location );
        updateProdSt.setString(9, "" + productID); 
        
        int row = updateProdSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }       
    
    //Fetch All: List all products
    public ArrayList<Product> fetchProducts() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCTDB";
        //ResultSet rs = stProd.executeQuery(fetch);
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> products = new ArrayList();

        while (rs.next()) {
            int productID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            double price = Double.parseDouble(rs.getString(3));
            double tax = Double.parseDouble(rs.getString(4));
            String added_dt = rs.getString(5);
            String expiry_dt = rs.getString(6);
            int quantity = Integer.parseInt(rs.getString(7));
            String category = rs.getString(8);
            String location = rs.getString(9);
            products.add(new Product(productID, name, price, tax, added_dt, expiry_dt, quantity, category, location));
        }
        return products;
    }
    
    //get product by productID
    public Product fetchProductsByID(int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCTDB WHERE PRODUCTID=" + productID;
        //ResultSet rs = stProd.executeQuery(fetch);
        ResultSet rs = st.executeQuery(fetch);
        Product product;// = new Product();

        while (rs.next()) {
            if(productID == Integer.parseInt(rs.getString(1)) ) {
                String name = rs.getString(2);
                double price = Double.parseDouble(rs.getString(3));
                double tax = Double.parseDouble(rs.getString(4));
                String added_dt = rs.getString(5);
                String expiry_dt = rs.getString(6);
                int quantity = Integer.parseInt(rs.getString(7));
                String category = rs.getString(8);
                String location = rs.getString(9);
                product = new Product(productID, name, price, tax, added_dt, expiry_dt, quantity, category, location);
                return product;
            }   
        }
        return null;   
    }
    
    //get a product by Name
    public Product fetchProductsByName(String name) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCTDB WHERE \"NAME\"='" + name + "'";
        //ResultSet rs = stProd.executeQuery(fetch);
        ResultSet rs = st.executeQuery(fetch);
        Product product;// = new Product();

        while (rs.next()) {
            if(name.equals(rs.getString(2)))  {
                int productID = Integer.parseInt(rs.getString(1));
                double price = Double.parseDouble(rs.getString(3));
                double tax = Double.parseDouble(rs.getString(4));
                String added_dt = rs.getString(5);
                String expiry_dt = rs.getString(6);
                int quantity = Integer.parseInt(rs.getString(7));
                String category = rs.getString(8);
                String location = rs.getString(9);
                product = new Product(productID, name, price, tax, added_dt, expiry_dt, quantity, category, location);
                return product;
            }   
        }
        return null;   
    }
    //Fetch Products with specific category &/or location
    public ArrayList<Product> fetchProductsbyCatOrLocale(String category, String location) throws SQLException {
        String selection = "SELECT * FROM IOTUSER.PRODUCTDB ";
        String conditions = "";
        if (!category.equals("")) {
            conditions += " WHERE CATEGORY = '" + category + "' ";
        }
        if (!location.equals("")) {
            if(conditions.equals("")){
                conditions += " WHERE LOCATION = '" + location + "' ";
            } else {
                conditions += " AND LOCATION = '" + location + "' ";
            }
        }
        //ResultSet rs = stProd.executeQuery(selection + conditions);
        ResultSet rs = st.executeQuery(selection + conditions);
        ArrayList<Product> products = new ArrayList();

        while (rs.next()) {
            int productID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            double price = Double.parseDouble(rs.getString(3));
            double tax = Double.parseDouble(rs.getString(4));
            String added_dt = rs.getString(5);
            String expiry_dt = rs.getString(6);
            int quantity = Integer.parseInt(rs.getString(7));
            String cat = rs.getString(8);
            String loc = rs.getString(9);
            products.add(new Product(productID, name, price, tax, added_dt, expiry_dt, quantity, cat, loc));
        }
        return products;
    }
    
    //get a list of products by searchterm
    public ArrayList<Product> findProducts(String searchTerm) throws SQLException {
        //readProdSt.setString(1, searchTerm);
        String fetch = "SELECT * FROM IOTUSER.PRODUCTDB WHERE \"NAME\" LIKE '%" + searchTerm + "%' ";
        //ResultSet rs = stProd.executeQuery(fetch);
        
        ResultSet rs = st.executeQuery(fetch);
        //ResultSet rs = readProdSt.executeQuery();
        ArrayList<Product> products = new ArrayList();
        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            double price = Double.parseDouble(rs.getString(3));
            double tax = Double.parseDouble(rs.getString(4));
            String added_dt = rs.getString(5);
            String expiry_dt = rs.getString(6);
            int quantity = Integer.parseInt(rs.getString(7));
            String category = rs.getString(8);
            String location = rs.getString(9);
            products.add(new Product(ID, name, price, tax, added_dt, expiry_dt, quantity, category, location));
            }
        return products;
    }
    
    //get a product image
    public String fetchImageForProduct(Product product) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCTIMAGEDB WHERE CATEGORY='" + product.productCategory + "'";
        //ResultSet rs = stProd.executeQuery(fetch);
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            return rs.getString(2); 
        }
        return "IoT.png";   
    }
    
    //delete a product from the database   
    public void deleteProduct(int productID) throws SQLException{       
       //code for delete-operation   
        deleteProdSt.setString(1, Integer.toString(productID));
        int row = deleteProdSt.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }
}