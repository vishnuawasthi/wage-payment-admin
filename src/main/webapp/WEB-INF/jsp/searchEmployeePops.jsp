<!-- <div class="row">
	<div class="col-lg-12">
		
		<form style="margin-top: 5px;" method="get" action="search-employees">
			<input name="searchKeyWord" type="text" name="search" placeholder="Search..">
		</form>
	</div>
</div> -->

<div style="margin-top: 10px; margin-bottom: 10px" class="row">
	<div class="col-lg-12">
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">Advance employee search</button>

		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<!-- <h4 class="modal-title">Advance Search</h4> -->
					</div>
					<div class="modal-body">
						<form method="GET" action="search-employees">
							<div class="form-group row">
								<label for="id" class="col-sm-3 col-form-label">Employee Id</label>
								<div class="col-sm-8">
									<input  type="text"  class="form-control"  id="id" name="id" >
								</div>
							</div>
							<div class="form-group row">
								<label for="firstname" class="col-sm-3 col-form-label">First Name</label>
								<div class="col-sm-8">
									<input  type="text"  class="form-control"  id="firstname"  name="firstname">
								</div>
							</div>
							<div class="form-group row">
								<label for="lastname" class="col-sm-3 col-form-label">Last Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="lastname" name="lastname">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="email" class="col-sm-3 col-form-label">Email</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="email" name="email">
								</div>
							</div>
						

					</div>
					<div class="modal-footer">
						<input type="reset" class="btn btn-default" value="Reset">
						<input type="submit" class="btn btn-primary" value="Search">
					</div>
				</div>
</form>
			</div>
		</div>
	</div>
</div>