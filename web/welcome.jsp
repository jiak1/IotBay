<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String loginRequest = request.getParameter("login");
            String name = request.getParameter("name");
            
            if(loginRequest != null && loginRequest.equals("login")){ //Trying to login
                if(user == null || email.equals(user.email) == false || password.equals(user.password) == false){
                    response.sendRedirect("/IotBay/login.jsp?status=invalid");
                    return;
                }
                name = user.getName();
            }else{            
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                
                user = new User(name,dob,phone,address,email,password);
                
                session.setAttribute("user", user);
            }
        %>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Welcome <%=name%>!</h1>
            <a class="btn btn-primary" href="/IotBay/main.jsp" role="button">View Account Details</a>
        </div>
    </body>
</html>
