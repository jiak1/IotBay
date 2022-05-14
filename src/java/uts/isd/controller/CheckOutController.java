/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.Order;
import uts.isd.model.ShoppingCart;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.OrderDao;

/**
 *
 * @author DELL
 */
@WebServlet("/check-outcart")
public class CheckOutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {
            //out.println("check out ");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            DBConnector db = new DBConnector();

            ArrayList<ShoppingCart> cart_list = (ArrayList<ShoppingCart>) request.getSession().getAttribute("cart-list");
            if (cart_list != null) {
                for (ShoppingCart c : cart_list) {
                    Order order = new Order();
                    order.setId(c.getId());
                    order.setQuantity(c.getCartQuantity());
                    order.setDate(formatter.format(date));
                    order.setStatus("AWAITING PAYMENT");
                    OrderDao oDao = new OrderDao(db.openConnection());
                    boolean result = oDao.insertOrder(order);
                    if (!result) {
                        break;
                    }

                }
                cart_list.clear();
                response.sendRedirect("orders.jsp");
            } else {
                out.print("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
