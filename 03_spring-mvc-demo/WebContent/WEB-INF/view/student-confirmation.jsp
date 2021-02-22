<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Student registration form</title>
</head>

<body>


	<h2>Student Confirm</h2>


	The student is confirmed : ${student.firstName} ${student.lastName}

	<br /> Country: ${student.country}

	<br /> Favorite Language: ${student.favoriteLanguage}

	<br /> OS:

	<ul>

		<c:forEach var="temp" items="${student.operatingSystems}">


			<li>${temp}</li>

		</c:forEach>

	</ul>
</body>
</html>