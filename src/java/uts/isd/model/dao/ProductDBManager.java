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

/**
 *
 * @author AlexK
 */

public class ProductDBManager {
    private Statement stProd;
    private PreparedStatement readProdSt;
    private PreparedStatement updateProdSt;
    private PreparedStatement deleteProdSt;
    private String readProductByCatOrLocaleQuery = "SELECT * FROM IOTUSER.PRODUCTDB WHERE LOCATION=? AND CATEGORY=?";
    //private String readProductByCategoryQuery = "SELECT * FROM IOTUSER.PRODUCTDB WHERE CATEGORY=? ";
    private String readProductQuerySearch = "SELECT * FROM IOTUSER.PRODUCTDB WHERE \"NAME\" LIKE ?";
    private String updateProduct = "UPDATE IOTUSER.PRODUCTDB SET \"NAME\"=? , PRICE=?, TAX=?, ADDED_DT=?, EXPIRY_DT=?, QUANTITY=?, CATEGORY=?, LOCATION=? WHERE PRODUCTID=? ";
    private String deleteProduct = "DELETE FROM IOTUSER.PRODUCTDB WHERE PRODUCTID=?";
    
    public ProductDBManager(Connection conn2) throws SQLException {       
       conn2.setAutoCommit(true);
       stProd = conn2.createStatement(); 
       readProdSt =  conn2.prepareStatement(readProductQuerySearch);
       updateProdSt = conn2.prepareStatement(updateProduct);
       deleteProdSt = conn2.prepareStatement(deleteProduct);
    }
        
    //Check selected product has sufficient quantity
    public boolean checkProductQty(int prodID, int qty) throws SQLException {
        String fetch = "Select * from IOTUSER.PRODUCTDB where PRODUCTID = " + prodID + " and QUANTITY >=" + qty + "";
        ResultSet rs = stProd.executeQuery(fetch);
        
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
        stProd.executeUpdate(columns + values); 
    }

    //update a products details in the database   
    public void updateProduct(Product product, String name, String price, String tax, String added_dt, String expiry_dt, String quantity, String category, String location, int productID) throws SQLException {       
       //code for update-operation   
       //"UPDATE IOTUSER.USERDB SET \"NAME\"=? ,PASSWORD=? ,PHONE=? WHERE USERID=?";
                
        updateProdSt.setString(1, name.equals("") ? product.getProductName() :  name );
        updateProdSt.setString(2, price.equals("") ? Double.toString(product.getProductPrice()):  price );
        updateProdSt.setString(3, tax.equals("") ? Double.toString(product.getProductTax()):  tax );
        updateProdSt.setString(4, added_dt.equals("") ? product.getProductAddedDate():  added_dt );
        updateProdSt.setString(5, expiry_dt.equals("") ? product.getProductExpiryDate():  expiry_dt );
        updateProdSt.setString(6, quantity.equals("") ? Integer.toString(product.getProductQuantity()):  quantity );
        updateProdSt.setString(7, category.equals("") ? product.getProductCategory() :  category );
        updateProdSt.setString(8, location.equals("") ? product.getProductLocation():  location );
        updateProdSt.setString(9, Integer.toString(productID)); 
        
        int row = updateProdSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }       
    //Fetch All: List all products
    public ArrayList<Product> fetchProducts() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCTDB";
        ResultSet rs = stProd.executeQuery(fetch);
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
        ResultSet rs = stProd.executeQuery(fetch);
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
        ResultSet rs = stProd.executeQuery(fetch);
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
        ResultSet rs = stProd.executeQuery(selection + conditions);
        ArrayList<Product> products = new ArrayList();

        while (rs.next()) {
            int productID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            double price = Double.parseDouble(rs.getString(3));
            double tax = Double.parseDouble(rs.getString(4));
            String added_dt = rs.getString(5);
            String expiry_dt = rs.getString(6);
            int quantity = Integer.parseInt(rs.getString(7));
            //String category = rs.getString(8);
            //String location = rs.getString(9);
            products.add(new Product(productID, name, price, tax, added_dt, expiry_dt, quantity, category, location));
        }
        return products;
    }
    
    //get a list of products by searchterm
    public ArrayList<Product> findProducts(String searchTerm) throws SQLException {
        //readProdSt.setString(1, searchTerm);
        String fetch = "SELECT * FROM IOTUSER.PRODUCTDB WHERE \"NAME\" LIKE '%" + searchTerm + "%' ";
        ResultSet rs = stProd.executeQuery(fetch);
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
    
    //delete a product from the database   
    public void deleteProduct(int productID) throws SQLException{       
       //code for delete-operation   
        deleteProdSt.setString(1, Integer.toString(productID));
        int row = deleteProdSt.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }
}