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
@WebServlet("/remove-fromcart")
public class RemoveItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String cartId = request.getParameter("id");
            if(cartId!=null){
                ArrayList<ShoppingCart> cart_list = (ArrayList<ShoppingCart>) request.getSession().getAttribute("cart-list");
                if(cart_list!=null){
                    for(ShoppingCart c:cart_list){
                        if(c.getId()==Integer.parseInt(cartId)){
                            cart_list.remove(cart_list.indexOf(c));
                            break;
                            
                        }
                    }
                }
                response.sendRedirect("cart.jsp");
            }
            else{
                response.sendRedirect("cart.jsp");
            }
        }
        
    }

}

