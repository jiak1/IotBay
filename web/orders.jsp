<%@page import="uts.isd.model.dao.OrderDao"%>
<%@page import="uts.isd.model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="uts.isd.model.OrderLineItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    ArrayList<ShoppingCart> cart_list = (ArrayList<ShoppingCart>) session.getAttribute("cart-list");    
    if(cart_list!=null){
        request.setAttribute("cart_list",cart_list);
    }
    DBConnector db = new DBConnector();
    OrderDao odao = new OrderDao(db.openConnection());
    List<Order> orders = odao.getAllOrders();
    
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
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Quantity</th>
					<th scope="col">Status</th>
                                        <th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
                                                <td><%=o.getDate()%></td>
						<td><%=o.getQuantity() %></td>
                                                <td><%=o.getStatus()%></td>
                                                <td><a class="btn btn-sm btn-danger" href="cancelorder?id=<%=o.getUserId()%>">Cancel Order</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
	<%@include file="/fragments/footer.jsp"%>
</body>
</html>
