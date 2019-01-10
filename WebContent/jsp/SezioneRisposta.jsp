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
<p><center><font color="black"><strong>Cosa vuoi rispondere?</strong></font></p><textarea name="testo" id="testo" onKeyUp="myFunction2()" onKeyDown="myFunction()" required></textarea><span id="par2"></span>><br><br>
<p><center><font color="black"><strong>Allega file</strong></font></center></p><input type="file" name="file" id="file"onchange="myFunction3()"><span id="par3"></span> <br><br>
<input type="submit" value="INVIA" id="log"><br><br></center>
</form>
<script type="text/javascript">

function myFunction2() {
	var i;
	document.getElementById("par2").innerHTML = "";
	var n = document.getElementById("testo").value.lenght;
	if(n >= 700){
		document.getElementById("par2").innerHTML = "Il testo deve contenere meno di 700 caratteri";
	}
}

function myFunction3(){
	document.getElementById("par3").innerHTML = "";
	var frm = document.getElementsByTagName('form')[0];
	if(!frm.elements[2].value.match("pdf") && !frm.elements[3].value.match("docx") && !frm.elements[3].value.match("zip") && !frm.elements[3].value.match("ppt")){
		document.getElementById("par3").innerHTML = " I file accettati sono pdf/docx/zip/ppt";
	}
}

function myFunction() {
	var f2 = document.getElementById("par2").innerHTML;
	var f3 = document.getElementById("par3").innerHTML;
	if(f2=="" || f3 =="" ){
		document.getElementById("log").disabled = false;
	} else {
		document.getElementById("log").disabled = true;
	}
}
</script>
</body>
</html>