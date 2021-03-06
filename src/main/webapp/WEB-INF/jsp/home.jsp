<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		
		
		<div style="margin-top: 1%" class="text-center">
			<h1>Wage Payment</h1>
			<p>The Aline Card is <!--by  ADP is --> a reloadable prepaid Visa card that
				provides employers and employees a convenient, low-cost alternative
				to paychecks.</p>
			<!-- <form class="form-inline">
				<div class="input-group">
					<input type="email" class="form-control" size="50"
						placeholder="Email Address" required>
					<div class="input-group-btn">
						<button type="button" class="btn btn-danger">Subscribe</button>
					</div>
				</div>
			</form> -->
		</div>
		
		<div>
		<img width="100%" alt="Aline card" src="images/aline_card_01.png">
		
		</div>
	</div>
</body>
</html>