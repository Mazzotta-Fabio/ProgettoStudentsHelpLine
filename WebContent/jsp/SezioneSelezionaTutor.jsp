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
		<%List<String> listaT= (List<String>) request.getAttribute("listaTutor");
  		Tutor t = (Tutor) listaT.get(i);
  		while(!listaTutor.isEmpty()){
  		if (t.getMateriaDiCompetenza() == materia){
		t.getNome();
		t.getCognome();%>
			
		  <div class="col-xs-12 col-sm-6 col-md-3">
		  <div class="container img-thumbnail">
		  <a style="text-decoration:none"">
		  <img class="img-responsive"  src="<%=t.getLinkImmagine()%>">
		  <span class="text"><font color="black"><%=t.getNome()%></font></span><br>
		  <span class="text"><font color="black"><%=t.getCognome%></font></span><br>
		  <center><input type="submit" value="FAI DOMANDA" id="log"name="button"><br><br></center>
			
			
		 </a>
		  </div>
		  </div>
		  
		  
	
	</div>
</div>
</body>
</html>