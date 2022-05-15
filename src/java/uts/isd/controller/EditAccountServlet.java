/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author User
 */
public class EditAccountServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userid"));
        DBManager manager = (DBManager) request.getSession().getAttribute("manager");
        try {
            request.setAttribute("account", manager.fetchUser(userID));
            request.getRequestDispatcher("/editAccount.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger("Edit Account Servlet").log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int userID = Integer.parseInt(request.getParameter("userid"));

        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean adminaccess = Boolean.parseBoolean(request.getParameter("adminaccess"));
        boolean deactivated = Boolean.parseBoolean(request.getParameter("deactivated"));
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        System.out.println("DEACTIVATED:" + deactivated);
        System.out.println("adminaccess:" + adminaccess);
        if (!validator.validateEmail(email)) {
            session.setAttribute("formErr", "Error: email format");
        } else if (!validator.validateName(name)) {
            session.setAttribute("formErr", "Error: name format");
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("formErr", "Error: passwd format");
        } else {
            try {
                if (userID == 0) {
                    manager.addUser(name, dob, phone, address, email, password);
                    userID = manager.findUser(email, password).getID();
                } else {
                    manager.updateUser(name, dob, phone, address, email, password, userID);
                }
                manager.updateUserStatus(userID, adminaccess, deactivated);
                //manager.addUserManagementLog(user.getID(), "User updated - name:" + name + " email: " + email + " dob: " + dob + " address: " + address + " phone: " + phone, email);
            } catch (SQLException ex) {
                Logger.getLogger("Edit Account POST").log(Level.SEVERE, null, ex);
            }
        }

        try {
            request.setAttribute("account", manager.fetchUser(userID));
            request.getRequestDispatcher("/editAccount.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger("Edit Account Servlet").log(Level.SEVERE, null, ex);
        }
    }
}
