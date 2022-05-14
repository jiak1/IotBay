/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.ShoppingCart;

/**
 *
 * @author DELL
 */
@WebServlet("/quantity-incdec")
public class QuantityController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
        response.setContentType("text/html;cahrset=UTF-8");
        try(PrintWriter out =response.getWriter()){
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<ShoppingCart> cart_list = (ArrayList<ShoppingCart>) request.getSession().getAttribute("cart-list");
            
            if (action != null && id >= 1) {
				if (action.equals("inc")) {
					for (ShoppingCart c : cart_list) {
						if (c.getId() == id) {
							int quantity = c.getCartQuantity();
							quantity++;
							c.setCartQuantity(quantity);
							response.sendRedirect("cart.jsp");
						}
					}
				}
                                if(action.equals("dec")){
                                    for(ShoppingCart c: cart_list){
                                        if(c.getId()==id&&c.getCartQuantity()>1){
                                            int quantity = c.getCartQuantity();
                                            quantity--;
                                            c.setCartQuantity(quantity);
                                            break;
                                        }
                                    }
                                    response.sendRedirect("cart.jsp");
                                }
            
        }
            else{
                response.sendRedirect("cart.jsp");
            }
    }
    

}}
