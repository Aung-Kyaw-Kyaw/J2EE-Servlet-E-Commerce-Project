<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<div class="container-fluid bg-dark">
	<nav class=" container navbar navbar-expand-lg navbar-light">
	
	<i class="fa fa-list mymenu" onclick="toggleMenuIcon()"></i>
	
  <a class="navbar-brand text-white" href="http://localhost:8080/E-Commerce/">
  	<img src="${pageContext.request.contextPath }/assets/imgs/logoicon.png" width="30" height="30" class="rounded">
  	<span class="ml-4">E-Commerce</span>
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">

	<li class="nav-item">
        <a class="nav-link text-white" href="#" tabindex="-1">
        <i class="fa fa-phone-square"></i>
        <span>09-766761796</span>
        </a>
      </li>
	
      <li class="nav-item">
        <a class="nav-link text-white" href="http://localhost:8080/E-Commerce/cart.jsp">
        	<i class="fa fa-shopping-cart"></i>
        	<span class="badge badge-danger badge-pill badge-position" id="cartCount">0</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Members
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        
        
        <c:if test="${!empty users }">
        	<a class="dropdown-item" href="${BASE_URL }UserController?action=logout">Logout</a>
        	
        	        <!-- ${BASE_URL} is assign from header.jsp (set variable) -->
        </c:if>
         
        <c:if test="${empty users }">
          <a class="dropdown-item" href="${BASE_URL }UserController?action=login">Login</a>
          <a class="dropdown-item" href="${BASE_URL }UserController?action=register">Register</a>
        </c:if>
        
        </div>
      </li>
      
      
            <li class="nav-item active">
        <a class="nav-link text-white" href="http://localhost:8080/E-Commerce/">My Orders</a>
      </li>
    </ul>
  </div>
</nav>
</div>