<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <h1>Logging out...</h1>
        <%
            session.invalidate();
            response.sendRedirect("/IotBay/index.jsp");
        %>
    </body>
</html>
