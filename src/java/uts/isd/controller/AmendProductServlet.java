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
import uts.isd.model.dao.DBManager;
import uts.isd.model.User;
//import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author AlexK
 */
public class AmendProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        Product product = (Product) session.getAttribute("product");
        //String productID = request.getParameter("productID");
        String changes = "Changed:";
        String name = request.getParameter("name");
        if(!name.equals("")){
            changes += " prod_name to "+ name ;
        }
        String price = request.getParameter("price");
        if(!price.equals("")){
            changes += " price to "+ price;
        }
        String tax = request.getParameter("tax");
        if(!tax.equals("")){
            changes += " tax to "+ tax;
        }
        String added_dt = request.getParameter("added_dt");
        if(!added_dt.equals("")){
            changes += " added_dt to "+ added_dt;
        }
        String expiry_dt = request.getParameter("expiry_dt");
        if(!expiry_dt.equals("")){
            changes += " expiry_dt to "+ expiry_dt;
        }
        String quantity = request.getParameter("quantity");
        if(!quantity.equals("")){
            changes += " quantity to "+ quantity;
        }
        String category = request.getParameter("category");
        if(!category.equals("")){
            changes += " category to "+ category;
        }
        String location = request.getParameter("location");
        if(!location.equals("")){
            changes += " location to "+ location;
        }
        User user = (User) session.getAttribute("user");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!price.equals("") && !validator.validatePrice(price)){
            session.setAttribute("priceErr", "Error: price format");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!tax.equals("") && !validator.validatePrice(tax)){
            session.setAttribute("taxErr", "Error: tax format");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!added_dt.equals("") && !validator.validateDate(added_dt)){
            session.setAttribute("dateErr", "Error: yyyy-mm-dd needed");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!expiry_dt.equals("") && !validator.validateDate(expiry_dt)){
            session.setAttribute("dateErr", "Error: yyyy-mm-dd needed");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!quantity.equals("") && !validator.validateInt(quantity)){
            session.setAttribute("intErr", "Error: whole number needed");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!category.equals("") && !validator.validateName(category)){
            session.setAttribute("productnameErr", "Error: category needed");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!location.equals("") && !validator.validateUpperCase(location)){
            session.setAttribute("upperCaseErr", "UPPERCASE only");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        } else if (!name.equals("") && !validator.validateProductName(name)){
            session.setAttribute("productnameErr", "Invalid product name");
            request.getRequestDispatcher("amendProduct.jsp").include(request, response);
        }else {
            try {
                    //prod_db.addProduct(name, price, tax, added_dt, expiry_dt, quantity, category, location);
                    manager.updateProduct(product, name, price, tax, added_dt, expiry_dt, quantity, category, location, product.getProductID());
                    int updatedId = product.getProductID();
                    product = manager.fetchProductsByID(updatedId);
                    manager.addProductManagementLog(user.getID(), product.getProductID(), changes, "" + user.getEmail());
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("/productwasUpdated.jsp").include(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }        
    }
}

