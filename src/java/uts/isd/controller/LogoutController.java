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
import uts.isd.model.User;

/**
 *
 * @author AlexK
 */
public class LogoutController extends HttpServlet {

    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            DBManager manager = (DBManager) session.getAttribute("manager");
            User user = (User)session.getAttribute("user");
            session.invalidate();
            manager.addUserManagementLog(user.getID(), "User logged out", user.getEmail());
            request.getRequestDispatcher("index.jsp").include(request, response);
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Logout operation unsuccessful" : "welcome");
            } 
    }
}
