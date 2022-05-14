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
//import sun.text.normalizer.UBiDiProps;
import uts.isd.model.Product;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
//import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author AlexK
 */
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        User user = (User) session.getAttribute("user");
        Product product = (Product) session.getAttribute("product");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        

        try {
                //prod_db.addProduct(name, price, tax, added_dt, expiry_dt, quantity, category, location);
                int updatedId = product.getProductID();
                manager.deleteProduct(updatedId);
                manager.addProductManagementLog(user.getID(), product.getProductID(), "ProductID " + updatedId +" deleted", "" + user.getEmail());
                session.setAttribute("productid", ""+ updatedId);
                request.getRequestDispatcher("/productwasDeleted.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
