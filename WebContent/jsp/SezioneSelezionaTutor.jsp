<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/SelezionaMateria.css">
<link rel="icon" type="image" href="../img/ICONA.ico">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">


<style>
.footer {
  position: fixed;
  width: 100%;
  bottom: 0px;
  text-align: center;
  background: #2b78e4;
  color: white;
  font-size: 20px;
}
</style>
<title>STUDENT'S HELP LINE</title>
</head>
<body>
<div id="page">
<header id=header">
<div class="header-content">
<div class="image-logo">
	<img class="position" src="../img/logo.jpg" alt="StudentHelpline">
</div>
<div class="Name-Sito">
Student's Help Line
</div>
</div>
<nav class="navbar navbar-custom">
<div class="Name-barra">
<center>SELEZIONA TUTOR</center>
</div>
<a  href="/" title="Logout">
<img class="log" src="../img/logout.svg"></img>
</a>
</nav>
</div>
</header>
<div class="footer">
<h1>STUDENT'S HELP LINE. SEE MORE. DO MORE.</h1>
</div>
		
		<div class="row">
		<div class="col-xs-12 col-sm-6 col-md-3">
		  <div class="container img-thumbnail">
		  <a style="text-decoration:none"">
		<% 
		List <String> listaTutor= (List) request.getAttribute("listaTutor");
		iterator it= listaTutor.iterator();
		for(int i=0; i< listaTutor.lenght;i++){
			out.println("<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-3">
			  <div class="container img-thumbnail">
			  <a style="text-decoration:none""><span class="text"><font color="black"><%it.next();%></font></span><br>  <center><input type="submit" value="FAI DOMANDA" id="log"name="button"><br><br></center>")
			} %>
			
			</a>
		  </div>
		  </div>
		  
		  
	
	</div>
</div>
</body>
</html>