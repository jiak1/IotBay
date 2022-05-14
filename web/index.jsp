
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IotBay - Group 15</title>
        <jsp:include page="/fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="/fragments/nav.jsp"></jsp:include>
        
            <h1>IOTBay Home Page</h1>
            <h2>Please register or login using the links in the navbar</h2>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
