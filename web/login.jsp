<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>IotBay - 14256034</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <div class="center-form text-center mt-5">
            <%
                String status = request.getParameter("status");
                
                if(status != null){
            %>
              <div class="alert alert-danger fade show" role="alert">
                Invalid login credentials!
              </div>
            <% } %>
            <%
                Account account = (Account)session.getAttribute("account");
                
                if(account == null){
            %>
              <div class="alert alert-warning fade show" role="alert">
                There aren't any accounts registered on this session. We suggest you register one first!
              </div>
            <% } %>
            <h1 class="mb-3">Login</h1>
             <form method="POST" action="/IOTBay/welcome.jsp">
                <div class="mb-3">
                  <label for="email" class="form-label">Email address</label>
                  <input type="email" class="form-control" name="email" aria-describedby="emailHelp" required>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" name="password" required>
                </div>
                <input type="hidden" name="login" value="login" required>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
        </div>
    </body>
</html>
