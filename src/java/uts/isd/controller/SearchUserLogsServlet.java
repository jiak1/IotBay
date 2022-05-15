/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import sun.text.normalizer.UBiDiProps;
import uts.isd.model.Product;
import uts.isd.model.User;
import uts.isd.model.Log;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author AlexK
 */
public class SearchUserLogsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        User user = (User) session.getAttribute("user");
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        validator.clear(session);
        
        try{
            if(startdate==null && enddate == null){ //no inputs to validate, just get all logs
                ArrayList<Log> userlogs = manager.getUserLogs(user.getID());
                session.setAttribute("userlogs", userlogs);
                request.getRequestDispatcher("showUserLogs.jsp").include(request, response);
            } else if (startdate.equals("") && enddate.equals("") ){//no inputs, send all logs
                ArrayList<Log> userlogs = manager.getUserLogs(user.getID());
                session.setAttribute("userlogs", userlogs);
                request.getRequestDispatcher("showUserLogs.jsp").include(request, response);
            } else if(!startdate.equals("") && !validator.validateDate(startdate)){
                session.setAttribute("dateErr", "Error: invalid date format");
                request.getRequestDispatcher("searchUserLogs.jsp").include(request, response);
            } else if(!enddate.equals("") && !validator.validateDate(enddate)){
                session.setAttribute("dateErr", "Error: invalid date format");
                request.getRequestDispatcher("searchUserLogs.jsp").include(request, response);
            } 
            else {
                try {
                    ArrayList<Log> userlogs = manager.getUserLogsByDate(user.getID(), startdate, enddate);
                    session.setAttribute("userlogs", userlogs);
                    request.getRequestDispatcher("/showUserLogs.jsp").include(request, response);
                    }
                catch (SQLException ex) {
                    Logger.getLogger(SearchUserLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }catch (Exception ex){
            Logger.getLogger(SearchUserLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
