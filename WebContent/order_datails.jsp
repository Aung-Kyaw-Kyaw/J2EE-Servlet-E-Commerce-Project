<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<c:import url="layout/header.jsp">
	<c:param name="title">Order Page</c:param>
</c:import>

<div class="container">

	
<!-- Table Start -->
<table class="table table-bordered mt-3">
  <thead class="text-white bg-dark">
    <tr>
      <th scope="col">No</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Count </th>
      <th scope="col">Total</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="orders" items="${orders }">
  
    <tr>
      <td>${orders.id }</td>
      <td>${orders.orders }</td>
      <td>jg</td>
      <td>gh</td>
      <td>jhk</td>
      
    </tr>
    
    </c:forEach>
    
  </tbody>
</table>
<!-- Table End -->

</div>






<c:import url="layout/jsgroup.jsp"></c:import>

<c:import url="layout/footer.jsp"></c:import>