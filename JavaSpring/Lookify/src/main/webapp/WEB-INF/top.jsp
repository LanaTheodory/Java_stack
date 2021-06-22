<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>top ten songs</title>
</head>
<body>
<h1>top ten songs:</h1>
<a href="/dashboard">Dashboard</a>

        <c:forEach items="${top}" var="song">
        <p>
          <c:out value="${song.rating}"/> - 
            <a href="/song/show/${song.id}"><c:out value="${song.title}"/></a>
            <c:out value="${song.artist}"/>
     
        </p>
         </c:forEach>

</body>
</html>