<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PopUp Data</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  #sel{
  width:80%;
  margin-left:10%;
  margin-right:10%;
  }
  
  #sel1{
  background:skyblue;
  }
  
  select,input{
  width:50%;
  }
  
  </style>
  <script type="text/javascript">

  function addEnv()
  {
	alert("Form Submitted");
  }
  </script>
</head>
<body>
<h3> Welcome to Environment</h3>

<div id="sel">
<div id="sel1">

<form action="addEnv" method="post" onSubmit="addEnv()">

<div class="form-group">
<label>Select Environment : </label>
<select name="envValue" class="form-control">
<option value="DEV">Develop</option>
<option value="SIT">SIT </option>
<option value="UAT">UAT</option>
<option value="PROD">Production</option>
</select>
</div>
<div class="form-group">
<label>URL : </label>
<input type="text" class="form-control"/>
</div>

<div>
<button type="submit" class="btn btn-success" >Submit</button>
<button type="reset" class="btn btn-danger">Cancel</button>
</div>


</form>


</div>
</div>




</body>



</html>