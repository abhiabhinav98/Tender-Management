<%@ page isELIgnored="false"%>
<html>
<head>
<title>Tender management system</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
@font-face {
  font-family: 'Open Sans';
  font-style: normal;
  font-weight: 400;
  src: local('Open Sans'), local('OpenSans'), url(http://themes.googleusercontent.com/static/fonts/opensans/v6/cJZKeOuBrn4kERxqtaUH3T8E0i7KZn-EPnyo3HZu7kw.woff) format('woff');
}
html{
    width: 100%;
    height: 100%;
    background: #557585;
    margin: 0;
    padding: 0;
}
*{
  font-family: 'Open Sans' !important;
  font-style: normal;
}
.login {
  position: relative;
  margin: 50px auto;
  width: 307px;
  padding: 10px;
  border-radius: 10px;
  border: 7px solid rgba(254, 254, 254, 0.6);
}
.login p.submit {
  text-align: right;
  margin-right: -2px;
  padding-top: 5px;
}
.login h1 {
  margin: -10px -10px 0 -10px;
  line-height: 40px;
  font-size: 16px;
  font-weight: bold;
  color: #555;
  text-align: center;
  text-shadow: 0 1px white;
  background: #e6e6e6;
  border-bottom: 1px solid #cfcfcf;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  -webkit-box-shadow:0 1px 6px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.05) inset;
       -moz-box-shadow:0 1px 6px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.05) inset;
            box-shadow:0 1px 6px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.05) inset;

}
.login form{
  padding: 10px 10px 10px 10px;
  margin: 0 -10px -10px -10px;
  border-bottom-right-radius:3px;
  border-bottom-left-radius: 3px;
  background-color: #f9f9f9;
  -webkit-box-shadow:0 1px 6px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.15) inset;
  -moz-box-shadow:0 1px 6px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.15) inset;
   box-shadow:0 1px 6px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.15) inset;

}
.login p {
  margin: 10px 0 0;
}
.login p.remember_me {
  float: left;
  font-size: 13px;
  color: #777;
  cursor: pointer;
}
/* Text Inputs */
input[type="text"]
    {
    width: 280px;
    color: #3e3e3e;
    display:block;
    margin-top: 5px;
    border: 1px solid #c3c3c3;
    height: 25px;
    border-radius:3px;
    padding-left: 5px;
    background: #ffffff; /* Old browsers */
    background: -moz-linear-gradient(top,  #ffffff 0%, #f7f7f7 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#f7f7f7)); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  #ffffff 0%,#f7f7f7 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  #ffffff 0%,#f7f7f7 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  #ffffff 0%,#f7f7f7 100%); /* IE10+ */
    background: linear-gradient(to bottom,  #ffffff 0%,#f7f7f7 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#f7f7f7',GradientType=0 ); /* IE6-9 */
    }
input[type="text"]:focus
   {
    border: 1px solid black;
    
    }
/* Password Text Box Styling */
input[type="date"]
    {
    width: 280px;
    color: #3e3e3e;
    display:block;
    margin-top: 5px;
    border: 1px solid #c3c3c3;
    height: 25px;
    border-radius:3px;
    padding-left: 5px;
    background: #ffffff; /* Old browsers */
    background: -moz-linear-gradient(top,  #ffffff 0%, #f7f7f7 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#f7f7f7)); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  #ffffff 0%,#f7f7f7 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  #ffffff 0%,#f7f7f7 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  #ffffff 0%,#f7f7f7 100%); /* IE10+ */
    background: linear-gradient(to bottom,  #ffffff 0%,#f7f7f7 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#f7f7f7',GradientType=0 ); /* IE6-9 */
    }
input[type="date"]:focus
   {
    border: 1px solid black;
    }
/* Button Styling */
button,
input[type="submit"],
input[type="reset"]
    {
    display:inline;
    margin-top: 0;
    border: 1px solid #999;
    height: 30px;
    line-height: 25px;
    background: #f0f0f0; /* Old browsers */
    background: -moz-linear-gradient(top,  #f0f0f0 0%, #e7e7e7 47%, #dfdfdf 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f0f0f0), color-stop(47%,#e7e7e7), color-stop(100%,#dfdfdf)); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  #f0f0f0 0%,#e7e7e7 47%,#dfdfdf 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  #f0f0f0 0%,#e7e7e7 47%,#dfdfdf 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  #f0f0f0 0%,#e7e7e7 47%,#dfdfdf 100%); /* IE10+ */
    background: linear-gradient(to bottom,  #f0f0f0 0%,#e7e7e7 47%,#dfdfdf 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f0f0f0', endColorstr='#dfdfdf',GradientType=0 ); /* IE6-9 */
    color: black;
    border-radius:3px;

    }
button:hover,
input[type="submit"]:hover
    {
    background: #f5f5f5; /* Old browsers */
    background: -moz-linear-gradient(top,  #f5f5f5 0%, #ececec 47%, #e4e4e4 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f5f5f5), color-stop(47%,#ececec), color-stop(100%,#e4e4e4)); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  #f5f5f5 0%,#ececec 47%,#e4e4e4 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  #f5f5f5 0%,#ececec 47%,#e4e4e4 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  #f5f5f5 0%,#ececec 47%,#e4e4e4 100%); /* IE10+ */
    background: linear-gradient(to bottom,  #f5f5f5 0%,#ececec 47%,#e4e4e4 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f5f5f5', endColorstr='#e4e4e4',GradientType=0 ); /* IE6-9 */
    color: black;
    }
/* CheckBox Styling */
input[type="checkbox"] 
    {
    display: none; /* hide original checkbox */
    }
/* checked style for checkbox */
input[type="checkbox"]:checked + label .box 
    { 
    position: relative;
    }
/* check */
input[type="checkbox"]:checked + label .box:after 
    {
    content: '';
    width: 8px;
    height: 4px;
    position: absolute;
    left: 3px;
    top: 2px;
    border: 1px solid #414141;
    border-top: none;
    border-right: none;
    -webkit-transform: rotate(-45deg);
    -moz-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    transform: rotate(-45deg);
    }
 /* unckecked style for checkbox */
.box 
    {
    display: inline-block;
    width: 14px;
    height: 14px;
    border-radius: 3px;
    border: 1px solid #c3c3c3;
    float: left;
    margin-right: 7px;
    margin-top: 1px;
    background-image: -moz-linear-gradient(top, #fff, #efefef);
    background-image: -webkit-linear-gradient(top, #fff, #efefef);
    background-image: -ms-linear-gradient(top, #fff, #efefef);
    background-image: linear-gradient(top, #fff, #efefef);
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
<div class="container">
  <div class="login">
    <h1>Create Tender</h1>
    <form method="post" action="createTender">
      <p><input type="text" name="tname" placeholder="Tender Name" required></p>
      <h3>OPENING DATE</h3>
					<input type="date"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Enter Date';}"
						required="" name="odate">
	<h3>OPENING TIME</h3>
					<input type="time" value="time" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'time';}" required=""
						name="otime">
					<h3>CLOSING DATE</h3>
					<input type="date" value="Date" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Enter Date';}" required=""
						name="cdate">
						<h3>CLOSING TIME</h3>
					<input type="time" value="ClosingTime" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'ClosingTime';}"
						required="" name="ctime">
					
      <p><input type="text" name="mbid" placeholder="minimum Bid" required></p>
      <p><textarea rows="5" cols="37" placeholder="Description of Tender" name="desc"></textarea></p>
      <p class="remember_me">
        <input type="checkbox" name="remember_me" id="remember_me" checked>
        <label for="remember_me"><span class="box"></span>open for all</label>
        <input type="checkbox" name="computer" id="remember_me" >
        <label for="computer"><span class="box"></span>computer</label>
        
        </p>
      <p class="submit"><input type="submit" value="submit"></p>
    </form>
  </div>
</div>
	
${msg} 

</body>
</html>