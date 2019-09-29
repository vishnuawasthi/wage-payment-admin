<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Search Employees</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/portal.js"></script>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

.inout-box {
	width: 50% !important;
}

.error-message {
	color: red;
	font-weight: 200;
	font-family: serif;
}

input[type=text] {
	width: 130px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-image: url('searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
	width: 100%;
}

.hideextra {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!--  Header Section -->
				<%@ include file="header.html"%>
			</div>
		</div>
		<%@ include file="searchEmployeePops.jsp"%>

		<div class="row" align="center">
			<div class="col-lg-12">
				<table class="table table-hover">
					<%-- <caption>
					<h2>List of clients</h2>
				</caption> --%>
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th class="hideextra" scope="col">FIRST NAME</th>
							<th class="hideextra" scope="col">LAST NAME</th>
							<th scope="col">SEX</th>
							<th scope="col">EMAIL</th>
							<th class="hideextra" scope="col">CONTACT NUMBER</th>
						<!--<th class="hideextra" scope="col">PLOT NO/FLAT NO.</th>
							<th class="hideextra" scope="col">STREET NO/LINE NO.</th> -->
					<!-- 	<th scope="col">PINCODE</th> -->
							<th scope="col">STATE</th>
							<th scope="col">COUNTRY</th>
							<th scope="col">ACTION</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="employee" items="${employeeList}">
							<tr>
								<td scope="row"><c:out value="${employee.id}" /></td>
								<td><c:out value="${employee.firstname}" /></td>
								<td><c:out value="${employee.lastname}" /></td>
								<td><c:out value="${employee.sex}" /></td>
								<td><c:out value="${employee.email}" /></td>

								<td><c:out value="${employee.contactNumber}" /></td>
						<%-- 	<td><c:out value="${employee.addressLine1}" /></td>
								<td><c:out value="${employee.addressLine2}" /></td>
								<td><c:out value="${employee.pincode}" /></td> --%>

								<td><c:out value="${employee.stateCode}" /></td>
								<td><c:out value="${employee.countryCode}" /></td>
								<td><a href="edit-client?id=${employee.id}">Edit</a></td>
							</tr>
						</c:forEach>

						<tr>
							<td style="text-align: right;" colspan="12">Total Records :
								&nbsp;<c:out value="${employeeList.size() }"></c:out>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>
