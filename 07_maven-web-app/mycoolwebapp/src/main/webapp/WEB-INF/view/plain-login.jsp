<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

<title>Custom Login</title>

</head>


<body>


	<h3>My Custom Login</h3>


	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<c:if test="${param.error != null}">
			<i>Sorry! Invalid Credentials </i>
		</c:if>



		<c:if test="${param.logout != null} ">
			<i>You have been logged out</i>
		</c:if>


		<p>

			Username: <input type="text" name="username" />
		</p>

		<p>

			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />
	</form:form>

</body>
</html>