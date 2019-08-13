<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<c:import url="layout/header.jsp">
	<c:param name="title">Cart Page</c:param>
</c:import>


<div class="container my-5">
	<table class="table table-bordered">
		<thead>
			<tr class="bg-dark text-white">
				<th scope="col">No.</th>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Image</th>
				<th scope="col">Count</th>
				<th scope="col">Total</th>
			</tr>
		</thead>
		<tbody id="tableBd">
		</tbody>

		<tbody>

			<tr>
				<td colspan="6" class="text-right">
					<c:if test="${!empty  users }">
						<a href="${BASE_URL }UserController?action=billout"
							class="btn btn-sm btn-info">Bill Out</a>
					</c:if> 
					
					<c:if test="${empty users }">
						<a href="${BASE_URL }UserController?action=billout"
							class="btn btn-sm btn-info">Login to Bill Out</a>
					</c:if>
					</td>
			</tr>

		</tbody>
	</table>
</div>



<c:import url="layout/jsgroup.jsp"></c:import>
<script src="${pageContext.request.contextPath }/assets/js/cart2.js"></script>

<c:import url="layout/footer.jsp"></c:import>
