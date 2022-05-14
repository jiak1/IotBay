package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.*;
import uts.isd.model.Product;

public class TestProductDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn2;
    private ProductDBManager prod_db;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestProductDB().runProdQueries();
    }
    
    public TestProductDB() {
        try{
            connector = new DBConnector();
            conn2 = connector.openConnection();
            prod_db = new ProductDBManager(conn2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readProdChoice() {
        System.out.print("(Product) Operation CRUDS or * to exit: \n");
        return in.nextLine().charAt(0);
    }

    private char readProdReadChoice() {
        System.out.print("(Product) Read by S, C or P or * to exit: \n");
        System.out.print("S (searchword) C (category/location) P (ProductID)\n");
        return in.nextLine().charAt(0);
    }
    private void runProdQueries() throws SQLException {
        char c;
        
        while((c = readProdChoice()) != '*') {
            switch (c) {
                case 'C':
                    testProdAdd();
                    break;
                case 'R':
                    //System.out.print("(Product) Read by S, C or P or * to exit: \n");
                    //System.out.print("S (searchword) C (category/location) P (ProductID)\n");
                    while((c = readProdReadChoice()) != '*') {
                        switch (c) {
                            case 'S':
                                testReadProduct();
                                break;
                            case 'C':
                                testReadProductByCatorLocale();
                                break;
                            case 'P':
                                testSearchProductID();
                                break;
                            default:
                                System.out.println("Unknown Command");           
                        }
                    }
                    break;
                case 'U':
                    testProdUpdate();
                    break;
                case 'D':
                    testProductDelete();
                    break;
                case 'S':
                    showAllProducts();
                    break;
                default:
                    System.out.println("Unknown Command");           
            }
        }
    }
    
    private void testProdAdd() {
        System.out.print("Product name:");
        String name = in.nextLine();
        System.out.print("Product price (n.nn):");
        Double price = Double.parseDouble(in.nextLine());
        System.out.print("Product tax:");
        Double tax = Double.parseDouble(in.nextLine());
        System.out.print("Added date (yyyy-mm-dd):");
        System.out.print("Added date ('yyyy-mm-dd'):");
        String added_dt = in.nextLine();
        System.out.print("Expiry date ('yyyy-mm-dd'):");
        String expiry_dt = in.nextLine();
        System.out.print("Product quantity (stock):");
        int quantity = Integer.parseInt(in.nextLine());
        System.out.print("Product category (Wearable tech, Smart TV, Voice control device, Printer, Camera, Lights, Thermostat, E-reader):");
        String category = in.nextLine();
        System.out.print("Product location (Sydney, Melboure, Brisbane, Adelaide, Perth):");
        String location = in.nextLine();
        try {
            prod_db.addProduct(name, price, tax, added_dt, expiry_dt, quantity, category, location);
        } catch (SQLException ex) {
            Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Product is added to the database");
    }
    
    private void testSearchProductID() throws SQLException {
        System.out.print("ProductID to search: ");
        int productID = Integer.parseInt(in.nextLine());
        try {
            Product product = prod_db.fetchProductsByID(productID);
            System.out.printf("%-15s %-45s %-15s %-15s %-20s %-20s %-15s %-35s %-20s \n", product.getProductID(), product.getProductName(),product.getProductPrice(),product.getProductTax(),product.getProductAddedDate(), product.getProductExpiryDate(), product.getProductQuantity(), product.getProductCategory(), product.getProductLocation());
            System.out.println();
        }
        
        catch (SQLException ex) {
        Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    private void testReadProduct() throws SQLException {
        System.out.print("Product Description search term: ");
        String prodSearch = in.nextLine();
        //ArrayList<Product> products = new ArrayList();
        try {
        ArrayList<Product> products = prod_db.findProducts(prodSearch);
            for (Product product : products) {
                System.out.printf("%-15s %-45s %-15s %-15s %-20s %-20s %-15s %-35s %-20s \n", product.getProductID(), product.getProductName(),product.getProductPrice(),product.getProductTax(),product.getProductAddedDate(), product.getProductExpiryDate(), product.getProductQuantity(), product.getProductCategory(), product.getProductLocation());
            }
            System.out.println();
        } catch (SQLException ex) {
        Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testReadProductByCatorLocale() throws SQLException {
        System.out.print("Category (Wearable tech, Gaming Console, Smart TV, Voice control device, Printer, Camera, Lights, Thermostat, E-reader): ");
        String category = in.nextLine();
        
        System.out.print("Location (SYDNEY, MELBOURNE, BRISBANE, PERTH, ADELAIDE): ");
        String location = in.nextLine();
        //ArrayList<Product> products = new ArrayList();
        try {
        ArrayList<Product> products = prod_db.fetchProductsbyCatOrLocale(category, location);
            for (Product product : products) {
                System.out.printf("%-15s %-45s %-15s %-15s %-20s %-20s %-15s %-35s %-20s \n", product.getProductID(), product.getProductName(),product.getProductPrice(),product.getProductTax(),product.getProductAddedDate(), product.getProductExpiryDate(), product.getProductQuantity(), product.getProductCategory(), product.getProductLocation());
            }
            System.out.println();
        } catch (SQLException ex) {
        Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testProdUpdate() {
        System.out.print("Product ID (like 2000##):");
        try {
            int productID = Integer.parseInt(in.nextLine());
            Product product = prod_db.fetchProductsByID(productID);
            if(product!=null){
                System.out.print("Product name (" + product.getProductName() + "):");
                String name = in.nextLine();
                System.out.print("Product price (n.nn) (" + String.valueOf(product.getProductPrice()) + "):");
                String price = in.nextLine();
                System.out.print("Product tax:(" + String.valueOf(product.getProductTax()) + "):");
                String tax = in.nextLine();
                System.out.print("Added date (yyyy-mm-dd):(" + String.valueOf(product.getProductAddedDate()) + "):");
                String added_dt = in.nextLine();
                System.out.print("Expiry date ('yyyy-mm-dd'):(" + product.getProductExpiryDate()+ "):");
                String expiry_dt = in.nextLine();
                System.out.print("Product quantity (stock):(" + String.valueOf(product.getProductQuantity()) + "):");
                String quantity = in.nextLine();
                System.out.print("Product category (Wearable tech, Smart TV, Voice control device, Printer, Camera, Lights, Thermostat, E-reader)(" + product.getProductCategory()+ "):");
                String category = in.nextLine();
                System.out.print("Product location (Sydney, Melboure, Brisbane, Adelaide, Perth)(" + product.getProductLocation()+ "):");
                String location = in.nextLine();
                prod_db.updateProduct(product, name, price, tax, added_dt, expiry_dt, quantity, category, location, productID);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showAllProducts() {
        try {
            ArrayList<Product> products = prod_db.fetchProducts();
            System.out.println("Product TABLE: ");
            System.out.printf("%-15s %-45s %-15s %-15s %-20s %-20s %-15s %-35s %-20s \n", "PRODUCTID", "PRODUCT NAME","PRICE","TAX/GST","ADDED DATE", "EXPIRY DATE", "QTY", "CATEGORY", "LOCATION");
            for (Product product : products) {
                System.out.printf("%-15s %-45s %-15s %-15s %-20s %-20s %-15s %-35s %-20s \n", product.getProductID(), product.getProductName(),product.getProductPrice(),product.getProductTax(),product.getProductAddedDate(), product.getProductExpiryDate(), product.getProductQuantity(), product.getProductCategory(), product.getProductLocation());
            }
            System.out.println();
        } catch (SQLException ex) {
        Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testProductDelete() {
        try {
            System.out.print("Product ID (like 2000##):");
            int productID = Integer.parseInt(in.nextLine());
            Product product = prod_db.fetchProductsByID(productID);
            if(product!=null){
                prod_db.deleteProduct(productID);
                System.out.print("Product ID " + productID + " deleted successfully.");
            } else {
                System.out.print("Product ID " + productID + " not found in list! Deletion unsuccessful.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}