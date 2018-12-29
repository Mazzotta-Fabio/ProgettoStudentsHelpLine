<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Alfonso Golino">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image" href="../img/ICONA.ico">
<link rel="stylesheet" href="../css/domande_Risposte-non_Risposte.css">
<link rel="stylesheet" href="../css/Account.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<title>Domande Risposte</title>
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
Domande Risposte
</div>
<a  href="../Logout" title="Logout">
<img class="log" src="../img/logout.svg"></img>
</a>
</nav>
</header>
<section id="main">
<div class="container">
  <div class="row">
    <div class="col-3">
<div class="btn-group-vertical lista-bottone">

  <a  href="/" title="Mio Account">
  <button type="button" class="btn btn-light border border-dark">Mio Account</button>
  </a>
  <!--COMMENTO DA TOGLIERE  
  <%//if(session.getAttribute("username") == "Studente"){%>
  	<a  href="/" title="Fai Domanda al Tutor">
  <button type="button" class="btn btn-light border border-dark">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="/" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark">Domande Risposte</button>
  </a>
  
  <a  href="/" title="Domande senza Risposta">
  <button type="button" class="btn btn-light border border-dark">Domande senza Risposta</button>
  </a>
  
  <%//}else{%>
  	<a  href="/" title="Fai Domanda al Tutor">
  <button type="button" class="btn btn-light border border-dark">Domande Risposte</button>
  </a>
  
  <a  href="/" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark">Domande non Risposte</button>
  </a>
  
  <a  href="/" title="Domande senza Risposta">
  <button type="button" class="btn btn-light border border-dark">Visualizza Valutazioni</button>
  </a>
  
  <%//}%>-->
  </div>
</div>
  <div class="col-8">
  <div class="domande_Risposte-non">
<table class="table table-bordered">
  <thead>
  <tr>
      <th scope="col" class ="tabella_nome">Nome Studente</th>
      <th scope="col">Oggetto Domanda</th>
    </tr>
   </thead>
   <tbody>
  <%/* 
  List<String> listaDomande = (List<String>) request.getAttribute("listaDomande");
  int i = 0;
  while(!listaDomande.isEmpty()){
	 i++;
	 String oggetto = listaDomande.get(i);
	 i += 2;
	 String nome = listaDomande.get(i);
	 i++;
	 String cognome = listaDomande.get(i);*/%>
<!--COMMENTO DA TOGLIERE     <tr class="selezionare">
      <td class="border border-dark"><%//nome %> <%//cognome %></td>
      <td><%//oggetto%></td>
     </tr>-->
   <%
   //}%>
   <tr class="selezionare">
   <td class="border border-dark"><a href="/" title="Domanda" class="testo-domanda">Sono stronzo</a></td>
      <td><a href="/" title="Domanda" class="testo-domanda">cazzo vuoi</a></td>
     </tr>
     <tr class="selezionare">
   <td class="border border-dark"><a href="/" title="Domanda" class="testo-domanda">Sono stronzo</a></td>
      <td><a href="/" title="Domanda" class="testo-domanda">cazzo vuoi</a></td>
     </tr>
    </tbody>
</table>
</div>
</div>
</div>
</div>
</section>
</div>
</body>
</html>