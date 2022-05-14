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
        <h1>Product Search Results are below: </h1>
        <table border="0px" cellspacing="3px" cellpadding="10px" >
            <tr>
            <%
                int cnt = 0;
                for (Product p : products) {
                cnt++;
                int productid = p.getProductID();
                String productname = p.getProductName();
                Double price = p.getProductPrice();
                String category = p.getProductCategory().trim();
                String image = "images/" + category.replaceAll(" ", "_") + ".png";
                if(cnt==3){
                    out.print("</tr><tr>");
                    cnt=0;
                }
            %>
                <td><a href="showdetails.jsp?productid=<%= productid%>&productname=<%= productname%>&price=<%= price%>&image=<%= image %>"> <img src=<%= image %> height="100" width="100" >  
                    <br>Product id: = <%= productid%> 
                    <br><%= productname%><br>Price: = $<%= price%>  
                </td>
                <% 
            }
            %>
        </table>
    </body>
</html>
