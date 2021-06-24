<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new person</title>
</head>
<body>
<h1>Please enter your information below:</h1>
<form:form action="/person/new" method="POST" modelAttribute="person">
		<div>

			<form:label path="firstName">First Name</form:label>
			<form:input class="form-control" path="firstName" />
			<form:errors path="firstName" />
		</div>
		<div>
			<form:label path="lastName">Last Name</form:label>
			<form:input class="form-control" path="lastName" />
			<form:errors path="lastName" />
		</div>
		
		<button>Submit!</button>

	</form:form>

</body>
</html>