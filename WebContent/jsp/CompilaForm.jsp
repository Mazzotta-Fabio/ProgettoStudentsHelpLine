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
<title>Insert title here</title>
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
<p>
<center>Invia a:<% //nome %> <%//cognome %> </center>
</p>
<p>

<center><font color="black"><strong>Oggetto della domanda:</strong></font>&nbsp;&nbsp;
<input type="text" name="user"id="u"><br><br></center>
</p>
<center><font color="black"><strong>Che vuoi chiedere?</strong></font><br><br>
<input name="mioTesto" type="text" value="Inserisci qui il testo" size="80" maxlength="200" /></center><br>
<p>
<center><font color="black"><strong>Allega file</strong></font><br><br>
<input type="file" name="allegato"> <br><br>
<input type="submit" value="INVIA" id="log"name="button"><br><br></center>


</body>
</html>