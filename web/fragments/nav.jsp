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
            <li class="nav-item"><a href="/IotBay/searchProducts.jsp" class="nav-link link-dark px-2"><i class="bi bi-shop mr-2"></i>Shop</a></li>
            <li class="nav-item"><a href="/IotBay/orders.jsp" class="nav-link link-dark px-2">My Orders</a></li>
            <li class="nav-item"><a href="cart.jsp" class="nav-link link-dark px-2">Cart <span class="badge badge-danger"><%=cart_list_size%></span> </a></li>
            <li class="nav-item"><a href="/IotBay/login.jsp" class="nav-link link-dark px-2"><i class="bi bi-arrow-right-square mr-2"></i>Login</a></li>
            <li class="nav-item"><a href="/IotBay/register.jsp" class="nav-link link-dark px-2"><i class="bi bi-person-plus-fill mr-2"></i>Register</a></li>
        <% } else { %>
            <li class="nav-item"><a href="/IotBay/searchProducts.jsp" class="nav-link link-dark px-2"><i class="bi bi-shop mr-2"></i>Shop</a></li>
             <li class="nav-item"><a href="cart.jsp" class="nav-link link-dark px-2">Cart <span class="badge badge-danger"><%=cart_list_size%></span> </a></li>
            <li class="nav-item dropdown">
                <a class="nav-link link-dark dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-person-fill mr-2"></i><%=account.getName().split(" ")[0] %>
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li class="nav-item"><a href="/IotBay/orders.jsp" class="nav-link link-dark px-2">My Orders</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li class="nav-item"><a href="/IotBay/searchUserLogs.jsp" class="nav-link link-dark px-2">Access Logs</a></li> 
                  <li class="nav-item"><a href="/IotBay/amendUser.jsp" class="nav-link link-dark px-2">Update Account</a></li> 
                  <li class="nav-item"><a href="/IotBay/confirmCancelUser.jsp" class="nav-link link-dark px-2">Deactivate Account</a></li> 
                  <li><hr class="dropdown-divider"></li>
                  <li class="nav-item"><a href="LogoutController" class="nav-link link-dark px-2"><i class="bi bi-door-open-fill mr-2"></i>Logout</a></li> 
                </ul>
            </li>
            <% if (account.getAdminaccess()){ %>
            <li class="nav-item dropdown">
                <a class="nav-link link-dark dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-gear-fill mr-2"></i>Admin</a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li class="nav-item"><a href="/IotBay/registerProduct.jsp" class="nav-link link-dark px-2">Register Product</a></li>
                    <li class="nav-item"><a href="/IotBay/amendProductSearch.jsp" class="nav-link link-dark px-2">Update Product</a></li>
                    <li class="nav-item"><a href="/IotBay/deleteProductSearch.jsp" class="nav-link link-dark px-2">Delete Product</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li class="nav-item"><a href="/IotBay/AccountsServlet" class="nav-link link-dark px-2">Accounts</a></li> 
                </ul>
            </li>
        <% }} %>
      </ul>
    </div>
</nav>