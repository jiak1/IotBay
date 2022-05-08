<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>IotBay - Edit menu</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body onload=""startTime()">
        <div><span class="time" id="time" ></span> </div> 
        <%  
            User user = (User) session.getAttribute("user");
            String updated = (String)session.getAttribute("updated");
        %>
        
        <h1>Edit user information: <span class="message"> <%=(updated != null ? updated : "")%> </span> </h1>   
        <form method="post" action="UpdateServlet"> 
            <table id="form_table"> 
                <tr><td>Name:</td><td><input type="text" name="name" value="$(user.name)"   > </td></tr>
                <tr><td>DOB:</td><td><input type="date" name="dob" value="$(user.dob)"   > </td></tr>
                <tr><td>Phone:</td><td><input type="text" name="phone" value="$(user.phone)"   > </td></tr>
                <tr><td>Address:</td><td><input type="text" name="address" value="$(user.address)"   > </td></tr> 
                <tr><td>Email:</td><td><input type="text" name="email" value="$(user.email)"   > </td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" value="$(user.password)"   > </td></tr>
                <tr><td></td>
                    <td> 
                        <input class="button" type="submit" value=""Update"> 
                    </td> 
            </table>
        </form> 

    </body>
</html>
