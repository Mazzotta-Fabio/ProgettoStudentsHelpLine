<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List" import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/SelezionaMateria.css">
<link rel="icon" type="image" href="img/ICONA.ico">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Student's Help Line</title>
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
<p><a href="javascript:history.back()" titlo="Indietro"><img class="log" src="img/back.svg" style="width:3%; margin-left:3%;"></img></a>
<font color="white" style="margin-left:45%"><strong>SELEZIONA TUTOR</strong><span style="margin-left:38%"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
</div>
<style>
span{
	color: red;
	padding-left:50px;
}
#log {
 background: #0095cd;
 color:white;
}
</style>
</header>
<body>

<div id ="card" class="card-deck" style="width: 100%;padding-left:5%;">

<%  
			List <String> listaTutor= (List <String>) request.getAttribute("listaTutor");
			Iterator it=listaTutor.iterator();
			for(int i=0; i< listaTutor.size()/6;i++){
				String nome=(String) it.next();
				String cognome=(String) it.next();
				String url =(String) it.next();
				String valutazioneP =(String) it.next();
				String valutazioneN =(String) it.next();
				String email=(String) it.next();
				
				out.println("<div class='card'><center><img  src='img/AccountsenzaFoto.png' style='padding-top:5%;' height='230px' width='300px' ></center><div class='card-body'><center><h5 class='card-title'>Tutor</h5><center><p class='card-text'>"+nome +" "+cognome+"<br><img  src='img/+.png' width='30' height='30'>&nbsp;&nbsp;&nbsp;"+valutazioneP+"&nbsp;&nbsp;&nbsp;<img  src='img/-.png' width='30' height='30'>&nbsp;&nbsp;&nbsp;"+valutazioneN+"<center><a href='ServletFormDomanda?tutor="+email+"'> FAI DOMANDA ></a></center></p></div></div>");
			}			
%>

</div>

</body>
</html>