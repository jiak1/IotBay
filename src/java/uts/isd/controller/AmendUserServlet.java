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
import uts.isd.model.dao.DBManager;
import uts.isd.model.User;

/**
 *
 * @author AlexK
 */
public class AmendUserServlet extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        User user = (User) session.getAttribute("user");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!name.equals("") && !validator.validateName(name)){
            session.setAttribute("nameErr", "Error: name format");
            request.getRequestDispatcher("amendUser.jsp").include(request, response);
        } else if (!dob.equals("") && !validator.validateDate(dob)){
            session.setAttribute("dateErr", "Error: yyyy-mm-dd needed");
            request.getRequestDispatcher("amendUser.jsp").include(request, response);
        } else if (!email.equals("") && !validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: email needed");
            request.getRequestDispatcher("amendUser.jsp").include(request, response);
        }else if (!password.equals("") && !validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: invalid password entered");
            request.getRequestDispatcher("amendUser.jsp").include(request, response);
        } else {
            try {
                int userid = user.getID();
                if (!name.equals("")){
                    manager.addUserManagementLog(user.getID(), "User name " + user.getName() + "updated to " + name, "" + user.getEmail());
                }
                if (!password.equals("")){
                    manager.addUserManagementLog(user.getID(), "User password updated", "" + user.getEmail());
                }
                if (!dob.equals("")){
                    manager.addUserManagementLog(user.getID(), "User dob " + user.getDob()+ " updated to " + dob, "" + user.getEmail());
                }
                if (!address.equals("")){
                    manager.addUserManagementLog(user.getID(), "User address " + user.getAddress()+ " updated to " + address, "" + user.getEmail());
                }
                if (!phone.equals("")){
                    manager.addUserManagementLog(user.getID(), "User phone " + user.getPhone() + " updated to " + phone, "" + user.getEmail());
                }
                if (!email.equals("")){
                    manager.addUserManagementLog(user.getID(), "User email " + user.getEmail() + " updated to " + email, "" + user.getEmail());
                }
                manager.updateUser(name, dob, phone, address, email, password, userid);
                user = manager.fetchUser(userid);

                session.setAttribute("user", user);
                request.getRequestDispatcher("/userWasUpdated.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }        
    }
}