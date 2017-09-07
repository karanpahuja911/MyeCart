<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyeCart</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.w3-lobster {
    font-family: "Lobster", serif;
}
  
  
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 20px;
      border-radius: 0;
    }
    
	header {
      background-color: SlateBlue;
      padding: 2px;
    }
    .navbar-fixed-top {
min-height: 100px;
}

@media (min-width: 768px) {
.navbar {
border-radius: 4px;
min-height: 10px;
 }
}
    
    .button-custom,
.button-custom .icon:before{
  font-size: 14px;
}
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color:Teal;>
      padding: 20px;
      
     }
     
      #googleMap {
      width: 100%;
      height: 400px;
      -webkit-filter: grayscale(100%);
      filter: grayscale(100%);
  }  
     
   
  </style>
</head>
<body style="background-color:YellowGreen;">


  <div class="container text-center w3-lobster" >
  <div  font-family:"Courier New">
    <h3> Welcome To FLYING FASHION </h3>      
    <p> <b>Best Online Shopping </b></p>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">eCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Electronics</a></li>
          <li><a href="#">Home and Appliances</a></li>
          <li><a href="#">New In Clothing</a></li>
        </ul>
      </li>
      <li><a href="#">24*7 Customer Care</a></li>
    </ul>
    
      <form class="navbar-form navbar-left">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
            
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

 </body>
</html>