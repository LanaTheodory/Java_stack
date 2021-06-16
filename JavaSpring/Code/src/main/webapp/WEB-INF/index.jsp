<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="color:red">
<c:out value="${error}"></c:out>
</p>
<form method="POST" action="/code">
    <p>What is the code?</p>
     <input type="text" name="code">
  
    <button>Try Code</button>
</form>
</body>
</html>