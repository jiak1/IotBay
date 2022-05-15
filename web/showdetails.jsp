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
        <div class="text-center container">
            <h1 class="mt-4 mb-4">Product details: </h1>
            <img src=<%=image%> height="400" width="400" >
            <br> 
            <p class="mt-4"><b>Product ID:</b> <%=productid %><br/>
            <b>Product Name:</b> <%=productname %><br/>
            <b>Product Price:</b> <%=price %></p> 
            <div class="mt-4 d-flex justify-content-center">
                <a class="btn btn-primary mr-4" href="add-tocart?id=<%=productid%>">Add to Cart</a> 
                <a class="btn btn-success" href="order-now?quantity=1">Buy Now</a>
            </div>
            <a class="btn btn-dark mt-4" href="/IotBay/searchProducts.jsp">Back</a> 
        </div>
        
    </body>
</html>
