<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<h1>Title<c:out value="${song.title }"></c:out></h1>
<h1>Artist<c:out value="${song.artist}"></c:out></h1>
<h1>Rating(1-10)<c:out value="${song.rating }"></c:out></h1>

<a href="/delete/song.id">delete</a>
</body>
</html>