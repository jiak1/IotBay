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
            Account account = (Account)session.getAttribute("account");
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String loginRequest = request.getParameter("login");
            String name = request.getParameter("name");
            
            if(loginRequest != null && loginRequest.equals("login")){ //Trying to login
                if(account == null || email.equals(account.email) == false || password.equals(account.password) == false){
                    response.sendRedirect("/IotBay/login.jsp?status=invalid");
                    return;
                }
                name = account.getName();
            }else{            
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                
                account = new Account(name,dob,phone,address,email,password);
                
                session.setAttribute("account", account);
            }
        %>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Welcome <%=name%>!</h1>
            <a class="btn btn-primary" href="/IotBay/main.jsp" role="button">View Account Details</a>
        </div>
    </body>
</html>
