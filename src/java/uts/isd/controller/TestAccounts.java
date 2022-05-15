package uts.isd.controller;

import java.sql.*;
import java.util.logging.*;
import uts.isd.model.User;
import uts.isd.model.dao.*;

public class TestAccounts {

    private DBConnector connector;
    private Connection conn;

    private DBManager db;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestAccounts().runQueries();
    }

    public TestAccounts() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void runQueries() throws SQLException {
        testAccounts();
        testUpdateUser();
        testAddUser();
        testDeleteUser();
    }

    private void testAccounts() {
        try {
            db.fetchUsers();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Retrieved Accounts");
    }

    private void testUpdateUser() {
        try {
            db.updateUser("Harry Styles", "2022-01-01", "04111111", "13 Smith Street", "harry@test.com", "pass123", 100000);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Updated User");
    }

    private void testAddUser() {
        try {
            db.addUser("New User", "2022-01-01", "04111111", "13 Smith Street", "new@test.com", "pass123");
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Added New User");
    }

    private void testDeleteUser() {
        try {
            User user = db.findUser("new@test.com", "pass123");
            db.deleteUser(user.getID());
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Deleted New User");
    }
}
