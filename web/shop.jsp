<%-- 
    Document   : shop
    Created on : 07/05/2022, 11:17:54 PM
    Author     : AlexK
--%>

<%@page import="uts.isd.model.dao.OrderItemDao"%>
<%@page import="uts.isd.model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DBConnector db = new DBConnector();
    OrderItemDao pd = new OrderItemDao(db.openConnection());
    List<OrderLineItem> products = pd.getAllOrders();
    
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/fragments/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="/fragments/nav.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (OrderLineItem p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="price">Price: $<%=p.getCost() %></h6>
						<h6 class="category">Location: <%=p.getStorageLocation() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-tocart?id=<%=p.getId()%>">Add to Cart</a> <a
								class="btn btn-primary" href="order-now?quantity=1">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>
	<%@include file="/fragments/footer.jsp"%>
</body>
</html>