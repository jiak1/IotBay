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
import uts.isd.model.Order;
import uts.isd.model.OrderLineItem;

/**
 *
 * @author DELL
 */
public class OrderDao {

    private Connection conn;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean insertOrder(Order model) {
        boolean result = false;
        try {
            query = "INSERT INTO IOTUSER.ORDERDB (USERID,O_QUANTITY,O_DATE) VALUES(?,?,?)";
            pst = this.conn.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getQuantity());
            pst.setString(3, model.getDate());
            pst.executeUpdate();
            result = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Order> userOrders() {
        List<Order> list = new ArrayList<>();
        try {
            query = "SELECT *FROM IOTUSER.ORDERDB WHERE ORDERID =? ";
            pst = this.conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                OrderItemDao oDao = new OrderItemDao(this.conn);
                int uId = rs.getInt("ORDERID");

                OrderLineItem pd = oDao.getSingleProduct(uId);
                order.setId(pd.getId());
                order.setName(pd.getName());
                order.setStorageLocation(pd.getStorageLocation());
                order.setCost(pd.getCost() * rs.getInt("O_QUANTITY"));
                order.setQuantity(pd.getQuantity());
                order.setDate(rs.getString("O_DATE"));
                order.setStatus(rs.getString("STATUS"));
                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;

    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> products = new ArrayList<Order>();
        try {
            query = "select * from ORDERDB ORDER BY O_DATE DESC";
            pst = this.conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setStatus(rs.getString("STATUS"));
                order.setDate(rs.getString("O_DATE"));
                order.setQuantity(rs.getInt("O_QUANTITY"));
                products.add(order);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;

    }

}
