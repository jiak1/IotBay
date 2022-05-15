<%-- 
    Document   : showUserLogs
    Created on : 15/05/2022, 2:35:42 PM
    Author     : AlexK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="uts.isd.model.Log"%>
<!DOCTYPE html>
<%
    ArrayList<Log> userlogs = (ArrayList<Log>)request.getAttribute("userlogs");
    
%>
<html>
    <head>
<%@include file="/fragments/head.jsp"%>
<title>Log Search Results</title>
</head>
<body>
	<%@include file="/fragments/nav.jsp"%>
   
        <h1>The below logs searched for ${user.ID} ${user.name}</h1>
        
        <table class="table table-light">
            <thead>
                    <tr>
                            <th scope="col">Logdate</th>
                            <th scope="col">Details</th>
                            <th scope="col">ProductID</th>
                    </tr>
            </thead>
            <tbody>

            <%
            if(userlogs != null){
                    for(Log l: userlogs){%>
                            <tr>
                                    <td><%=l.getLogDate()%></td>
                                    <td><%=l.getDetails() %></td>
                                    <td><%= "n/a" %></td> <!-- !(l.getProductID()==0) ? l.getProductID() : -->
                            </tr>
                    <%}
            }
            %>
            </tbody>
        </table>
        <%@include file="/fragments/footer.jsp"%>
    </body>
</html>