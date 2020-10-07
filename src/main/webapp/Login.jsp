<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enterprise-Project</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
#sel {
	margin-left: 20%;
	margin-right: 20%;
	margin-top: 5%;
}

#sel1 {
	padding: 5%;
	background: lightgreen;
	margin-left: 20%;
	margin-right: 20%;
}

#in {
	width: 80%;
}

#env {
	border: 2px solid black;
	width: 30%;
	text-align: 'center' color:white;
	background: black;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-black">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="www.xworkz.com">X-Workz</a></li>
			<li class="nav-item active"><a class="nav-link" href="Login.jsp">Login</a>
			</li>
		</ul>
	</nav>
	<h3>Welcome to The New World</h3>

	<div id="sel">
		<div id="sel1">
		
		<div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModalCenter">Add Environment Here</button>
					<div class="modal fade" id="exampleModalCenter" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalCenterTitle">Modal
										title</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times; AddEnv</span>
									</button>
								</div>
								<div class="modal-body">
<!-- 									<form action="addEnv" method="post"> -->

										<div class="form-group">
											<label>Select Environment : </label> <select name="environment" id="environment"
												class="form-control">
												<option value="DEV">Develop</option>
												<option value="SIT">SIT</option>
												<option value="UAT">UAT</option>
												<option value="PROD">Production</option>
											</select>
										</div>
										<div class="form-group">
											<label>URL : </label> <input type="text" class="form-control" name="url" id="url"/>
										</div>

										<div>
										<input type="button" class="btn btn-success" name="PostData" id="postData" value="Save" onclick="postDataFromAPI()"/>
<!-- 											<button type="submit" class="btn btn-success">Submit</button> -->
											<button type="reset" class="btn btn-danger">Cancel</button>
										</div>


<!-- 									</form> -->
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
<!-- 									<button type="submit" class="btn btn-primary">Save -->
<!-- 										changes</button> -->
								</div>
							</div>
						</div>
					</div>
				</div>
		
			<form action="login" method="post">
				<div class="form-group">
					<label>Project Name : </label> <input type="text" name="projectName"
						class="form-control" id="in" required>
				</div>

				<div class="form-group">
					<label>Team Manager: </label> <input type="text" name="TeamManagerName"
						class="form-control" id="in">
				</div>

				<div class="form-group">
					<label>Team Contact Email : </label> <input type="text"
						name="lastName" class="form-control" id="in" name="email" required>
				</div>

				<div class="form-group">
					<label for="id">De-Commissioned : </label> 
					<select  name="isDeComisioned" class="form-control" id="in" required>
					<option value="yes">Yes</option>
					<option value="no">No</option>
					</select>
				</div>
				
				

				<div class="form-group">
					<label>Developed Date : </label> <input type="text" name="developedDate"
						class="form-control" id="in">
				</div>

				<div class="form-group">
					<label>Version : </label> <input type="text" name="version"
						class="form-control" id="in">
				</div>

				<div class="form-group">
					<label>Last Release : </label> <input type="text" name="lastRelease"
						class="form-control" id="in">
				</div>

				<div class="form-group">
					<label>Next Release : </label> <input type="text" name="nextRelease"
						class="form-control" id="in">
				</div>

				<div>
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-danger">Cancel</button>
				</div>

			</form>
			
			
		</div>
	</div>
	
	<script >
	function postDataFromAPI(){
		var modelObj={ envValue:$("#environment").val(),url:$("#url").val() };
		console.log("Object is : "+modelObj);
		
		$.ajax({
			type:"POST",
			url:"/addEnv",
			headers:{
				"Content-Type":"application/json",
				"Accept":"application/json"
			},
			data:JSON.stringify(modelObj),
			success:function(data){
				console.log("Data is : "+data);
			},
			error:function(jqXHR,textStatus,errorThrown){
			}
		});
	}

	</script>

</body>
</html>