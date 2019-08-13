<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>${param.title }</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon"
	href="${pageContext.request.contextPath }/assets/imgs/icon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/custom.css"/>

</head>
<body>
	<c:set var="BASE_URL" value="http://localhost:8080/E-Commerce/"></c:set>
	<c:import url="layout/navbar.jsp"></c:import>
	<c:import url="layout/sidebar.jsp"></c:import>

	<div class="container my-5">
		<c:if test="${!empty msgError }">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>${msgError }</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<%
				request.removeAttribute("msgError");
			%>
		</c:if>

		<c:if test="${!empty msgSuccess }">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>${msgSuccess }</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%
				request.removeAttribute("msgSuccess");
			%>
		</c:if>
	</div>