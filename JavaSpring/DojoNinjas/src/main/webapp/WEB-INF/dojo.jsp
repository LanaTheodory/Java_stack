<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add dojo</title>
</head>
<body>
<h1>Please enter the name of your Dojo below:</h1>
<form:form action="/dojo/new" method="POST" modelAttribute="dojo">
		<div>

			<form:label path="name"> Name</form:label>
			<form:input  path="name" />
			<form:errors path="name" />
		</div>
		
		<button>Submit!</button>

	</form:form>

</body>
</html>