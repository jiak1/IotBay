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
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String tax = request.getParameter("tax");
        String added_dt = request.getParameter("added_dt");
        String expiry_dt = request.getParameter("expiry_dt");
        String quantity = request.getParameter("quantity");
        String category = request.getParameter("category");
        String location = request.getParameter("location");
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
                    //manager.updateProduct(product, name.equals("") ? product.getProductName() : name, 
                    //                    price.equals("") ? "" + product.getProductPrice() : price,  
                    //                    tax.equals("") ? "" + product.getProductTax() : tax, 
                    //                    added_dt.equals("") ? product.getProductAddedDate() : added_dt, 
                    //                    expiry_dt.equals("") ? product.getProductExpiryDate() : expiry_dt, 
                    //                    quantity.equals("") ? "" + product.getProductQuantity() : quantity, 
                    //                    category.equals("") ? product.getProductCategory(): category, 
                    //                    location.equals("") ? product.getProductLocation() : location, 
                    //                    product.getProductID());
                    int updatedId = product.getProductID();
                    product = manager.fetchProductsByID(updatedId);
                    //product = new Product(manager.fetchProductsByName(name).getProductID(), name, Double.parseDouble(price), Double.parseDouble(tax), added_dt, expiry_dt, Integer.parseInt(quantity), category, location);
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("/productwasUpdated.jsp").include(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }
}

