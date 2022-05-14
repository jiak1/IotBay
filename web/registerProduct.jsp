<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
            String existErr = (String) session.getAttribute("existErr");
            String priceErr = (String) session.getAttribute("priceErr");
            String taxErr = (String) session.getAttribute("taxErr");
            String dateErr = (String) session.getAttribute("dateErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String intErr = (String) session.getAttribute("intErr");
            String upperCaseErr = (String) session.getAttribute("upperCaseErr");
        %>
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Register Product</h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="RegisterProductServlet">
                <div class="mb-3">
                  <label for="name" class="form-label">Product name</label>
                  <input type="text" class="form-control" placeholder="<%=(nameErr != null ? nameErr : "Enter product name")%>" name="name" required>
                </div>
                <div class="mb-3">
                  <label for="price" class="form-label">Price ($n.nn)</label>
                  <input type="text" class="form-control" placeholder="<%=(priceErr != null ? priceErr : "Enter price")%>" name="price" required>
                </div>
                <div class="mb-3">
                  <label for="tax" class="form-label">Tax ($n.nn)</label>
                  <input type="text" class="form-control" placeholder="<%=(taxErr != null ? taxErr : "Enter tax")%>" name="tax" required>
                </div>
                <div class="mb-3">
                  <label for="added_dt" class="form-label">Added date (yyyy-mm-dd)</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "Enter added date")%>" name="added_dt" required>
                </div>
                <div class="mb-3">
                  <label for="expiry_dt" class="form-label">Expiry date (yyyy-mm-dd)</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "Enter expiry date")%>" name="expiry_dt" required>
                </div>
                <div class="mb-3">
                  <label for="quantity" class="form-label">Quantity (in stock)</label>
                  <input type="text" class="form-control" placeholder="<%=(intErr != null ? intErr : "Enter quantity (stock)")%>" name="quantity" required>
                </div>
                <div class="mb-3">
                  <label for="category" class="form-label">Category (Wearable tech, Smart TV, Voice control device, Printer, Camera, Lights, Thermostat, E-reader)</label>
                  <input type="text" class="form-control" placeholder="<%=(nameErr != null ? nameErr : "Enter category")%>" name="category" required>
                </div>
                <div class="mb-3">
                  <label for="location" class="form-label">Location (SYDNEY, MELBOURNE, BRISBANE, PERTH, ADELAIDE)</label>
                  <input type="text" class="form-control" placeholder="<%=(upperCaseErr != null ? upperCaseErr : "Enter location")%>" name="location" required>
                </div>
                <button type="submit" class="btn btn-primary">Register Product</button>
              </form>
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
