<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>your profile</title>
</head>
<body>
<h1>${person.firstName}  ${person.lastName}</h1>
<p> ${person.license.state }</p>

<p> ${person.license.expirationDate } /></p>
<p> ${person.license.number }</p>
</body>
</html>