<%-- 
    Document   : productAdded
    Created on : 13/05/2022, 11:40:41 AM
    Author     : AlexK
--%>

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
            Product product = (Product)session.getAttribute("product");
        %>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Product Added!</h1>
            <h2>Product ID: ${product.productID}</h2>
            <h2>Product name: ${product.productName}</h2>
            <h2>Price: ${product.productPrice}</h2>
            <h2>Tax: ${product.productTax}</h2>
            <h2>Date added: ${product.productAddedDate}</h2>
            <h2>Expiry date: ${product.productExpiryDate}</h2>
            <h2>Quantity: ${product.productQuantity}</h2>
            <h2>Category: ${product.productCategory}</h2> 
            <h2>Location: ${product.productLocation}</h2>
            
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
