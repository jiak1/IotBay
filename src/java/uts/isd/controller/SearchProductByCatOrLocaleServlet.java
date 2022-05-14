/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author AlexK
 */
public class SearchProductByCatOrLocaleServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String location = request.getParameter("location");
        String category = request.getParameter("category");
        
        //DBManager manager = (DBManager) session.getAttribute("manager");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!category.equals("") && !validator.validateProductSearch(category)){
            session.setAttribute("productsearchErr", "Error: searchterm format");
            request.getRequestDispatcher("searchProducts.jsp").include(request, response);
        } else if(!location.equals("") && !validator.validateProductSearch(location)){
            session.setAttribute("productsearchErr", "Error: searchterm format");
            request.getRequestDispatcher("searchProducts.jsp").include(request, response);
        }
        else {
            try {
                    ArrayList<Product> products = new ArrayList();
                    products = manager.fetchProductsbyCatOrLocale(category, location);
            //for (Product product : products) {
                    //ArrayList<String> images = new ArrayList<String>();
                    //for (Product product : products) {
                    //    images.add("" + manager.fetchImageForProduct(product));
                    //}
                    session.setAttribute("products", products);
                    //session.setAttribute("images", images);
                    request.getRequestDispatcher("productSearchResults.jsp").include(request, response);
            } 
            catch (SQLException ex) {
                Logger.getLogger(SearchProductByCatOrLocaleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
}
