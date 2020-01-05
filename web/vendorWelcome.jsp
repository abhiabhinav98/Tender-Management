<%@ page isELIgnored="false"%>
<html>
<head>
<title>Tender Management System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
div.wrapper {
    text-align: left;
    border-style: outset;
}

.button {
    position: absolute;
    top: 50%;
}
</style>
</head>
<body style="background-color:coral">
<header style="background-color:black;width:100%;height:60px;color:red;text-alignment:center;"><h1>Tender Management</h1></header>
<nav class="navbar" style="background-color:black;margin-top:10px;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Tender</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Document</a></li>
      <li><a href="#">Gallery</a></li>
      <li><a href="#">AboutUs</a></li>
    </ul>
  </div>
</nav>
<div style="color:yellow;font-size:50px;">
<strong>
	${msg}
</strong>
</div>	
	
<div  class="wrapper" >
<ul>
<li><a href="viewTenderByVendor"><button class="btn btn-success" >View All Tenders</button></a>
<li><a href="viewTenderById.jsp"><button class="btn btn-success" >Search Tender By Id</button></a>
<li><a href="viewBidsVendor"><button class="btn btn-success" >My Bids</button></a>

</ul>
</div>

</body>
</html>