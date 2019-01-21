<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<font color="white" style="margin-left:45%"><strong>Form risposta</strong><span style="margin-left:480px"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
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
<div>
<form enctype="multipart/form-data" action="ServletInserisciRisposta.html?id=<%=request.getAttribute("id")%>" method="post" name="modulo">
<p><center><font color="black"><strong>Cosa vuoi rispondere?</strong></font></p><textarea name="testo" id="testo" rows="5" cols="30" style="margin-left:2%" required></textarea><span id="par2"></span><br><br>
<p><center><font color="black"><strong>Allega file</strong></font></center></p><input type="file" name="file" id="file"><span id="par3"></span> <br> <input type="hidden" name ="url" id="path" value=""><br>
<input type="button" value="INVIA" id="log" onclick="myFunction()"><br><br></center>
</form>
<script type="text/javascript">

function myFunction() {
	var n = document.getElementById("testo").value.length;
	if(n>=700){
		alert("Il testo deve contenere meno di 700 caratteri");
		return false;
	}
	if(n==0){
		alert("Il testo non può essere vuoto");
		return false;
	}	
	var frm = document.getElementsByTagName('form')[0];
	if(frm.elements[2].value!=""){
		if(!frm.elements[2].value.match("pdf") && !frm.elements[2].value.match("docx") && !frm.elements[2].value.match("zip") && !frm.elements[2].value.match("pptx")){
			alert(" I file accettati sono pdf/docx/zip/pptx");
			return false;
		}
		var fullPath = frm.elements[2].value; 
		var elem = document.getElementById("path");
		elem.value = fullPath;
	}
	document.modulo.submit();
}
</script>
</body>
</html>