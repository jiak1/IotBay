<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Product</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
            Product product = (Product)session.getAttribute("product");
        %>
        <div class="center-form text-center mt-5">
        <h1 class="mb-3">Delete Product ID: ${product.productID} (Product Name: ${product.productName}) </h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="DeleteProductServlet">
            <h1 class="mb-3">Delete Product?</h1>
            <h2>Product ID ${product.productID}</h2>
            <h2>Product name: ${product.productName}</h2>
            <h2>Price ${product.productPrice}</h2>
            <h2>Tax: ${product.productTax}</h2>
            <h2>Date added: ${product.productAddedDate}</h2>
            <h2>Expiry date ${product.productExpiryDate}</h2>
            <h2>Quantity ${product.productQuantity}</h2>
            <h2>Category ${product.productCategory}</h2> 
            <h2>Location ${product.productLocation}</h2>
        
        <button type="submit" class="btn btn-primary">Delete Product</button>
        </form>
        </div>
    </body>
</html>
