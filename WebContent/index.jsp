<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<c:import url="layout/header.jsp">
	<c:param name="title">Index Page</c:param>
</c:import>

<c:import url="layout/slideshow.jsp"></c:import>

<sql:setDataSource var="ds" dataSource="jdbc/TestDB"/>
<sql:query var="result" dataSource="${ds }" sql="SELECT * FROM categories"></sql:query>

<!-- Categories page start -->

<div class="container mt-3">
	<div class="row">
		<c:forEach var="cat" items="${result.rows }">
			<div class="col-md-3">
			<div class="card mb-3">
			<div class="card-body">
			<a href="http://localhost:8080/E-Commerce/ProductController?cat_id=${cat.id}">
					<img class="img-fluid myimgsize " src="${pageContext.request.contextPath }/assets/imgs/${cat.image}">
			</a>
			</div>
				<div class="card-footer text-center">${cat.name }</div>
			</div>
		</div>
		</c:forEach>
	</div>	
</div>

<!-- Categories page end -->

<c:import url="layout/jsgroup.jsp"></c:import>

<c:import url="layout/footer.jsp"></c:import>