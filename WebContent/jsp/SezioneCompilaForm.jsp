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
<font color="white" style="margin-left:42%"><strong>FORM DOMANDA</strong><span style="margin-left:36%"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
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
<form action="ServletInserisciDomanda.html" method="post">
<input type="hidden" name="tutor" value="<%=request.getAttribute("Tutor")%>" >
<p><center><font color="black" ><strong>Oggetto della domanda:</strong></font></p><input type="text" name="oggetto" id="oggetto" onKeyUp="myFunction1()" onKeyDown="myFunction()" style="width:300px;margin-left:2%" required><span id="par1"></span></center>
<p><center><font color="black" "><strong>Che vuoi chiedere?</strong></font></p><textarea name="testo" id="testo" onKeyUp="myFunction2()" onKeyDown="myFunction()" rows="5" cols="30" style="margin-left:2%" required></textarea><span id="par2"></span></center>
<p><center><font color="black" ><strong>Allega file: </strong></font>
<input type="file" name="file" id="file-upload"onchange="myFunction3()"><br><span id="par3"></span></center><br> <input type="hidden" name ="url" id="path" value="">
<center><input type="submit" value="INVIA" id="log"name="button"></center>
</form>

<script type="text/javascript">
function myFunction1() {
	document.getElementById("par1").innerHTML = "";
	var n = document.getElementById("oggetto").value.length;
	if(n > 30){
		document.getElementById("par1").innerHTML = "L' oggetto deve contenere meno di 30 caeratteri";
	}
}

function myFunction2() {
	document.getElementById("par2").innerHTML = "";
	var n = document.getElementById("testo").value.lenght;
	if(n >= 700){
		document.getElementById("par2").innerHTML = "Il testo deve contenere meno di 700 caratteri";
	}
}

function myFunction3(){
	document.getElementById("par3").innerHTML = "";
	var frm = document.getElementsByTagName('form')[0];
	if(!frm.elements[3].value.match("pdf") && !frm.elements[3].value.match("docx") && !frm.elements[3].value.match("zip") && !frm.elements[3].value.match("ppt")){
		document.getElementById("par3").innerHTML = " I file accettati sono pdf/docx/zip/ppt";
	}
	var fullPath = frm.elements[3].value; 
	var elem = document.getElementById("path");
	elem.value = fullPath;
}

function myFunction() {
	var f1 = document.getElementById("par1").innerHTML;
	var f2 = document.getElementById("par2").innerHTML;
	var f3 = document.getElementById("par3").innerHTML;
	if(f1 == "" && f2=="" && f3 =="" ){
		document.getElementById("log").disabled = false;
	} else {
		document.getElementById("log").disabled = true;
	}
}
</script>
</body>
</html>