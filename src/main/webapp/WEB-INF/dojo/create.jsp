<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Create Dojo</title>
</head>
<body>
	<h1>Create New Dojo</h1>
	<form:form action="/dojos/new" method="post" modelAttribute="dojo">
		<div>
			<form:label path="name"> Dojo </form:label>
			<form:input path="name" type="text"/>
			<form:errors path="name" class="text-danger"/>
		</div>
		<input type="submit" value="Create Dojo" class="btn btn-success"/>
	</form:form>
</body>
</html>