<%-- 
    Document   : searchUserLogs
    Created on : 15/05/2022, 11:41:19 AM
    Author     : AlexK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Search Your Logs</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
            String dateErr = (String) session.getAttribute("dateErr");
        %>
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Show All Your Activity Logs</h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="SearchUserLogServlet">
                <button type="submit" name="getlogs" value="userlogs"  class="btn btn-primary">Get user logs</button>
              </form>
                </div>   -->
            <div class="center-form text-center mt-5">  
            <h1 class="mb-3">Search Logs By Start/End Date)</h1>
            <form method="POST" action="SearchUserLogServlet">
                <div class="mb-3">
                  <label for="startdate" class="form-label">Start date</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "Enter start date")%>" name="startdate" >
                </div>
                <div class="mb-3">
                  <label for="enddate" class="form-label">End date</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "Enter end date")%>" name="enddate" >
                </div>
                <button type="submit" class="btn btn-primary">Search Logs</button>
              </form>
        </div> -->
    </body>
</html>