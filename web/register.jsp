<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <jsp:include page="fragments/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="fragments/nav.jsp"></jsp:include>
        <div class="center-form text-center mt-5">
            <h1 class="mb-3">Register</h1>
            <form method="POST" action="/IOTBay/welcome.jsp">
                <div class="mb-3">
                  <label for="name" class="form-label">Name</label>
                  <input type="text" class="form-control" name="name" aria-describedby="nameHelp" required>
                </div>
                <div class="mb-3">
                  <label for="email" class="form-label">Email address</label>
                  <input type="email" class="form-control" name="email" aria-describedby="emailHelp" required>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" name="password" required>
                </div>
                <div class="mb-3">
                  <label for="phone" class="form-label">Phone Number</label>
                  <input type="text" class="form-control" name="phone" aria-describedby="phoneHelp" required>
                </div>
                <div class="mb-3">
                  <label for="address" class="form-label">Address</label>
                  <input type="text" class="form-control" name="address" aria-describedby="addressHelp"required>
                </div>
                <div class="mb-3">
                  <label for="dob" class="form-label">Date Of Birth</label>
                  <input type="date" class="form-control" name="dob" aria-describedby="dobHelp" required>
                </div>
                <button type="submit" class="btn btn-primary">Register Account</button>
              </form>
        </div>
    </body>
</html>