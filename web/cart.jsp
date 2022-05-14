<%-- 
    Document   : cart
    Created on : May 11, 2022, 3:03:55 PM
    Author     : DELL
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="uts.isd.model.dao.OrderItemDao"%>
<%@page import="uts.isd.model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    ArrayList<ShoppingCart> cart_list = (ArrayList<ShoppingCart>) session.getAttribute("cart-list");
    List<ShoppingCart> cartProduct = null;
    if(cart_list!=null){
        DBConnector db = new DBConnector();
        OrderItemDao pd = new OrderItemDao(db.openConnection());
        double total = pd.getTotalCartPrice(cart_list);
        request.setAttribute("total",total);
        cartProduct = pd.getCartItems(cart_list);
        request.setAttribute("cart_list",cart_list);
    }
    
%>
<!DOCTYPE html>
<html>
<head>
<title>E-Commerce Cart</title>
<style type="text/css">

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<%@include file="/fragments/head.jsp"%>
<body>
    <%@include file="/fragments/nav.jsp" %>>
	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="check-outcart">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
                                        <th scope="col">Location</th>
					<th scope="col">Quantity</th>
                                        <th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
                            <%if(cart_list!=null){
                                for(ShoppingCart c:cartProduct){
                                    %><tr>
                                        <td><%=c.getName()%></td>
					<td><%=dcf.format(c.getCost())%></td>
                                        <td><%=c.getStorageLocation()%></td>
					<td>
						<form action="ordercart-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%=c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
                                                            <a class="btn bnt-sm btn-incre" href="quantity-incdec?action=inc&id=<%=c.getId()%>" ><i class="fas fa-plus-square"></i></a> 
                                                            <input type="text" name="quantity" class="form-control" value="<%=c.getQuantity()%>"> 
                                                            <a class="btn btn-sm btn-decre" href="quantity-incdec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
                                                <button type="submit" class="btn btn-primary btn-sm">Buy</button>
							
						</form>
					</td>
					<td><a href="remove-fromcart?id=<%=c.getId()%>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>
                                <%}
                            }
else{
System.out.println("No cartList");
}%>
				
			</tbody>
		</table>
	</div>