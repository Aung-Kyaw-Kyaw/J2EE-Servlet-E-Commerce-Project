<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<c:import url="layout/header.jsp">
	<c:param name="title">Product Page</c:param>
</c:import>

<!-- Product page start -->

<div class="container mt-3">
	<div class="row">
		<c:forEach var="products" items="${products }">
			<div class="col-md-3">
			<div class="card mb-3">
				<div class="card-header text-center">${products.name }</div>
				<div class="card-body">
						<img class="img-fluid myimgsize" src="${pageContext.request.contextPath }/assets/imgs/${products.image }">
				</div>
				<div class="card-footer">
					<div class="row justify-content-between">
						<span>$ ${products.price }</span>
						<button class="btn btn-outline-info btn-sm" onclick="addItemToDB(${products.id})">
							<i class="fa fa-shopping-cart"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>

<!-- Product page end -->

<c:import url="layout/jsgroup.jsp"></c:import>

<c:import url="layout/footer.jsp"></c:import>