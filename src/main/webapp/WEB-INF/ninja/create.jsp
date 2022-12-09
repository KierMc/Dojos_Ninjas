<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Ninja</title>
</head>
<body>
	<h1>Create New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<div>	
			<form:select path="dojo">
				<c:forEach var="dojo" items="${allDojos}">
					<form:option value="${dojo.id}" path="dojo">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:label path="firstName"> First Name: </form:label>
			<form:input path="firstName" type="text"/>
			<form:errors path="firstName" class="text-danger"/>
		</div>
		<div>
			<form:label path="lastName"> Last Name: </form:label>
			<form:input path="lastName" type="text"/>
			<form:errors path="lastName" class="text-danger"/>
		</div>
		<div>
			<form:label path="age"> Age: </form:label>
			<form:input path="age" type="number"/>
			<form:errors path="age" class="text-danger"/>
		</div>
		<input type="submit" value="Create Ninja" class="btn btn-success"/>
	</form:form>
</body>
</html>