<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Alfonso Golino">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image" href="img/ICONA.ico">
<link rel="stylesheet" href="css/Account.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Account</title>
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
<div class="Name-barra" style="margin-left:40%;">
<%if(session.getAttribute("tipo").equals("Studente")){%>
Account Studente
<%}else{%>
Account Tutor
<%} %>
</div>
<a  href="Logout" title="Logout">
<img class="log" src="img/logout.svg"></img>
</a>
</nav>
</header>
<section id="main">
<div class="container">
  <div class="row">
  <div class="col">
<div class="btn-group-vertical lista-bottone">
 
  <button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="background-color:#cccccc;">Mio Account</button>
 
  <%if(session.getAttribute("tipo").equals("Studente")){%>
  	<a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="Fai_Domanda_al_Tutor btn btn-light border border-dark">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="Domande_Risposte btn btn-light border border-dark">Domande Risposte</button>
  </a>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande senza Risposta">
  <button type="button" class="btn btn-light border border-dark">Domande senza Risposta</button>
  </a>
  
  <%}else{%>
  	<a  href="ServletTabDomandaRisposte" title="Fai Domanda al Tutor">
  <button type="button" class="btn btn-light border border-dark">Domande Risposte</button>
  </a>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark">Domande non Risposte</button>
  </a>
  
  <a  href="ServletVisualizzaValutazioniTot" title="Visualizza Valutazioni">
  <button type="button" class="btn btn-light border border-dark">Visualizza Valutazioni</button>
  </a>
  
  <%}%>
</div>
</div>
<div class="col-4">
<div class="image-profilo">
<%String img = (String) request.getAttribute("Immagine");
if(img != null){ %>
<img src="img/AccountsenzaFoto.png" alt="Immagine" class="img-thumbnail image-profilo">
<%}else{ %>
<img src=<%=img%> alt="Immagine" class="img-thumbnail image-profilo">
<%} %>
</div>
</div>
<div class="col-5">
<div class="info">
<table class="table table-bordered">
  <thead>
  <tr>
      <th scope="col">info</th>
    </tr>
   </thead>
   <tbody>
   <tr>
      <th scope="row"class="border border-dark">email</th>
      <td><%=session.getAttribute("email")%></td>
     </tr>
  <%if(session.getAttribute("tipo").equals("Studente")){%>
    <tr>
      <th scope="row"class="border border-dark">Nome</th>
      <td><%=request.getAttribute("Nome")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Cognome</th>
      <td><%=request.getAttribute("Cognome")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Matricola</th>
      <td><%=request.getAttribute("Matricola")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Anno</th>
      <td><%=request.getAttribute("Anno")%></td>
     </tr>
   <%}else{ %>
   	<tr>
      <th scope="row"class="border border-dark">Nome</th>
      <td><%=request.getAttribute("Nome")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Cognome</th>
      <td><%=request.getAttribute("Cognome")%></td>
     </tr>
   <tr>
      <th scope="row"class="border border-dark">Materia</th>
      <td><%=request.getAttribute("Materia")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Cellulare</th>
      <td><%=request.getAttribute("Cellulare")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Titolo</th>
      <td><%=request.getAttribute("Titolo")%></td>
     </tr>
     <tr>
      <th scope="row"class="border border-dark">Voto</th>
      <td><%=request.getAttribute("Voto")%></td>
     </tr>
   <%} %>
  </tbody>
</table>
<a  href="ServletFormModifica" title="Modifica Account">
<button type="button" class="btn btn-light border border-dark">Modifica Account</button>
</a>
<span class="position-bottom">
<a href="" title="Elimina Account">
<button type="button" id="delete" class="btn btn-light border border-dark">Elimina Account</button>
</a>
</span>
</div>
</div>
</div>
</div>
</section>
</div>
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#delete").click(function(){
	  var x = confirm("Vuoi davvero eliminare l'account?");  
		if(x == true){
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("GET","EliminaAccount" , true);
			xmlhttp.send();
		}
	});
});
</script>
</body>
</html>