package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.*;
import uts.isd.model.User;

public class TestDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    
    private DBManager db;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestDB().runQueries();
    }
    
    public TestDB() {
        try{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.print("(User) Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;
        
        while((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unknown Command");           
            }
        }
    }
    
    private void testAdd() {
        System.out.print("User name:");
        String name = in.nextLine();
        System.out.print("User dob ('yyyy-mm-dd'):");
        String dob = in.nextLine();
        System.out.print("User phone:");
        String phone = in.nextLine();
        System.out.print("User address:");
        String address = in.nextLine();
        System.out.print("User email:");
        String email = in.nextLine();
        System.out.print("User password:");
        String password = in.nextLine();
        try {
            db.addUser(name, dob, phone, address, email, password);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("User is added to the database");
    }
    
    private void testRead() throws SQLException {
        System.out.print("Account email: ");
        String email = in.nextLine();
        System.out.print("Account password: ");
        String password = in.nextLine();
        User account = db.findUser(email, password);
        if (account != null) {
            System.out.println("Account " + account.getName() + " exists in the database.");
        } else {
            System.out.println("Account does not exist");
        }
    }
    
    private void testUpdate() {
        System.out.print("Account email: ");
        String email = in.nextLine();
        System.out.print("Account password: ");
        String password = in.nextLine();
        
        
        try{
            if (db.checkUser(email, password)) {
                User user = db.findUser(email, password);
                System.out.println("Updating "+ user.getName()+" account details");
                
                System.out.print("Person (user's) name: ");
                String name = in.nextLine();
                System.out.print("DOB: ");
                String dob = in.nextLine();
                System.out.print("Phone: ");
                String phone = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();
                System.out.print("Email: ");
                String newemail = in.nextLine();
                System.out.print("Password: ");
                String newpassword = in.nextLine();
                db.updateUser(name, dob, phone, address, newemail, newpassword, user.getID());
            } else {
                System.out.println("Account does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
        
    public void testDelete() {
        System.out.print("Account email: ");
        String email = in.nextLine();
        System.out.print("Account password: ");
        String password = in.nextLine();
        
        try {
            if (db.checkUser(email, password)) {
                db.deleteUser(email);
            } else {
                System.out.println("Account does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showAll() {
        try {
            ArrayList<User> users = db.fetchUsers();
            System.out.println("Account TABLE: ");
            for (User user : users) {
                System.out.printf("%-15s %-25s %-35s %-35s %-15s %-15s \n",user.getID(), user.getName(),user.getEmail(),user.getAddress(),user.getPhone(), user.getPassword() );
            }
            System.out.println();
        } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
