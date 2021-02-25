<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<title>Company Home Page</title>

</head>


<body>

	<h2>Company Home Page</h2>


	<br />

	<p>Home page for my company</p>



	<hr>


	<p>
		User:
		<security:authentication property="principal.username" />
	</p>

	<br>
	<br>
	<p>
		Role(s):
		<security:authentication property="principal.authorities" />
	</p>
	<hr>



	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>