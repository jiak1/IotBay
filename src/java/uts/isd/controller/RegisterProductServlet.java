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
public class RegisterProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
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
        
        if(!validator.validatePrice(price)){
            session.setAttribute("priceErr", "Error: price format");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else if (!validator.validatePrice(tax)){
            session.setAttribute("taxErr", "Error: tax format");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else if (!validator.validateDate(added_dt)){
            session.setAttribute("dateErr", "Error: yyyy-mm-dd needed");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else if (!validator.validateDate(expiry_dt)){
            session.setAttribute("dateErr", "Error: yyyy-mm-dd needed");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else if (!validator.validateInt(quantity)){
            session.setAttribute("intErr", "Error: whole number needed");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else if (!validator.validateName(category)){
            session.setAttribute("productnameErr", "Error: category needed");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else if (!validator.validateUpperCase(location)){
            session.setAttribute("upperCaseErr", "UPPERCASE only");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else {
            try {
                Product exist = manager.fetchProductsByName(name);
                
                if(exist != null) {
                    session.setAttribute("existErr", "Product exists already");
                    request.getRequestDispatcher("registerProduct.jsp").include(request, response);
                }else{
                    //prod_db.addProduct(name, price, tax, added_dt, expiry_dt, quantity, category, location);
                    manager.addProduct(name, Double.parseDouble(price), Double.parseDouble(tax), added_dt, expiry_dt, Integer.parseInt(quantity), category, location);
                    Product product = new Product(manager.fetchProductsByName(name).getProductID(), name, Double.parseDouble(price), Double.parseDouble(tax), added_dt, expiry_dt, Integer.parseInt(quantity), category, location);
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("/productAdded.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }
}
