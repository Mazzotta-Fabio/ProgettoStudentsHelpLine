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
	<img class="position" src="img/logo.jpg" alt="StudentHelpline">
</div>
<div class="Name-Sito">
Student's Help Line
</div>
</div>
<nav class="navbar navbar-custom">
<a  href="ServletFormModifica" title="Indietro">
<img class="log" src="img/back.svg" style="width:50%; margin-left:10%;"></img>
</a>
<div class="Name-barra">
<%if(request.getAttribute("tipo").equals("Studente")){%>
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
<div class="col-3">
<div class="image-profilo" style="margin-top:58%;">
<%String img = (String) request.getAttribute("Immagine");
if(img != null){ %>
<img src="img/AccountsenzaFoto.png" alt="Immagine" class="img-thumbnail image-profilo">
<%}else{ %>
<img src=<%=img%> alt="Immagine" class="img-thumbnail image-profilo">
<%} %>
</div>
</div>
<div class="col-8" style="margin-top:6%;">
<table class="table table-bordered">
  <thead>
  <tr>
      <th scope="col">info</th>
    </tr>
   </thead>
   <tbody>
   <tr>
      <th scope="row"class="border border-dark">email</th>
      <td><%=request.getAttribute("email")%></td>
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
</div>
</div>
</div>
</div>
</section>
</div>
</body>
</html>