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
<center>Risposta</center>
</div>
<a  href="/" title="Logout">
<img class="log" src="../img/logout.svg"></img>
</a>
</nav>
</div>
</header>
<form enctype="multipart/form-data" action="ServletInserisciRisposta.html" method="post">
<input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
<p><center><font color="black"><strong>Cosa vuoi rispondere?</strong></font></p><textarea name="testo"></textarea><br><br>
<p><center><font color="black"><strong>Allega file</strong></font></center></p><input type="file" name="file"> <br><br>
<input type="submit" value="INVIA"><br><br></center>
</form>

</body>
</html>