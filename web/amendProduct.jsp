<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Amend Product</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            Product product = (Product) session.getAttribute("product");
            String priceErr = (String) session.getAttribute("priceErr");
            String taxErr = (String) session.getAttribute("taxErr");
            String dateErr = (String) session.getAttribute("dateErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String productnameErr = (String) session.getAttribute("productnameErr");
            String intErr = (String) session.getAttribute("intErr");
            String upperCaseErr = (String) session.getAttribute("upperCaseErr");
        %>
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Amend Product ID: ${product.productID} (Product Name: ${product.productName}) ONLY COMPLETE FIELDS BEING AMENDED!</h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="AmendProductServlet">
                <div class="mb-3">
                  <label for="name" class="form-label">Product name currently: ${product.productName}</label>
                  <input type="text" class="form-control" placeholder="<%=(productnameErr != null ? productnameErr : "Enter new productname/leave blank" )%>" name="name" > -->
                  <!-- <input type="text" class="form-control" placeholder=$<!--{product.productName}  name="name" >  -->
                </div>
                <div class="mb-3">
                  <label for="price" class="form-label">Price ($n.nn) currently: ${product.productPrice}</label>
                  <input type="text" class="form-control" placeholder="<%=(priceErr != null ? priceErr :  "Enter new price/ leave blank")%>" name="price" >  
                  <!--<input type="text" class="form-control" placeholder=$<!--{product.productPrice} name="price" > -->
                </div>
                <div class="mb-3">
                  <label for="tax" class="form-label">Tax ($n.nn)currently: ${product.productTax}</label>
                  <input type="text" class="form-control" placeholder="<%=(taxErr != null ? taxErr : "Enter new tax/ leave blank")%>" name="tax" >
                  <!--  <input type="text" class="form-control" placeholder=$<!--{product.productTax} name="tax" > -->
                </div>
                <div class="mb-3">
                  <label for="added_dt" class="form-label">Added date (yyyy-mm-dd) currently: ${product.productAddedDate}</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "New date/ leave blank")%>" name="added_dt" > 
                  <!--<input type="text" class="form-control" placeholder=$<!--{product.productAddedDate} name="added_dt" > -->
                </div>
                <div class="mb-3">
                  <label for="expiry_dt" class="form-label">Expiry date (yyyy-mm-dd) currently: ${product.productExpiryDate}</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "New expiry date/ leave blank")%>" name="expiry_dt" >  
                  <!--<input type="text" class="form-control" placeholder=$<--{product.productExpiryDate} name="expiry_dt" > -->
                </div>
                <div class="mb-3">
                  <label for="quantity" class="form-label">Quantity (in stock) currently: ${product.productQuantity}</label>
                  <input type="text" class="form-control" placeholder="<%=(intErr != null ? intErr : "New quantity/leave blank")%>" name="quantity"> 
                  <!--  <input type="text" class="form-control" placeholder=$<!--{product.productQuantity} name="quantity" > -->
                </div>
                <div class="mb-3">
                  <label for="category" class="form-label">Category (Wearable tech, Gaming Console, Smart TV, Voice control device, Printer, Camera, Lights, Thermostat, E-reader) currently: ${product.productCategory}</label>
                  <input type="text" class="form-control" placeholder="<%=(nameErr != null ? nameErr : "Update category/ leave blank")%>" name="category" > 
                  <!-- <input type="text" class="form-control" placeholder=$!-- {product.productCategory} name="category" > -->
                </div>
                <div class="mb-3">
                  <label for="location" class="form-label">Location (SYDNEY, MELBOURNE, BRISBANE, PERTH, ADELAIDE) currently: ${product.productLocation}</label>
                  <input type="text" class="form-control" placeholder="<%=(upperCaseErr != null ? upperCaseErr : "")%>" name="location" > 
                  <!-- <input type="text" class="form-control" placeholder=$<!--{product.productLocation} name="location" >  -->
                </div>
                <button type="submit" class="btn btn-primary">Amend Product</button>
              </form>
        </div>
    </body>
</html>
