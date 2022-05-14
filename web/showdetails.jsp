<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Product details</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
        </head>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            String productid = request.getParameter("productid");
            String productname = request.getParameter("productname");
            String price = request.getParameter("price");
            String image = request.getParameter("image");
        %>
        <h1>Product details: </h1>
        <img src=<%=image%> height="400" width="400" >
        <br> 
        Product ID :- <%=productid %> <br> 
        Product Name :- <%=productname %> <br> 
        Product Price :- <%=price %> <br> 
        
        
    </body>
</html>
