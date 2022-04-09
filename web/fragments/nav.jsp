<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %> 
<nav class="py-2 bg-light border-bottom">
    <div class="container d-flex flex-wrap">
      <ul class="nav me-auto">
        <li class="nav-item"><a href="/IOTBay" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
      </ul>
      <ul class="nav">
          <%
              Account account = (Account)session.getAttribute("account");
              if(account == null){
          %>
            <li class="nav-item font-weight-bold"><a href="/IOTBay/login.jsp" class="nav-link link-dark px-2">Login</a></li>
            <li class="nav-item font-weight-bold"><a href="/IOTBay/register.jsp" class="nav-link link-dark px-2">Register</a></li>
        <% } else { %>
            <li class="nav-item font-weight-bold"><a href="/IOTBay/logout.jsp" class="nav-link link-dark px-2">Logout</a></li>
        <% } %>
      </ul>
    </div>
</nav>