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
public class DeleteProductSearch extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        //String productID = request.getParameter("productID");
        String productID = request.getParameter("productID");
        String productname = request.getParameter("productname");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!productname.equals("") && !validator.validateProductName(productname)){
            session.setAttribute("productnameErr", "Error: productname format");
            request.getRequestDispatcher("deleteProductSearch.jsp").include(request, response);
        } else if (!productID.equals("") && !validator.validateInt(productID)){
            session.setAttribute("intErr", "Error: ProductID format");
            request.getRequestDispatcher("deleteProductSearch.jsp").include(request, response);
        } else if (productname.equals("") && productID.equals("")) {
            session.setAttribute("existErr", "Error: Product doesn't exist");
            request.getRequestDispatcher("deleteProductSearch.jsp").include(request, response);
        }
        else {
            try {
                Product nameExists = manager.fetchProductsByName(productname);
                Product idExists = new Product();
                if (!productID.equals("")){
                    idExists = manager.fetchProductsByID(Integer.parseInt(productID));
                }else {
                    idExists = null;
                }
                
                if(nameExists != null ) {
                    //prod_db.addProduct(name, price, tax, added_dt, expiry_dt, quantity, category, location);
                    //manager.addProduct(name, Double.parseDouble(price), Double.parseDouble(tax), added_dt, expiry_dt, Integer.parseInt(quantity), category, location);
                    //Product product = new Product(manager.fetchProductsByName(productname));
                    Product product = nameExists;
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("/deleteProduct.jsp").include(request, response);
                } else if (idExists != null){
                    Product product = idExists;
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("/deleteProduct.jsp").include(request, response);
                }
                else{
                    session.setAttribute("existErr", "Product does not exist");
                    request.getRequestDispatcher("/deleteProductSearch.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }
}
