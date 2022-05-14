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
//import uts.isd.model.dao.ProductDBManager;


/**
 *
 * @author AlexK
 */
public class SearchtermProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        //String productID = request.getParameter("productID");
        String searchterm = request.getParameter("searchterm");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!validator.validateProductSearch(searchterm)){
            session.setAttribute("productsearchErr", "Error: searchterm format");
            request.getRequestDispatcher("searchProducts.jsp").include(request, response);
        } 
        else {
            try {
                    List<Product> products;
                    products = manager.findProducts(searchterm);
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
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
}