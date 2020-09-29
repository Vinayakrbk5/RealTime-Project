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
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-black">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#" >X-Workz</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="Login.jsp" >Login</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="Success.jsp" >Observable</a>
    </li>   
  </ul>
</nav>
<h3> ${status} </h3>
${fname }
<br>
${lname }
</body>
</html>