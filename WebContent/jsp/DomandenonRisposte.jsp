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
	<img class="position" src="img/logo.png" alt="StudentHelpline">
</div>
<div class="Name-Sito">
Student's Help Line
</div>
</div>
<div style="background:#2b78e4">
<p><font color="white" style="margin-left:45%"><strong>Domande non Risposte</strong><span style="margin-left:39%"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
</div>
</header>
<section id="main">
<div class="container">
  <div class="row">
    <div class="col-3">
<div class="btn-group-vertical lista-bottone">
 
<%if(session.getAttribute("tipo").equals("Studente")){%>
<a  href="MioAccount" title="Mio Account">
  <button type="button" class="MioAccount btn btn-light border border-dark" style="text-align: left;">Mio Account</button>
  </a> 
  
  	<a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="Fai_Domanda_al_Tutor btn btn-light border border-dark" style="text-align: left;">Fai Domanda al Tutor</button>
  </a>
  <%if(session.getAttribute("vis").equals("si")){ %>
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="Domande_Risposte btn btn-light border border-dark"style="width:114%;text-align: left;">Domande Risposte<img src="img/CerchioBlu.png" style="width:8%; margin-left:11%;"></img></button>
  </a>
  <%}else{ %>
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="Domande_Risposte btn btn-light border border-dark"style="width:127%;text-align: left;">Domande Risposte</button>
  </a>
	  
  <%} %>
  
  <button type="button" class="btn btn-light border border-dark" style="background-color:#cccccc; width:114%;text-align: left;">Domande senza Risposta</button>
 
  
  <%}else{%>
 <a  href="MioAccount" title="Mio Account">
<button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="width: 194%; text-align: left;font-size: 80%;">Mio Account</button>
  	</a>
  	
  	<a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:143%;text-align: left;font-size: 80%;">Domande Risposte</button>
  </a>
  
  <button type="button" class="btn btn-light border border-dark"style="background-color:#cccccc; text-align: left;font-size: 80%; width:121%;">Domande non Risposte</button>
  
  <a  href="ServletVisualizzaValutazioniTot" title="Visualizza Valutazioni">
  <button type="button" class="btn btn-light border border-dark" style="width:131%;text-align: left;font-size: 80%;">Visualizza Valutazioni</button>
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
      <%if(session.getAttribute("tipo").equals("Tutor") && testo.equals("no")){%> - Domanda da visualizzare<%}%></td>
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