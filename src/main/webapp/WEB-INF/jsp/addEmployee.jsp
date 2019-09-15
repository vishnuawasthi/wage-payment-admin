<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

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

<script>
	$(function() {
		$("#onboardDateTxt").datepicker({
			/*  appendText:"(yyyy-mm-dd)",  */
			dateFormat : "yy-mm-dd",
			minDate : '0',
			autoSize : true

		/*  altField: "#datepicker-4",  
		 altFormat: "DD, d MM, yy"  */
		});
	});

	$(function() {
		$("#liveDateTxt").datepicker({
			/*  appendText:"(yyyy-mm-dd)",  */
			dateFormat : "yy-mm-dd",
			minDate : '0'
		/*  minDate: '-2' */
		/*  altField: "#datepicker-4",  
		 altFormat: "DD, d MM, yy"  */
		});
	});
</script>


</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!--  Header Section -->
				<%@ include file="header.html"%>
			</div>
		</div>

		<div style="margin-top: 2%;" class="row">
		<c:if test="${not empty status} ">
			<div class="col-lg-8">
				
				

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
			</c:if>
		</div>

<form:form  action="employees"   modelAttribute="employee"  style="margin-top: 2%">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="firstName">First Name</label> 
					<form:input type="text" path="firstname" class="form-control" id="firstName" maxlength="100" autocomplete="off" />
					<form:errors  class="error-message" path="firstname"></form:errors>
				</div>
				
				<div class="form-group col-md-6">
					<label for="lastName">Last Name</label> 
					<form:input type="text" path="lastname" class="form-control" id="lastName" maxlength="100" autocomplete="off" />
					<form:errors path="lastname" class="error-message"></form:errors>
				</div>
			</div>
				<div class="form-row">
				<div class="form-group col-md-6">
					<label for="contactNumber">Contact Number</label> 
					<form:input path="contactNumber" type="text" class="form-control" id="contactNumber" maxlength="10" />
					<form:errors path="contactNumber" class="error-message"></form:errors>
				</div>
				<div class="form-group col-md-6">
					<label for="email">Email</label> 
					<form:input path="email"  type="text" class="form-control" id="email" maxlength="100" />
					<form:errors path="email" class="error-message" ></form:errors>
				</div>
				
				</div>
			<div class="form-group">
			<label for="inputState">Client Name</label> 
			<form:select class="form-control"
						items="${clientConfigList}" itemLabel="clientName"
						itemValue="clientCode" path="clientCode">
			</form:select>	
				
			<form:errors path="clientCode" class="error-message"></form:errors>
			</div>
			
			<div class="form-group">
				 <label for="addressLine1">AddressLine1</label>
				 <form:input type="text" path="addressLine1"  class="form-control" id="addressLine1" maxlength="100" />
				 <form:errors path="addressLine1" class="error-message"></form:errors>
			</div>
			
			<div class="form-group">
				<label for="addressLine2">AddressLine2</label> 
				<form:input type="text" path="addressLine2" class="form-control" id="addressLine2" maxlength="100" />
				<form:errors path="addressLine2" class="error-message"></form:errors>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="pincode">Pincode</label> 
					<form:input  path="pincode"  type="text" class="form-control" id="pincode" maxlength="6" />
					<form:errors path="pincode" class="error-message"></form:errors>
				</div>
				
				<div class="form-group col-md-4">
						<label for="stateCode">State</label>
						<%-- <form:input path="stateCode" type="text"
							class="form-control inout-box" id="stateCode"
							placeholder="STATE CODE" /> --%>

						<form:select class="form-control " items="${states}"
							itemLabel="stateName" itemValue="stateCode" path="stateCode">
						</form:select>
						<form:errors class="error-message" path="stateCode"></form:errors>
					
					
				</div>
				<div class="form-group col-md-4">
					<label for="exampleFormControlInput1">COUNTRY</label>
					<form:select class="form-control " title="SELECT COUNTRY"
						items="${countries}" itemLabel="countryName"
						itemValue="countryCode" path="countryCode">
					</form:select>
					<form:errors class="error-message" path="countryCode"></form:errors>
				</div>
			</div>
			<!-- <div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Check me
						out </label>
				</div>
			</div> -->
			<input type="reset" style="border: 1px solid;" class="btn btn-default" value="Reset">
			&nbsp; &nbsp;
			<input type="submit" class="btn btn-primary" value="Save">
		</form:form>

	</div>
</body>
</html>