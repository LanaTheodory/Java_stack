<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Registration Page</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col">
	<h1>Register!</h1>
	<p>
		<c:out value="${error}" />
	</p>
	<p>
		<form:errors path="user.*" />
	</p>

	<form:form method="POST" action="/registration" modelAttribute="user">
		<p>
			<form:label path="firstName">first name:</form:label>
			<form:input path="firstName" />

		</p>
		<p>
			<form:label path="lastName">last name:</form:label>
			<form:input path="lastName" />

		</p>
		<p>
			<form:label path="email">Email:</form:label>
			<form:input type="email" path="email" />

		</p>
		<p>
			<form:select path="state">
				<c:forEach items="${states}" var="p">
					<form:option value="${ p.id }">${ p.name }</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
		</p>
		<p>
			<form:label path="passwordConfirmation">Password Confirmation:</form:label>
			<form:password path="passwordConfirmation" />
		</p>
		<input type="submit" value="Register!" />
	</form:form>
	</div>
	
	
	<div class="col">
	
	
	 <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>    
	
	
	
	</div>
	</div>
 </div>
</body>
</html>