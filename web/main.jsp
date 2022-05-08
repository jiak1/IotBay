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
            <h1 class="mb-3">User Details</h1>
            <h2>Name: ${user.name}</h2>
            <h2>Email: ${user.email}</h2>
            <h2>Phone: ${user.phone}</h2>
            <h2>Date Of Birth: ${user.dob}</h2>
            <h2>Address: ${user.address}</h2>
        </div>
    </body>
</html>
