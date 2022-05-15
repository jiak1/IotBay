<%@ page import="uts.isd.model.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Amend User</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <%
            User user = (User)session.getAttribute("user");
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String dateErr = (String) session.getAttribute("dateErr");
        %>
        
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Amend User ID: ${user.ID}) ONLY COMPLETE FIELDS BEING AMENDED!</h1>
            <form method="POST" action="AmendUserServlet">
                <div class="mb-3">
                  <label for="name" class="form-label">User name currently: ${user.name}</label>
                  <input type="text" class="form-control" placeholder="<%=(nameErr != null ? nameErr : "Enter corrected name/leave blank" )%>" name="name" > 
                </div>
                <div class="mb-3">
                  <label for="email" class="form-label">Email currently: ${user.email}</label>
                  <input type="text" class="form-control" placeholder="<%=(emailErr != null ? emailErr :  "Enter correct email")%>" name="email" >  
                </div>
                <div class="mb-3">
                  <label for="phone" class="form-label">Phone currently: ${user.phone}}</label>
                  <input type="text" class="form-control" placeholder="Enter correct phone/ leave blank" name="phone" >
                </div>
                <div class="mb-3">
                  <label for="dob" class="form-label">Date of birth(yyyy-mm-dd) currently: ${user.dob}</label>
                  <input type="text" class="form-control" placeholder="<%=(dateErr != null ? dateErr : "New date/ leave blank")%>" name="dob" > 
                </div>
                <div class="mb-3">
                  <label for="address" class="form-label">Address currently: ${user.address}</label>
                  <input type="text" class="form-control" placeholder="New address/ leave blank" name="address" >  
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Update password (or leave blank)</label>
                  <input type="text" class="form-control" placeholder="<%=(passErr != null ? passErr : "Update password/leave blank")%>" name="password" > 
                </div>
                <button type="submit" class="btn btn-primary">Amend Registered Details</button>
              </form>
        </div>
    </body>
</html>
