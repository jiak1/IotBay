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
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Jack
 */
public class AccountsServlet extends HttpServlet {

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
        DBManager manager = (DBManager) request.getSession().getAttribute("manager");
        try {
            request.setAttribute("accounts", manager.fetchUsers());

        } catch (SQLException ex) {
            Logger.getLogger("Accounts Servlet").log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/accounts.jsp").include(request, response);
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
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        DBManager manager = (DBManager) request.getSession().getAttribute("manager");
        try {
            request.setAttribute("accounts", manager.searchUsers(name, phone));

        } catch (SQLException ex) {
            Logger.getLogger("Accounts Servlet").log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/accounts.jsp").include(request, response);
    }

}
