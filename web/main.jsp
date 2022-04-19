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
            Account account = (Account)session.getAttribute("account");
        %>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Account Details</h1>
            <h2>Name: ${account.name}</h2>
            <h2>Email: ${account.email}</h2>
            <h2>Phone: ${account.phone}</h2>
            <h2>Date Of Birth: ${account.dob}</h2>
            <h2>Address: ${account.address}</h2>
        </div>
    </body>
</html>