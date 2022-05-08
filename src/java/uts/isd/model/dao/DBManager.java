package uts.isd.model.dao;

//import uts.isd.model.Account;
//import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.User;
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
    private String readQuery =  "SELECT * FROM IOTUSER.USERDB WHERE EMAIL=? AND PASSWORD=?";
    private String updateQuery = "UPDATE IOTUSER.USERDB SET \"NAME\"=? ,PASSWORD=? ,PHONE=? WHERE USERID=?";
    private String deleteQuery = "DELETE FROM IOTUSER.USERDB WHERE EMAIL= ?";
    
    public DBManager(Connection conn) throws SQLException {       
       conn.setAutoCommit(true);
       st = conn.createStatement(); 
       readSt =  conn.prepareStatement(readQuery);
       updateSt = conn.prepareStatement(updateQuery);
       deleteSt = conn.prepareStatement(deleteQuery);
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
                return new User(ID, name, dob, phone, address, email, password);
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
        String columns = "INSERT INTO IOTUSER.USERDB(NAME,DOB, PHONE, ADDRESS, EMAIL, PASSWORD)";
        String values = "VALUES('" + name + "','" + dob + "','" + phone + "','" + address + "','" + email + "','" + password + "')";
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
            users.add(new User(ID, name, dob, phone, address, email, password));
        }
        return users;
    }
}
