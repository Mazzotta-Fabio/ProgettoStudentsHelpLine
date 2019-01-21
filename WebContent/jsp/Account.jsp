<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<img class="position" src="img/logo.png" alt="StudentHelpline">
</div>
<div class="Name-Sito">
Student's Help Line
</div>
</div>
<div style="background:#2b78e4">
<p><font color="white" style="margin-left:45%"><strong>
<%if(session.getAttribute("tipo").equals("Studente")){%>
Account Studente
<%}else{%>
Account Tutor
<%} %>
</strong><span style="margin-left:41%"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
</div>
</header>
<section id="main">
<div class="container">
  <div class="row">
  <div class="col">
<div class="btn-group-vertical lista-bottone">
 
  <%if(session.getAttribute("tipo").equals("Studente")){%>
  
  <%if(session.getAttribute("vis").equals("si")){ %>
  <button type="button" id = "ButtomMioAccount" class="testoSinistra MioAccount btn btn-light border border-dark" style="width:79%;background-color:#cccccc;text-align: left;">Mio Account</button>
  
  <a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="testoSinistra Fai_Domanda_al_Tutor btn btn-light border border-dark" style="text-align: left;">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="testoSinistra Domande_Risposte btn btn-light border border-dark"  style="width:79%;text-align: left;">Domande Risposte <img src="img/CerchioBlu.png" style="width:8%; margin-left:11%;"></img></button>
  </a>
  <%}else{ %>
  <button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="background-color:#cccccc; text-align: left;">Mio Account</button>
  
  <a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="testoSinistra Fai_Domanda_al_Tutor btn btn-light border border-dark" style="text-align: left;">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="testoSinistra Domande_Risposte btn btn-light border border-dark" style = "text-align: left;">Domande Risposte</button>
  </a>
 <%} %>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande senza Risposta">
  <button type="button" class="testoSinistra btn btn-light border border-dark" style="text-align: left;">Domande senza Risposta</button>
  </a>
  
  <%}else{%>
  
  <%if(session.getAttribute("vis").equals("si")){ %>
 <button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style=" width:75%; background-color:#cccccc;text-align: left;font-size: 80%;">Mio Account</button>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:144%;text-align: left;font-size: 80%;">Domande Risposte</button>
  </a>
  
   
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:75%;text-align: left;font-size: 80%;">Domande non Risposte <img src="img/CerchioBlu.png" style="width:8%; margin-left:9%;"></img></button>
  </a>
  <%} else{ %>
<button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="width: 121%; background-color:#cccccc;text-align: left;font-size: 80%;">Mio Account</button>
  	
  	<a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:144%;text-align: left;font-size: 80%;">Domande Risposte</button>
  </a>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande non Risposte">
  <button type="button" class="btn btn-light border border-dark"style="text-align: left;font-size: 80%; width:121%;">Domande non Risposte</button>
  </a>
   <%} %>
  
  <a  href="ServletVisualizzaValutazioniTot" title="Visualizza Valutazioni">
  <button type="button" class="btn btn-light border border-dark" style="width:131%;text-align: left;font-size: 80%;">Visualizza Valutazioni</button>
  </a>
  
  <%}%>
</div>
</div>
<div class="col-3" style="margin-right:5%;">
<div class="image-profilo">
<%String img = (String) request.getAttribute("Immagine");
if(img.equals("")){ %>
<img src="img/AccountsenzaFoto.png" alt="Immagine" class="img-thumbnail image-profilo">
<%}else{ %>
<img src="img/<%=img%>" alt="Immagine" class="img-thumbnail image-profilo">
<%} %>
</div>
</div>
<div class="col-5" style="margin-top:6%;">
<table class="table table-bordered">
  <thead>
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
<a  href="ServletFormModifica.html" title="Modifica Account">
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
<form action="EliminaAccount" method="get" name="elimina"></form>
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#delete").click(function(){
	  var x = confirm("Vuoi davvero eliminare l'account?");  
		if(x == true){
			document.elimina.submit();
			alert("Account eliminato");
		}
	});
});
</script>
</body>
</html>