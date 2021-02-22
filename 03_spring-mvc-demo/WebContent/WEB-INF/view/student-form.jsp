<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Student registration form</title>
</head>

<body>


	<h2>Spring MVC Demo - Student Form</h2>


	<form:form action="processForm" modelAttribute="student">


		First Name: <form:input path="firstName" />

		<br />
		
		
		Last Name: <form:input path="lastName" />

		<br />
		
		Country:
		
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>

		<br />
		
		Favorite Language: 
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		Python <form:radiobutton path="favoriteLanguage" value="Python" />

		<br />
		
		OS:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />
		Mac OS <form:checkbox path="operatingSystems" value="Linux" />

		<br />


		<input type="submit" />
	</form:form>
</body>
</html>