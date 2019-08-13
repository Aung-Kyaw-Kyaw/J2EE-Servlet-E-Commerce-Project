<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<c:import url="layout/header.jsp">
	<c:param name="title">Login Page</c:param>
</c:import>

<c:if test="${!empty users }">
	<jsp:forward page="/index.jsp"></jsp:forward>
</c:if>

<!-- Form start -->
<div class="container">
<h2 class="text-info text-center my-5">Login To Buy</h2>
	<div class="col-md-6 offset-md-3">
		<form class="table-bordered p-5" method="post" action="http://localhost:8080/E-Commerce/UserController?action=loginform">
		
			<div class="form-group">
				<label for="email">Email address</label> <input
					type="email" class="form-control rounded-0" id="email" name="email"
				    placeholder="Enter email"> 
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input
					type="password" class="form-control rounded-0" id="password" name="password"
					placeholder="Password">
			</div>
			<a href="http://localhost:8080/E-Commerce/UserController?action=register">Not a member yet! Please register here.</a>
			<button type="submit" class="btn btn-primary float-right btn-sm">Login</button>
		</form>
	</div>
</div>
<!-- Form end -->

<c:import url="layout/jsgroup.jsp"></c:import>

<c:import url="layout/footer.jsp"></c:import>