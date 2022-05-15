<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Delete User</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
            boolean isLoggedIn = (user != null);
            
            if(isLoggedIn){
        %>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Are you sure you want to cancel your User Account? (Details below)</h1>
            <h2>Name: ${user.name}</h2>
            <h2>Email: ${user.email}</h2>
            <h2>Phone: ${user.phone}</h2>
            <h2>Date Of Birth: ${user.dob}</h2>
            <h2>Address: ${user.address}</h2>
            <h2>admin: ${user.adminaccess}</h2>
        </div>
        
        <form method="POST" action="CancelUserServlet"("user/cancel", request) class="text-center">
            <button type="submit" name="doCancel" value="Cancel" class="btn btn-danger mt-4">Cancel Your Account</button>
        </form>
        <%
            }
            else
            {   
        %>
        <p>You are not logged in! </p> 
        <% } %>
    </body>
</html>