<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Enumeration;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Alfonso Golino">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image" href="../img/ICONA.ico">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/Account.css">
<title>Account</title>
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
<%if(session.getAttribute("tipo") == "Studente"){%>
Account Studente
<%}else{%>
Account Tutor
<%} %>
</div>
<a  href="/Logout.html" title="Logout">
<img class="log" src="../img/logout.svg"></img>
</a>
</nav>
</div>
</header>
<section id="main">
<div class="container">
  <div class="row">
  <div class="col">
<div class="btn-group-vertical lista-bottone">
<!-- li devi far visualizzare dinamicamente 
<button type="button" class="btn btn-light border border-dark">Cerca Tutor</button>
<button type="button" class="btn btn-light border border-dark">Fai Domanda al Tutor</button>-->
  <a  href="/" title="Mio Account">
  <button type="button" class="btn btn-light border border-dark">Mio Account</button>
  </a>
  <%if(session.getAttribute("username") == "Studente"){%>
  	<a  href="/" title="Fai Domanda al Tutor">
  <button type="button" class="btn btn-light border border-dark">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="/" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark">Domande Risposte</button>
  </a>
  
  <a  href="/" title="Domande senza Risposta">
  <button type="button" class="btn btn-light border border-dark">Domande senza Risposta</button>
  </a>
  
  <%}else{%>
  	<a  href="/" title="Fai Domanda al Tutor">
  <button type="button" class="btn btn-light border border-dark">Domande Risposte</button>
  </a>
  
  <a  href="/" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark">Domande non Risposte</button>
  </a>
  
  <a  href="/" title="Domande senza Risposta">
  <button type="button" class="btn btn-light border border-dark">Visualizza Valutazioni</button>
  </a>
  
  <%}%>
  <!-- gli altri bottoni li devi fare dinamucamente -->
</div>
</div>
<div class="col-4">
<div class="image-profilo">
<img src="../img/AccountsenzaFoto.png" alt="Immagine" class="img-thumbnail image-profilo">
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
  <% 
  Enumeration<String> nomiAttributi = request.getAttributeNames();
  while(nomiAttributi.hasMoreElements()){
	  String nome = nomiAttributi.nextElement();%>
    <tr>
      <th scope="row"class="border border-dark"><%=nome %></th>
      <td><%=request.getAttribute(nome)%></td>
     </tr>
   <%} %>
  </tbody>
</table>
<a  href="/" title="Modifica Account">
<button type="button" class="btn btn-light border border-dark">Modifica Account</button>
</a>
<span class="position-bottom">
<a  href="/" title="Elimina Account">
<button type="button" class="btn btn-light border border-dark">Elimina Account</button>
</a>
</span>
</div>
</div>
</div>
</div>
</section>
</body>
</html>