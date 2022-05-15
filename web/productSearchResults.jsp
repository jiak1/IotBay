<%-- 
    Document   : productSearchResults
    Created on : 13/05/2022, 10:45:44 PM
    Author     : AlexK
--%>

<%@page import="java.util.ArrayList"%>
<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Product Search Results</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
        %>
	<div class="container">
		<div class="card-header my-3">Product Search Results</div>
		<div class="row">
            <%
                int cnt = 0;
                for (Product p : products) {
                cnt++;
                int productid = p.getProductID();
                String productname = p.getProductName();
                Double price = p.getProductPrice();
                String location = p.getProductLocation();
                String category = p.getProductCategory().trim();
                String image = "images/" + category.replaceAll(" ", "_") + ".png";
                if(cnt==3){
                    out.print("</tr><tr>");
                    cnt=0;
                }
            %>
                            <div class="col-md-3 my-3">
				<div class="card w-100">
					<div class="card-body">
                                            <a href="showdetails.jsp?productid=<%= productid%>&productname=<%= productname%>&price=<%= price%>&image=<%= image %>">
                                                <img src=<%= image %> height="100" width="100" />
						<h5 class="card-title"><%= productname%></h5></a>
						<h6 class="price">Price: $<%= price%></h6>
						<h6 class="category">Location: <%= location%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-tocart?id=<%=productid%>">Add to Cart</a> <a
								class="btn btn-primary" href="order-now?quantity=1">Buy Now</a>
						</div>
					</div>
                                    
				</div>
			</div>
                <% 
            }
            %>
                </div>
        </div>
    </body>
</html>
