<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Alfonso Golino">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image" href="img/ICONA.ico">
<link rel="stylesheet" href="css/domande_Risposte-non_Risposte.css">
<link rel="stylesheet" href="css/Account.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Visualizza Valutazioni</title>
</head>
<body>
<div id="page">
<header id=header">
<div class="header-content">
<div class="image-logo">
	<img class="position" src="img/logo.jpg" alt="StudentHelpline">
</div>
<div class="Name-Sito">
Student's Help Line
</div>
</div>
<nav class="navbar navbar-custom">
<div class="Name-barra" style="margin-left:44%;">
Visualizza Valutazioni
</div>
<a  href="Logout" title="Logout">
<img class="log" src="img/logout.svg"></img>
</a>
</nav>
</header>
<section id="main">
<div class="container">
  <div class="row">
    <div class="col-3">
<div class="btn-group-vertical lista-bottone">
 <%if(session.getAttribute("vis").equals("si")){ %>
  <a  href="ServletFormModifica" title="Mio Account">
  <button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="width:199%;">Mio Account</button>
  </a>
  	<a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:145%;">Domande Risposte</button>
  </a>
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:130%;">Domande non Risposte    <img src="img/CerchioBlu.png" style="width:10%;"></img></button>
  </a>
  <button type="button" class="btn btn-light border border-dark" style="background-color:#cccccc; width:130%;">Visualizza Valutazioni</button>
   <%}else{ %>
 <a  href="ServletFormModifica" title="Mio Account">
  <button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="width:166%;">Mio Account</button>
  	</a>
  	
  	<a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:121%;">Domande Risposte</button>
  </a>
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:108%;">Domande non Risposte</button>
  </a>
  <button type="button" class="btn btn-light border border-dark" style="background-color:#cccccc; width:108%;">Visualizza Valutazioni</button>
 <%} %>
</div>
</div>  
<div class="col-8">
<div class="row" style="margin-left:8%;">
<div class="col-4" style="margin-right:10%;">
<div style="margin-left:6%;margin-bottom:15%;font-family:sans-serif;font-size: 150%;">Like Ricevuti</div>
<img  src="img/like.png" style="width:80%;"></img>
<div style="margin-left:35%; margin-top:15%; font-family:sans-serif;font-size: 150%;"><%=request.getAttribute("like")%></div>
</div>
<div class="col-4"style="margin-left:20%;">
<div style="margin-bottom:15%; font-family:sans-serif; font-size: 150%;">Dislike Ricevuti</div>
<img src="img/dislike.png" style="width:80%;"></img>
<div style="margin-left:37%; margin-top:15%; font-family:sans-serif; font-size: 150%;"><%=request.getAttribute("dislike")%></div>
</div>
</div>
</div>
</div>
</div>
</section>
</div>
</body>
</html>