<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uts.isd.model.*" %> 

<!DOCTYPE html>
<html>
    <head>
        <title>IotBay - Group 15</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        
        <div class="text-center mt-5">
            <h1>IOTBay Home Page</h1>
            <h2>Please register or login using the links in the navbar</h2>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />        
    </body>
</html>
