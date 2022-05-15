/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.OrderDao;

/**
 *
 * @author DELL
 */
public class CancelOrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
                    String id = request.getParameter("id");
                    if(id!=null){
                        DBConnector db = new DBConnector();
                        OrderDao odao = new OrderDao(db.openConnection());
                        odao.cancelOrder(Integer.parseInt(id));
                    }
                    response.sendRedirect("orders.jsp");
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(CancelOrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CancelOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

}}
