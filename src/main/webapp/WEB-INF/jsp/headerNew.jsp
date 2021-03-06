<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
	<a class="navbar-brand" href="#">Wage Payment</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item ${homeActive}">
			<a class="nav-link" href="home-page">Home <span class="sr-only">(current)</span> </a></li>
			
			<li class="nav-item dropdown">
			
				<a class="nav-link dropdown-toggle ${clientConfigActive}" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Client Management </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="client-config">Add Client	Configuration</a>
					<a class="dropdown-item" href="search-clients">Search & Update</a>
				</div></li>
			
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle ${employeeActive}" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Employee Management </a>
				
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a   class="dropdown-item" href="employees">Add Employee</a> 
					<a   class="dropdown-item" href="#">Update Employee</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
		</li>
			
</ul>
	<!-- 	<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form> -->
	</div>
</nav>