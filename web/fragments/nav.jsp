<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %> 
<nav class="py-2 bg-light border-bottom">
    <div class="container d-flex flex-wrap">
      <ul class="nav me-auto">
        <li class="nav-item"><a href="/IotBay" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
      </ul>
      <ul class="nav">
          <%
              ArrayList<ShoppingCart> nav_cart_list = (ArrayList<ShoppingCart>) session.getAttribute("cart-list");
              int cart_list_size = 0;
              if(nav_cart_list != null){
                cart_list_size = nav_cart_list.size();
              }
              User account = (User)session.getAttribute("user");
              if(account == null){
          %>
            <li class="nav-item"><a href="/IotBay/searchProducts.jsp" class="nav-link link-dark px-2">Shop</a></li>
            <li class="nav-item"><a href="/IotBay/orders.jsp" class="nav-link link-dark px-2">My Orders</a></li>
            <li class="nav-item"><a href="cart.jsp" class="nav-link link-dark px-2">Cart <span class="badge badge-danger"><%=cart_list_size%></span> </a></li>
            <li class="nav-item"><a href="/IotBay/login.jsp" class="nav-link link-dark px-2">Login</a></li>
            <li class="nav-item"><a href="/IotBay/register.jsp" class="nav-link link-dark px-2">Register</a></li>
        <% } else { %>
            <li class="nav-item"><a href="/IotBay/searchProducts.jsp" class="nav-link link-dark px-2">Shop</a></li>
            <li class="nav-item"><a href="/IotBay/orders.jsp" class="nav-link link-dark px-2">My Orders</a></li>
            <li class="nav-item"><a href="cart.jsp" class="nav-link link-dark px-2">Cart <span class="badge badge-danger"><%=cart_list_size%></span> </a></li>
           <!-- <li class="nav-item font-weight-bold"><a href="/IotBay/logout.jsp" class="nav-link link-dark px-2">Logout</a></li>  -->
            <li class="nav-item"><a href="/IotBay/amendUserServlet" class="nav-link link-dark px-2">Amend Details</a></li> 
            <li class="nav-item"><a href="/IotBay/searchUserLogs.jsp" class="nav-link link-dark px-2">View Logs</a></li> 
            <li class="nav-item"><a href="/IotBay/confirmCancelUser.jsp" class="nav-link link-dark px-2">Cancel Account</a></li> 
            <li class="nav-item"><a href="LogoutController" class="nav-link link-dark px-2">Logout</a></li> 
            <li class="nav-item"><a href="/IotBay/AccountsServlet" class="nav-link link-dark px-2">Accounts</a></li> 
        <% } %>
      </ul>
    </div>
</nav>