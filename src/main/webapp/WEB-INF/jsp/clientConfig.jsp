<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Client Configuration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

		<!-- <div class="row">
			<div class="col-lg-12">
			<ul>
			<li>Home </li>
			
			<li>Client Configuration </li>
			</ul>
			
			</div>
		</div> -->

		<div style="margin-top: 2%;" class="row">

			<div class="col-lg-8">
				<%-- <c:if test="${not empty feedBackMsg}">
				</c:if> --%>

				<c:choose>
					<c:when test="${status == 'SUCCESS' }">
						<div
							style="color: green;padding: 10px; font-size-adjust: 16;background: ${colorValue}">${feedBackMsg }</div>
					</c:when>
					<c:otherwise>
						<div
							style="color: white;padding: 10px; font-size-adjust: 16;background: ${colorValue}">${ feedBackMsg}</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>

		<div style="margin-top: 2%;" class="row">

			<div class="col-lg-8">

				<form:form method="POST" action="client-config"
					modelAttribute="clientConfigDTO">

					<div class="form-group">
						<label for="clientName">Client Name</label>
						<form:input path="clientName" type="text"  maxlength="100"
							class="form-control inout-box" id="clientName"
							placeholder="CLIENT NAME" />
						<form:errors class="error-message" path="clientName" />
					</div>

					<div class="form-group">
						<label for="registrationNumber">Registered Name</label>
						<form:input path="registrationNumber" type="text"  maxlength="100"
							class="form-control inout-box" id="registrationNumber"
							placeholder="Registration Number" />
						<form:errors class="error-message" path="registrationNumber">
						</form:errors>
					</div>

					<div class="form-group">
						<label for="clientType">Client Type</label>
						<%-- <form:input path="clientType" type="text"
							class="form-control inout-box" id="clientCode"
							placeholder="CLIENT TYPE" /> --%>
							
							<form:select class="form-control inout-box" 
							items="${clientTypes}" itemLabel="typeName" itemValue="typeCode"
							path="clientType">
						</form:select>	
							
						<form:errors class="error-message" path="clientType"></form:errors>
					</div>

					<div class="form-group">
						<label for="contactNumber">Contact Number</label>
						<form:input path="contactNumber" type="text"
							class="form-control inout-box" id="contactNumber"
							placeholder="CONTACT NUMBER" />
						<form:errors class="error-message" path="contactNumber"></form:errors>
					</div>

					<div class="form-group">
						<label for="contactNumber">Email</label>
						<form:input path="email" type="text"
							class="form-control inout-box" id="email" placeholder="EMAIL" />
						<form:errors class="error-message" path="email"></form:errors>
					</div>

					<div class="form-group">
						<label for="clientCode">Client Code</label>
						<form:input path="clientCode" type="text"
							class="form-control inout-box" id="clientCode"
							placeholder="Cleint Code" />
						<form:errors class="error-message" path="clientCode"></form:errors>
					</div>

					<div class="form-group">
						<label for="addressLine1">Address Line 1</label>
						<form:input path="addressLine1" type="text"
							class="form-control inout-box" id="addressLine1"
							placeholder="ADDRESS LINE 1" />
						<form:errors class="error-message" path="addressLine1"></form:errors>
					</div>

					<div class="form-group">
						<label for="addressLine2">Address Line 2</label>
						<form:input path="addressLine2" type="text"
							class="form-control inout-box" id="addressLine2"
							placeholder="ADDRESS LINE 2" />
						<form:errors class="error-message" path="addressLine2"></form:errors>
					</div>

					<div class="form-group">
						<label for="pincode">Pincode </label>
						<form:input path="pincode" type="text" maxlength="6"
							class="form-control inout-box" id="pincode" placeholder="PINCODE" />
						<form:errors class="error-message" path="pincode"></form:errors>
					</div>

					<div class="form-group">
						<label for="stateCode">State</label>
						<%-- <form:input path="stateCode" type="text"
							class="form-control inout-box" id="stateCode"
							placeholder="STATE CODE" /> --%>

						<form:select class="form-control inout-box" 
							items="${states}" itemLabel="stateName" itemValue="stateCode"
							path="stateCode">
						</form:select>
						<form:errors class="error-message" path="stateCode"></form:errors>
					</div>

					<%-- <div class="form-group">
						<label for="exampleFormControlInput1">COUNTRY</label>
						<form:input path="coutryCode" type="text"
							class="form-control inout-box" id="coutryCode"
							placeholder="COUNTRY CODE" />
						<form:errors class="error-message" path="coutryCode"></form:errors>
					</div> --%>

					<label for="exampleFormControlInput1">COUNTRY</label>
					<form:select class="form-control inout-box" title="SELECT COUNTRY"
						items="${countries}" itemLabel="countryName"
						itemValue="countryCode" path="coutryCode">
					</form:select>

					<%-- <form:options  itemValue="countryCode"   items="${countries}" itemLabel="countryName"/> --%>
					<form:errors class="error-message" path="coutryCode"></form:errors>

					<div style="margin-top: 10px;" class="form-group">
						<input type="reset" value="Reset"> &nbsp; &nbsp; <input
							type="submit" value="Save">
					</div>

					<!-- <div class="form-group">
						<label for="exampleFormControlSelect1">Example select</label> <select
							class="form-control" id="exampleFormControlSelect1">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect2">Example multiple
							select</label> <select multiple class="form-control"
							id="exampleFormControlSelect2">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Example textarea</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3"></textarea>
					</div> -->
				</form:form>
			</div>
			<!-- <div class="col-lg-4">
			
			
			</div> -->
		</div>
	</div>
</body>
</html>