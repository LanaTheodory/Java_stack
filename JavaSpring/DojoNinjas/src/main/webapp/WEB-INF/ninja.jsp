<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add ninja</title>
</head>
<body>
<form:form action="/ninja/new/add" method="POST" modelAttribute="ninja">
		<div>
			<form:select path="dojo">
				<c:forEach items="${dojo}" var="p">
					<form:option value="${ p.id }">${ p.name }</form:option>
				</c:forEach>
			</form:select>
		</div>
		
		<div>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" />
		</div>
		<div>

			<form:label path="lastName">Last Name</form:label>
			<form:input   path="lastName" />
			<form:errors path="lastName" />
		</div>
			<div>

			<form:label path="age">Age</form:label>
			<form:input  type="number" path="age" />
			<form:errors path="age" />
		</div>
		<button>Add!</button>
</form:form>
</body>
</html>