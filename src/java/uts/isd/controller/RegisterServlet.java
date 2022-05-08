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
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author AlexK
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: email format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: name format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: passwd format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                User exist = manager.findUser(email, password);
                if(exist != null) {
                    session.setAttribute("existErr", "User exists already");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }else{
                    manager.addUser(name, dob, phone, address, email, password);
                    User user = new User(manager.findUser(email, password).getID(), name, dob, phone, address, email, password);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            }catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
}
