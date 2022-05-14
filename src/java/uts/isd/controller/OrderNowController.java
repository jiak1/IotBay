/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.Order;
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.OrderDao;
import uts.isd.model.dao.OrderItemDao;

/**
 *
 * @author DELL
 */
@WebServlet("/ordercart-now")
public class OrderNowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            DBConnector db =new DBConnector();
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                out.print("Product Quantity" + productQuantity);
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                Order orderModel = new Order();
                orderModel.setId(Integer.parseInt(productId));
                //orderModel.setUid(user.getID());
                orderModel.setQuantity(productQuantity);
                orderModel.setDate(formatter.format(date));
                
                OrderDao orderDao = new OrderDao(db.openConnection());
                boolean result = orderDao.insertOrder(orderModel);
                if(result){
                    response.sendRedirect("orders.jsp");
                }else{
                    out.print("order failed");
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderNowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderNowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
