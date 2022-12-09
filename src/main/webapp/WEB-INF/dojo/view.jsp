<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Members</title>
</head>
<body>
	<h1> Dojo Members </h1>
	<table>
		<thead>
			<tr>
				<th> First Name </th>
				<th> Last Name </th>
				<th> Age </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td><c:out value="${ninja.firstName}"/></td>
					<td>${ninja.lastName}</td>
					<td>${ninja.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>