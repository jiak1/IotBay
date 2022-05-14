package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author AlexK
 */
public class CancelUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        boolean isLoggedIn = (user != null);
        DBManager manager = (DBManager) session.getAttribute("manager");
        try{
            
            if(isLoggedIn){
                int userId = user.getID();
                String email = user.getEmail();
                String name = user.getName();
                manager.addUserManagementLog(userId, "DELETED: User name " + name + " Email " + email + "", "" + email);
                manager.deleteUser(email);
                session.setAttribute("name", name);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/cancelUser.jsp");//.include(request, response);
                requestDispatcher.forward(request, response);
                
                }else{
                    request.getRequestDispatcher("/confirmCancelUser.jsp").include(request, response);
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
