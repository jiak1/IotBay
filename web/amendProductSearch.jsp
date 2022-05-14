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
            String priceErr = (String) session.getAttribute("priceErr");
            String taxErr = (String) session.getAttribute("taxErr");
            String dateErr = (String) session.getAttribute("dateErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String intErr = (String) session.getAttribute("intErr");
            String upperCaseErr = (String) session.getAttribute("upperCaseErr");
        %>
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Amend Product</h1>
            <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
            <form method="POST" action="SearchProductServlet">
                <div class="mb-3">
                  <label for="name" class="form-label">Product ID</label>
                  <input type="text" class="form-control" placeholder="<%=(intErr != null ? intErr : "Enter product name")%>" name="productID" >
                </div>
                <div class="mb-3">
                  <label for="name" class="form-label">Product name</label>
                  <input type="text" class="form-control" placeholder="<%=(nameErr != null ? nameErr : "Enter product name")%>" name="productname" >
                </div>
                
                <button type="submit" class="btn btn-primary">Amend Product</button>
              </form>
        </div>
    </body>
</html>
