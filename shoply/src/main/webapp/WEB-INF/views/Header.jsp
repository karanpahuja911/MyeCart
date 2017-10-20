<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyeCart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<style>
.w3-lobster {
	font-family: "Lobster", serif;
}

/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 10px;
	border-radius: 0;
}

header {
	background-color: Tomato;
	padding: 20px;
}

.navbar-fixed-top {
	min-height: 50px;
}

@media ( min-width : 768px) {
	.navbar {
		border-radius: 8px;
		min-height: 10px;
	}
}

.button-custom, .button-custom .icon:before {
	font-size: 14px;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: DimGrey; >
	padding: 20px;
}

#googleMap {
	width: 100%;
	height: 400px;
	-webkit-filter: grayscale(100%);
	filter: grayscale(100%);
}

</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body background="resources/images/Backe14.jpg">

</div>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home"><font face="Kristen ITC"
				color="RoyalBlue">eCart</a>
		</div>
		<ul class="nav navbar-nav">

			<li class="active"><a href="<c:url value="/home"/>"> <font
					face="Papyrus" size="5"><b>Home</b> </font></a></li>
			<li class="dropdown"><a href="<c:url value="/getAllProduct"/>">
					<font face="Comic Sans MS" size="5"><b>Products</b></font>
			</a></li>
			<li><a href="<c:url value="/Contact"/>"> <font
					face="Comic Sans MS" size="5"><b>24*7 Customer Care</b></font></a></li>
					<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
				<li><a href="<c:url value="/saveProduct"/>"> <font
					face="Papyrus" size="5"><b>Add Product</b></font></a></li>
						<li><a href="<c:url value="/admin/supplier/supplierform"/>"> <font
					face="Papyrus" size="5"><b>Add Supplier</b></font></a></li>
					<li><a href="<c:url value="/admin/category/categoryform"/>"> <font
					face="Papyrus" size="5"><b>Add Category</b></font></a></li>
		</c:if>
		</ul>
		

		<form class="navbar-form navbar-left">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"> </i>
					</button>
				</div>
			</div>
		</form>

		<ul class="nav navbar-nav navbar-right">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
				<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
				<li><a href="<c:url value="/SignUp"/>"> <span
						class="glyphicon glyphicon-user"></span> <font face="Comic Sans MS"
						size="5"><b>Sign Up</b></font></a></li>
				<li><a href="<c:url value="/logIn"/>"> <span
						class="glyphicon glyphicon-log-in"></span> <font face="Comic Sans MS"
						size="5"> <b>Login</b></font></a></li>
			</c:if>
		</ul>
	</div>
	</div>
	</nav>