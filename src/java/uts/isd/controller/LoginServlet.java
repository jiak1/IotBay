/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;
import uts.isd.model.*;
/**
 *
 * @author AlexK
 */
public class LoginServlet extends HttpServlet {
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        validator.clear(session);
        
        if (!validator.validateEmail(email) ) {
            session.setAttribute("emailErr", "Error: Bad format");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Bad format");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        } else {
            try {
                user = manager.findUser(email, password);
                
                if (user != null) {
                    session.setAttribute("user", user);
                    manager.addUserManagementLog(user.getID(), "User logged in", email);
                    request.getRequestDispatcher("/main.jsp").include(request, response);
                } else {
                    //session.setAttribute("existErr", "User not in DB!");
                    session.setAttribute("emailErr", "User not in DB!");
                    request.getRequestDispatcher("/login.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Student does not exist" : "welcome");
            } 
        }
    }
}
