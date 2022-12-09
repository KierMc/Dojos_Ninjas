<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>
	<h1>Dashboard</h1>
	<h4><a href="/dojos/new">Create Dojo</a></h4>
	<h4><a href="/ninjas/new">Create Ninja</a></h4>
	
	<h2>Dojo Name:</h2>
	<c:forEach var="dojo" items="${allDojos}">
		<h5><a href="/dojos/view/${dojo.id}"><c:out value="${dojo.name}"/></a></h5>
	</c:forEach>
	
</body>
</html>