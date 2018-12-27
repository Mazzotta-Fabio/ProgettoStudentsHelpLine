<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<%/*predi i dati dalla servlet*/ %>
Account<%/*metti il nome di chi è tutor o studente*/%>
</div>
<a  href="/" title="Logout">
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
      <th scope="row"class="border border-dark">nome</th>
      <td>carlo</td>
    </tr>
    <tr>
      <th scope="row"class="border border-dark">2</th>
      <td>Jacob</td>
    </tr>
    <tr>
      <th scope="row"class="border border-dark">3</th>
      <td colspan="2">Larry the Bird</td>
    </tr>
       <!-- questo è un commento 
    <tr>
    <th scope="row"class="border border-dark">3</th>
      <td colspan="2">Larry the Bird</td>
    </tr>
    fino a qui -->
  </tbody>
</table>
<button type="button" class="btn btn-light border border-dark">Modifica Account</button>
<span class="position-bottom">
<button type="button" class="btn btn-light border border-dark">Elimina Account</button>
</span>
</div>
</div>
</div>
</div>
</section>
</body>
</html>