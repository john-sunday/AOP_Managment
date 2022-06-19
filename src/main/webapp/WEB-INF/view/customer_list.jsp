<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
										<!-- url del proyecto -> "${pageContext.request.contextPath}" -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css "/>

</head>
<body>

We have reached the list of future customers !!! 
<h1>Customer List</h1>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Surname</th>
		<th>Email</th>
		
		<th>Modify</th>
		
		<th>Delete</th>
	</tr>
	<c:forEach var="customer" items="${customers}">
		<!-- 1ºb - UPDATE: enviamos por url el parámetro id cliente. -->
		<c:url var="updateLink" value="/customer/showUpdateForm">
			<c:param name="customerId" value="${customer.id }"/>
		</c:url>
		<!-- 1ºc - DELETE -->
		<c:url var="deleteLink" value="/customer/deleteCustomer">
			<c:param name="customerId" value="${customer.id }"/>
		</c:url>
		<tr>
			<td>${customer.name}</td>
			<td>${customer.surname}</td>
			<td>${customer.email}</td>
			<!-- 1ºb -->
			<td><a href="${updateLink }"><input type="button" value="Modify"/></a></td>
			<!-- 1ºc - con Javascript(onclick="....) -->	
			<td><a href="${deleteLink }"><input type="button" value="Delete" 
			onclick="if(!(confirm('You are going to DELETE a record. Are you sure??'))) return false"/></a></td>
		</tr>
	</c:forEach>
</table>
<br>
<!-- 1ºa -  vamos a formulario para agregar -->
<input type="button" value="Aggregate Customer" onclick="window.location.href='showAggregateForm';return false; "/>
</body>
</html>