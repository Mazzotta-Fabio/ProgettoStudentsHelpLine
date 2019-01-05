<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/SelezionaMateria.css">
<link rel="icon" type="image" href="../img/ICONA.ico">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<title>Student's Help Line</title>
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
<center>Domanda</center>
</div>
<a  href="/" title="Logout">
<img class="log" src="../img/logout.svg"></img>
</a>
</nav>
</div>
</header>
<body>
<form enctype="multipart/form-data" action="ServletInserisciDomanda.html" method="post">
<p>Invia a:</p><input type="text" name="tutor" value="<%=request.getAttribute("Tutor")%>"><br><br>
<p><font color="black"><strong>Oggetto della domanda:</strong></font></p><input type="text" name="oggetto"><br><br>
<p><font color="black"><strong>Che vuoi chiedere?</strong></font></p><textarea name="testo"></textarea><br><br>
<p><font color="black"><strong>Allega file</strong></font></p><input type="file" name="file"><br><br>
<input type="submit" value="INVIA" id="log"name="button"><br><br></center>
</form>
</body>
</html>