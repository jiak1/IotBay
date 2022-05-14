<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>User account cancelled</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            String name = (String) session.getAttribute("name");
            session.invalidate();
        %>
        <div class="container-sm text-center mt-5">
            <h1 class="mb-3">Your user account has been deleted!</h1>
            <h2><%=name%>: Your account has been cancelled. </h2>
        </div>
    </body>
</html>
