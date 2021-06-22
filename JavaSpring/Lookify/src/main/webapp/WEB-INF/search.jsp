<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search result</title>
</head>
<body>
<nav>
<p>Search for artist: <c:out value="${artist}"></c:out></p>
<form:form action="/search" modelAttribute="song">
<p>
<form:input placeholder="${artist}" path="artist"/>
<form:errors path="artist"/>
 <input type="submit" value="new Search"/>
 </p>
</form:form>    

<a href="/dashboard">Dashboard</a>  
</nav>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ArtistSongs}" var="song">
        <tr>
            <td><a href="/languages/show/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
           
            <td><a href="/delete/${song.id}">delete</a></td>
     
            
        </tr>
         </c:forEach>
             </tbody>
</table>

</body>
</html>