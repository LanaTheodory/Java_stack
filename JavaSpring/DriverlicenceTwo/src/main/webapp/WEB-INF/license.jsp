<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new license</title>
</head>
<body>
<h1>New license</h1>

	<form:form action="/license/new" method="POST" modelAttribute="license">
		<div>
			<form:select path="person">
				<c:forEach items="${people}" var="p">
					<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
				</c:forEach>
			</form:select>
		</div>
		
		<div>
			<form:label path="state">State</form:label>
			<form:input path="state" />
			<form:errors path="state" />
		</div>
		<div>

			<form:label path="expirationDate">Expiration date</form:label>
			<form:input  type="date" path="expirationDate" />
			<form:errors path="expirationDate" />
		</div>
		<button>Submit license</button>
</form:form>
</body>
</html>