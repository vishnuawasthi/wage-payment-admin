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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
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

		<div style="margin-top: 2%" class="row">
			<div class="col-md-12">

				<div class="card">
					<div class="card-header">Personal information
					<div style="float: right">
					
					<a href="fund" class="btn btn-primary"> Fund Card </a>
					<a href="fund" class="btn btn-info"> Payment History </a>
					</div>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-2">
								<label>First Name : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.firstname } </label>
							</div>

							<div class="col-md-2">
								<label>Last Name : </label>
							</div>
							<div class="col-md-2">
							<label>${employee.lastname } </label>
							</div>

							<div class="col-md-2">
								<label>Gender : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.sex } </label>
							</div>
						</div>

						<div class="row">
							<div class="col-md-2">
								<label>Date of birth: </label>
							</div>
							<div class="col-md-2">
								<label>28/04/1989</label>
							</div>
							<div class="col-md-2">
								<label>Contact Number : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.contactNumber } </label>
							</div>

							<div class="col-md-2">
								<label>Email: </label>
							</div>
							<div class="col-md-2">
								<label>${employee.email } </label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>Social Security Number (SSN) : </label>
							</div>
							<div class="col-md-2">
								<label>55555555555 </label>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-md-12">

				<div class="card">
					<div class="card-header">Employr information</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-2">
								<label>Client Name : </label>
							</div>
							<div class="col-md-2">
								<label style="overflow-wrap: break-word">${employee.clientConfig.clientName } </label>
							</div>

							<div class="col-md-2">
								<label>Client Type : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.clientConfig .clientType} </label>
							</div>

							<div class="col-md-2">
								<label>Client Code : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.clientConfig.clientCode } </label>
							</div>
						</div>

						<div class="row">
							<div class="col-md-2">
								<label>Registration Number: </label>
							</div>
							<div class="col-md-2">
								<label>${employee.clientConfig .registrationNumber} </label>
							</div>

							<div class="col-md-2">
								<label>Email : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.clientConfig .email} </label>
							</div>

							<div class="col-md-2">
								<label>Live Date : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.clientConfig.liveDate } </label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">Postal information</div>
					<div class="card-body">
					
					<div class="row">
							<div class="col-md-2">
								<label>Plot No/Flat No.: </label>
							</div>
							<div class="col-md-2">
								<label>${employee.addressLine1 }</label>
							</div>

							<div class="col-md-2">
								<label>Street No/Line No. : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.addressLine2 }</label>
							</div>

							<div class="col-md-2">
								<label>Pincode: </label>
							</div>
							<div class="col-md-2">
								<label>${employee.pincode } </label>
							</div>
						</div>
					
					<div class="row">
							<div class="col-md-2">
								<label>State: </label>
							</div>
							<div class="col-md-2">
								<label>${employee.stateCode }</label>
							</div>

							<div class="col-md-2">
								<label>Country : </label>
							</div>
							<div class="col-md-2">
								<label>${employee.countryCode }</label>
							</div>
					</div>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>