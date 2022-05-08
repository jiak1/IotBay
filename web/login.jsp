<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>IotBay - Login page</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body onload="startTime()">
        <div><span class=""time" id=""time" > </span></div> 
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <div class="center-form text-center mt-5">
            <%
                //String status = request.getParameter("status");
                
                //if(status != null){

            %>
             <!-- <div class="alert alert-danger fade show" role="alert">
                Invalid login credentials!
              </div> -->
            <% //} %>
            <%
                //User user = (User)session.getAttribute("user");
                
                //if(user == null){
            %>
            <!--  <div class="alert alert-warning fade show" role="alert">
                There aren't any users registered on this session. We suggest you register one first!
              </div> -->
            <% // } %>
            <% 
                String existErr = (String) session.getAttribute("existErr");
                String emailErr = (String) session.getAttribute("emailErr");
                String passErr = (String) session.getAttribute("passErr");
            %>
            <h1 class="mb-3">Login <span class="message" > <%= (existErr != null ? existErr : "") %> </span>  </h1>
             <!-- <form method="POST" action="/IotBay/welcome.jsp"> -->
             <form action="LoginServlet" method="post" > 
                <div class="mb-3">
                  <label for="email" class="form-label">Email address</label>
                  <input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email") %>" class="form-control" name="email" aria-describedby="emailHelp" required>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password") %>" class="form-control" name="password" required>
                </div>
                <input type="hidden" name="login" value="login" required>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
        </div>
    </body>
</html>
