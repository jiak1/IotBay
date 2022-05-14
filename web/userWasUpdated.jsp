<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Main</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Your User Details Have Been Updated:</h1>
            <h2>Name: ${user.name}</h2>
            <h2>Email: ${user.email}</h2>
            <h2>Phone: ${user.phone}</h2>
            <h2>Date Of Birth: ${user.dob}</h2>
            <h2>Address: ${user.address}</h2>
            <h2>admin: ${user.adminaccess}</h2>
        </div>
        <%
        
        if( user.getAdminaccess() ) {
            
        %>
        <div class="container-sm text-center mt-5">
            <!--<h1 class="mb-3">Add Products? !</h1> -->
            <a class="btn btn-primary" href="/IotBay/registerProduct.jsp" role="button">Register Products</a>
        </div> 
        <div class="container-sm text-center mt-5">
            <!--<h1 class="mb-3">Add Products? !</h1> -->
            <a class="btn btn-primary" href="/IotBay/amendProductSearch.jsp" role="button">Amend Products</a>
        </div> 
        <div class="container-sm text-center mt-5">
            <!--<h1 class="mb-3">Add Products? !</h1> -->
            <a class="btn btn-primary" href="/IotBay/deleteProductSearch.jsp" role="button">Delete Products</a>
        </div>
         <% } %>
    </body>
</html>