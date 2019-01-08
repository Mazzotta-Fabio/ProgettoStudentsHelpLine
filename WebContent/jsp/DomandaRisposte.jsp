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
<title>Domande Risposte</title>
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
Domande Risposte
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
 
<%if(session.getAttribute("tipo").equals("Studente")){%>
<a  href="ServletFormModifica" title="Mio Account">
  <button type="button" class="MioAccount btn btn-light border border-dark">Mio Account</button>
  </a> 
  
  	<a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="Fai_Domanda_al_Tutor btn btn-light border border-dark">Fai Domanda al Tutor</button>
  </a>
  
  <button type="button" class="Domande_Risposte btn btn-light border border-dark"style="background-color:#cccccc; width:114%;">Domande Risposte</button>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande senza Risposta">
  <button type="button" class="btn btn-light border border-dark" style="width:114%;">Domande senza Risposta</button>
  </a>
  
  <%}else{%>
  <a  href="ServletFormModifica" title="Mio Account">
  <button type="button" class="MioAccount btn btn-light border border-dark" style="width:166%;">Mio Account</button>
  </a> 
  <button type="button" class="Domande_Risposte btn btn-light border border-dark" style="background-color:#cccccc; width:108%;">Domande Risposte</button>
  <%if(session.getAttribute("vis").equals("si")){%>
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande non Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:108%;">Domande non Risposte<img src="img/CerchioBlu.png" style="width:5%;"></img></button>
  </a>
  <%}else{ %>
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande non Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:108%;">Domande non Risposte</button>
  </a>
  <%} %>
  
  <a  href="ServletVisualizzaValutazioniTot" title="Visualizza Valutazioni">
  <button type="button" class="btn btn-light border border-dark" style="width:109%;">Visualizza Valutazioni</button>
  </a>
  
  <%}%>
  </div>
</div>
  <div class="col-8" style="margin-top:6%;">
<table class="table">
  <thead>
  <tr>
      <th>Nome Studente</th>
      <th style="width:60%;">Oggetto-Testo Domanda</th>
    </tr>
   </thead>
   <tbody>
  <%
  List<String> listaDomande = (List<String>) request.getAttribute("listaDomande");
  int i = 0;
  while(listaDomande.size()> i){
	 String id=listaDomande.get(i);
	 i++;
	 String oggetto = listaDomande.get(i);
	 i++;
	 String testo = listaDomande.get(i);
	 i++;
	 String email = listaDomande.get(i);
	 i++;%>
      <tr>
      <td><%=email%></td>
      <td><%=oggetto%>
      <%if(session.getAttribute("tipo").equals("Studente") && testo.equals("no")){%> - Risposta da visualizzare<%}%></td>
      <td><a href="ServletVisualizzaDomanda?id=<%=id%>" title="Viaulizza Domanda"><button type="button" class="btn">></button></a></td>
     </tr>
   <%}%>
    </tbody>
</table>
</div>
</div>
</div>
</section>
</div>
</body>
</html>