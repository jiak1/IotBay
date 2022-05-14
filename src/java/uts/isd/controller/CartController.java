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
import javax.servlet.http.HttpSession;
import uts.isd.model.OrderLineItem;
import uts.isd.model.ShoppingCart;

/**
 *
 * @author DELL
 */
@WebServlet("/add-tocart")
public class CartController extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            ArrayList<ShoppingCart> cartList = new ArrayList();//object arraylist
            int id = Integer.parseInt(request.getParameter("id"));
            ShoppingCart cart = new ShoppingCart();
            cart.setId(id);
            cart.setCartQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<ShoppingCart> cart_list = (ArrayList<ShoppingCart>) session.getAttribute("cart-list");
            
            if(cart_list==null){
                cartList.add(cart);
                session.setAttribute("cart-list",cartList);
                response.sendRedirect("shop.jsp");

            }
            else{
                cartList = cart_list;
                boolean exist = false;
                
                for(ShoppingCart c:cartList){
                    if(c.getId()==id){
                        exist =true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
                    }
                }
                if (!exist) {
                    cartList.add(cart);
                    response.sendRedirect("shop.jsp");
                }
            }
                    
            
        }
    }
}
