<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Enumeration;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Alfonso Golino">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image" href="../img/ICONA.ico">
<link rel="stylesheet" href="../css/Account.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<title>Account</title>
</head>
<body>
<div id="page">
<header id=header">
<div class="header-content">
<div class="image-logo">
	<img class="position" src="../img/logo.jpg" alt="StudentHelpline">
</div>
</div>
<div class="Name-Sito">
Student's Help Line
</div>
</div>
<nav class="navbar navbar-custom">
<a href="\"  title="Indietro">
<img src="../img/back.svg" width="60"></img>
</a>
<span class="Name-barra" style="margin-right:35%;">
<%//if(session.getAttribute("tipo") == "Studente"){%>
Account Studente
<%//}else{%>
<!-- Account Tutor -->
<%//} %>
</span>
<a  href="../Logout" title="Logout">
<img class="log" src="../img/logout.svg"></img>
</a>
</nav>
</header>
<section id="main">
<div class="container">
  <div class="row">
<div class="col-4">
<div class="image-profilo">
<img src="../img/AccountsenzaFoto.png" alt="Immagine" class="img-thumbnail image-profilo">
</div>
</div>
<div class="col-8" style="margin-top:8%;">
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
</span>
</div>
</div>
</div>
</section>
</div>
</body>
</html>