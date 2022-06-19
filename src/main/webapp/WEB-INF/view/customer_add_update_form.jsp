<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css "/>
</head>
<body>

<h1>Customer Insertion</h1>
<!-- 3ºa - mostramos formulario para AGREGAR y enviamos datos. -->
<form:form action="insertCustomer" modelAttribute="customer" method="POST">
	<!-- 5ºb -->
	<form:hidden path="id"/>
	
	<table id="table-1">

			<tr>
				<td>Name: </td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Surname: </td>
				<td><form:input path="surname"/></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><form:input path="email"/></td>								
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="Insert/Update"/></td>
			</tr>
	</table>
</form:form>

</body>
</html>