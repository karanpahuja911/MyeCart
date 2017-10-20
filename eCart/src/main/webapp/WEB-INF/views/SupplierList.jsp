<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Header.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background: #cccccc;

}
</style>

</head>
<body>
<div class="container">
 <h2>Lists Of Suppliers</h2><br>
 
<table border="0" cellpadding="30px" width="100%" >
<tr>
          <!-- <th>Supplier Image</th> -->
          <th>Supplier Name</th>
          <!-- <th>Info</th> -->
          <th>Update</th>
          <th>Delete</th>
</tr>

<c:forEach items="${supplier}" var="s" >
<tr>
          <%-- <c:url  value="/resources/images/${s.sup_Id}.png" var="url"/>
          <td><img src="${url}" height="80" width="80"> </td> --%>
          <td>${s.supname}</td>
         
         <%--  <c:url value="/admin/supplier/viewsupplier/${s.sup_Id }" var="url"/>
          <td><a href="${url }"><span class="glyphicon glyphicon-info-sign"></span></a></td> --%>
          
          <c:url value="/admin/supplier/editsupplier/${s.supid }" var="url"/>
          <td><a href="${url }"><span class="glyphicon glyphicon-pencil"></span></a></td>
          
          <c:url value="/admin/supplier/deletesupplier/${s.supid }" var="url"/>
          <td><a href="${url }"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
<br>
<br>
<br>
<br>
<br>

</body>
<%@ include file="Footer.jsp" %>
