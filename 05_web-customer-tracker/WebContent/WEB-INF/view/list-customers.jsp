<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>


<head>
<title>List Customers</title>


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>


<body>




	<div id="wrapper">

		<div id="header">

			<h2>List Customers</h2>

		</div>

	</div>


	<div id="container">

		<div id="content">


			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button"/>

			<table>

				<tr>

					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>

				</tr>


				<c:forEach var="customer" items="${customers}">


					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
					</tr>


					<%-- 			<LI>${CUSTOMER.LASTNAME} ${CUSTOMER.EMAIL} --%>
					<%-- 				<A HREF="DELETE?CUSTOMERID=${CUSTOMER.ID}">DELETE</A> --%>
					<!-- 			</LI> -->

				</c:forEach>

			</table>


		</div>

	</div>

</body>
</html>