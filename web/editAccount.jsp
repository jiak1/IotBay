<%@page import="uts.isd.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="uts.isd.model.OrderLineItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User a = (User)request.getAttribute("account");
    
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/fragments/head.jsp"%>
<title>Edit Account</title>
</head>
<body>
	<%@include file="/fragments/nav.jsp"%>
	<div class="container">
		<div class="card-header my-3">
                    <h4 class="mb-4">Edit Account:</h4>
                    <form action="/IotBay/EditAccountServlet?userid=<%=a.getID()%>" method="post"> 
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label">Full Name</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" value="<%=a.getName()%>">
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label">Email</label>
                          <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" value="<%=a.getEmail()%>">
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label">Phone</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" name="phone" value="<%=a.getPhone()%>">
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label">Address</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" name="address" value="<%=a.getAddress()%>">
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label">Date Of Birth</label>
                          <div class="col-sm-10">
                            <input type="date" class="form-control" name="dob" value="<%=a.getDob()%>">
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" name="password" value="<%=a.getPassword()%>">
                          </div>
                        </div>
                        <div class="row mb-3">
                          <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" name="adminaccess" value="true" <% if(a.getAdminaccess()){%>checked<%}%>>
                              <label class="form-check-label" for="gridCheck1">
                                Administrator
                              </label>
                            </div>
                          </div>
                        </div>
                        <div class="row mb-3">
                          <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" name="deactivated" value="true" <% if(a.isDeactivated()){%>checked<%}%>>
                              <label class="form-check-label" for="gridCheck1">
                                Deactivated
                              </label>
                            </div>
                          </div>
                        </div>
                        <div class="row mb-3">
                          <div class="col-sm-10 offset-sm-2">
                              <button type="submit" class="btn btn-success">Update</button>
                              <button type="submit" class="btn btn-danger">Delete</button>
                          </div>
                        </div>
                        
                      </form>
                </div>
	</div>
	<%@include file="/fragments/footer.jsp"%>
</body>
</html>