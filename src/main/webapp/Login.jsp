<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enterprise-Project</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  #sel{
  margin-left:20%;
  margin-right:20%;
  margin-top:5%;
  }
  #sel1{
  padding:5%;
  background:lightgreen;
  margin-left:20%;
  margin-right:20%;
  }
  #in{
  width:80%;
  }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-black">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="www.xworkz.com" >X-Workz</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="Login.jsp" >Login</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="Success.jsp" >success</a>
    </li>  
  </ul>
</nav>
<h3>Welcome to The New World </h3>

<div id="sel">
<div id="sel1">
<form action="login" method="post">
<div class="form-group">
<label>Enter First Name : </label>
<input type="text" name="firstName" class="form-control" id="in">
</div>

<div class="form-group">
<label>Enter Last Name : </label>
<input type="text" name="lastName" class="form-control" id="in">
</div>

<div>
<button type="submit" class="btn btn-success">Submit</button>
<button type="reset" class="btn btn-danger">Cancel</button>
</div>

</form>
</div>
</div>
</body>
</html>