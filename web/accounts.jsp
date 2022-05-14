<%@page import="uts.isd.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="uts.isd.model.OrderLineItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<User> accounts = (ArrayList<User>)request.getAttribute("accounts");
    String name = "";
    if(request.getParameter("name") != null){
        name = request.getParameter("name");
    }
    String phone = "";
    if(request.getParameter("phone") != null){
        phone = request.getParameter("phone");
    }
    
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
		<div class="card-header my-3">
                    <label>Search Accounts:</label>
                     <form action="AccountsServlet" method="post" class="form-inline"> 
                        <div class="mb-3">
                          <input type="text" placeholder="Full Name" value="<%=name%>" class="form-control" name="name">
                          <input type="text" placeholder="Phone Number" value="<%=phone%>" class="form-control ml-2" name="phone">
                          <button type="submit" class="btn btn-primary ml-2">Search</button>
                        </div>
                     </form>
                </div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Phone</th>
					<th scope="col">Account Status</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(accounts != null){
				for(User a: accounts){%>
					<tr>
                                                <td><%=a.getName()%></td>
						<td><%=a.getPhone() %></td>
                                                <td><%=a.getAdminaccess()%></td>
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