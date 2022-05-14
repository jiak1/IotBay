<%-- 
    Document   : searchProducts
    Created on : 13/05/2022, 9:42:37 PM
    Author     : AlexK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Search Products</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
            String productsearchErr = (String) session.getAttribute("productsearchErr");
        %>
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Search Products (using search term)</h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="SearchtermProductServlet">
                <div class="mb-3">
                  <label for="name" class="form-label">Search term</label>
                  <input type="text" class="form-control" placeholder="<%=(productsearchErr != null ? productsearchErr : "Enter product search term")%>" name="searchterm" required>
                </div>
                <button type="submit" class="btn btn-primary">Search Products</button>
              </form>
        </div>
<div class="center-form text-center mt-5">
            <h1 class="mb-3">Search Products (by Category and/or Location or leave blank for all)</h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="SearchProductByCatOrLocaleServlet">
                <div class="mb-3">
                  <label for="name" class="form-label">Category (Wearable tech, Gaming Console, Smart TV, Voice control device, Printer, Camera, Lights, Thermostat, E-reader)</label>
                  <input type="text" class="form-control" placeholder="<%=(productsearchErr != null ? productsearchErr : "Enter product category")%>" name="category" >
                </div>
                <div class="mb-3">
                  <label for="name" class="form-label">Location (SYDNEY, MELBOURNE, BRISBANE, PERTH, ADELAIDE)</label>
                  <input type="text" class="form-control" placeholder="<%=(productsearchErr != null ? productsearchErr : "Enter product location")%>" name="location" >
                </div>
                <button type="submit" class="btn btn-primary">Search Products</button>
              </form>
        </div>
    </body>
</html>