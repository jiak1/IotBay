/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.OrderLineItem;
import uts.isd.model.ShoppingCart;

/**
 *
 * @author DELL
 */
public class OrderItemDao {
    private Connection conn;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public OrderItemDao(Connection conn){
        this.conn=conn;
    }
    
    public List<OrderLineItem> getAllOrders() throws SQLException{
        List<OrderLineItem> products = new ArrayList<OrderLineItem>();
        try{
            query = "select * from orderlineitemdb";
            pst = this.conn.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                OrderLineItem row = new OrderLineItem();
                row.setId(rs.getInt("orderid"));
                row.setCost(rs.getDouble("cost"));
                row.setName(rs.getString("name"));
                row.setQuantity(rs.getInt("qty"));
                row.setStorageLocation(rs.getString("location"));                
                products.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();    
        }
        return products;
        
    }
    
    public List<ShoppingCart> getCartItems(ArrayList<ShoppingCart>cartList){
        List<ShoppingCart> items = new ArrayList<ShoppingCart>();
        try{
            if(cartList.size()>0){
                for(ShoppingCart item:cartList){
                    query = "select * from orderlineitemdb where orderid =?";
                    pst= this.conn.prepareStatement(query);
                    pst.setInt(1,item.getId());
                    rs = pst.executeQuery();
                    while(rs.next()){
                        ShoppingCart row = new ShoppingCart();
                        row.setId(rs.getInt("orderid"));
                        row.setQuantity(rs.getInt("qty"));
                        row.setName(rs.getString("name"));
                        row.setStorageLocation(rs.getString("location"));
                        row.setCost(rs.getDouble("cost")*item.getCartQuantity());
                        row.setQuantity(item.getCartQuantity());
                        items.add(row);
                    }
                    
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        return items;
    }
    
    public double getTotalCartPrice(ArrayList<ShoppingCart>cartList){
        double sum=0;
        try{
            if(cartList.size()>0){
                for(ShoppingCart item:cartList){
                    query = "select cost from orderlineitemdb where orderid=?";
                    pst = this.conn.prepareStatement(query);
                    pst.setInt(1,item.getId());
                    rs = pst.executeQuery();
                    while(rs.next()){
                        sum += rs.getDouble("cost")*item.getCartQuantity();
                    }
                    
                }
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return sum;
    }
    
    public OrderLineItem getSingleProduct(int id) {
		 OrderLineItem row = null;
	        try {
	            query = "SELECT * FROM IOTUSER.ORDERLINEITEMDB WHERE ORDERID=? ";

	            pst = this.conn.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new OrderLineItem();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setStorageLocation(rs.getString("location"));
	                row.setCost(rs.getDouble("cost"));
                        row.setQuantity(rs.getInt("qty"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
    
}
