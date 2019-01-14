<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
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
<font color="white" style="margin-left:40%"><strong>Modifica Account</strong><span style="margin-left:600px"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
</div>
<style>
span{
	color: red;
	padding-left:50px;
}
#regS {
 background: #0095cd;
 color:white;
}
#regT {
 background: #0095cd;
 color:white;
}
</style>
</header>
<table width="600" align="center" bgcolor="black" border="2"><tbody> 
<tr>
<td width="600" bgcolor="#E2E2E2">
<%if(session.getAttribute("tipo").equals("Tutor")){%>
<p align="center" id="text">
<font face="sans-serif">
<form enctype="multipart/form-data" action="ModificaTutor.html" method="post">
<center>
<font color="black"><strong>Nome:</strong></font><br><br>
<input type="text" name="nome" value="<%=request.getAttribute("Nome") %>" id="nomeT" onKeyUp="myFunction3()" onKeyDown="myFunctionT()" required><br><br><span id="par3"></span><br><br>
<font color="black"><strong>Cognome:</strong></font><br><br>
<input type="text" name="cognome" value="<%=request.getAttribute("Cognome") %>" id="cognomeT"  onKeyUp="myFunction4()" onKeyDown="myFunctionT()" required><br><br><span id="par4"></span><br><br>
<font color="black"><strong>Password:</strong></font><br><br>
<input type="text" name="password" value="<%=request.getAttribute("Password") %>" id="passwordT"  onKeyUp="myFunction6()" onKeyDown="myFunctionT()" required><br><br><span id="par6"></span><br><br>
<font color="black"><strong>Conferma Password:</strong></font><br><br>
<input type="text" name="pass2" id="password2T"  value="<%=request.getAttribute("Password") %>" onKeyUp="myFunction7()" onKeyDown="myFunctionT()" required><br><br><span id="par7"></span><br><br>
<font color="black"><strong>Numero di cellulare:</strong></font><br><br>
<input type="text" name="numero" value="<%=request.getAttribute("Cellulare") %>" id="numeroT"  onKeyUp="myFunction8()" onKeyDown="myFunctionT()" required><br><br><span id="par8"></span><br><br>
<font color="black"><strong>Voto laurea:</strong></font><br><br>
<input type="text" name="voto" value="<%=request.getAttribute("Voto") %>" id="votoT"  onKeyUp="myFunction9()" onKeyDown="myFunction()T" required><br><br><span id="par9"></span><br><br>
<font color="black"><strong>Titolo di studio:</strong></font><br><br>
 <select name="titolo"><br><br>
  <option value="Triennale">Triennale</option>
  <option value="Magistrale">Magistrale</option>
  <option value="Specialistica">Specialistica</option>
</select><br><br>
<font color="black"><strong>Materia di competenza:</strong></font><br><br>
 <select name="materia"><br><br>
  <option value="Programmazione1">Programmazione 1</option>
  <option value="Analisi1">Analisi 1</option>
  <option value="Architettura">Archiettura degli elaboratori</option>
  <option value="MatematicaD">Matematica discreta</option>
  <option value="StruttureD">Strutture dati</option>
  <option value="MMI">Metodi matematici per l'informatica</option>
  <option value="Web">Programmazione Web</option>
  <option value="Reti">Reti di calcolatori</option>
  <option value="Algoritmi">Algoritmi</option>
  <option value="CPSM">Calcolo delle probabilità e statica matematica</option>
  <option value="Sistemi">Sistemi operativi</option>
  <option value="BaseDati">Base di dati</option>
  <option value="Java">Progammazione ad oggetti</option>
  <option value="IS">Ingegnieria del Software</option>
  <option value="PD">Programmazione distribuita</option>
  <option value="ETC">Elementi di teoria della computazione</option>
  <option value="RO">Ricerca operativa</option>
</select><br><br>
<font color="black"><strong>Aggiungi immagine:</strong></font><br><br>
<input type="file" name="immagine" value="<%=request.getAttribute("Immagine") %>" id="immagineT" onchange="myFunction10()"><br><br><span id="par10"></span> <input type="hidden" name ="url" id="path"><br><br>
<input type="submit" value="MODIFICA" id="regT"name="button"><br><br>
</font>
</center>
</p>
</form>
<%}else{%>
<form enctype="multipart/form-data" action="ModificaStudente.html" method="post">
<p align="center" id="text2" >
<font face="sans-serif">
<font color="black"><strong>Nome:</strong></font><br><br>
<input type="text" name="nome" value="<%=request.getAttribute("Nome") %>" id="nomeS"  onKeyUp="myFunction11()" onKeyDown="myFunctionS()" required><br><br><span id="par11"></span><br><br>
 <font color="black"><strong>Cognome:</strong></font><br><br>
<input type="text" name="cognome" value="<%=request.getAttribute("Cognome") %>" id="cognomeS"  onKeyUp="myFunction12()" onKeyDown="myFunctionS()" required><br><br><span id="par12"></span><br><br>
<font color="black"><strong>Password:</strong></font><br><br>
<input type="text" name="password" value="<%=request.getAttribute("Password") %>" id="passwordS"  onKeyUp="myFunction14()" onKeyDown="myFunctionS()" required><br><br><span id="par14"></span><br><br>
<font color="black"><strong>Conferma Password:   </strong></font><br><br>
<input type="text" name="password2" id="password2S" value="<%=request.getAttribute("Password") %>" onKeyDown="myFunctionS()" required><br><br><span id="par15"></span><br><br>
<font color="black"><strong>Matricola:</strong></font><br><br>
<input type="text" name="matricola" value="<%=request.getAttribute("Matricola") %>" id="matricolaS"  onKeyUp="myFunction16()" onKeyDown="myFunctionS()" required><br><br><span id="par16"></span><br><br>
<font color="black"><strong>Anno di corso:</strong></font><br><br>
 <select name="annocorso"><br><br>
  <option value="1°">Primo</option>
  <option value="2°">Secondo</option>
  <option value="3°">Terzo</option>
</select><br><br>
<font color="black"><strong>Aggiungi immagine:</strong></font><br><br>
<input type="file" name="immagine" value="<%=request.getAttribute("Immagine") %>" id="immagineS" onchange="myFunction17()"><br><br><span id="par17"></span><br><br><input type="text" name ="url" id="path" value="<%=request.getAttribute("Immagine") %>"><br><br>
<input type="submit" value="MODIFICA" id="regS"name="button"><br><br>
</tr> 
</tbody></table>
</font>
</p>
</form>
<%}%>


<script>

	function myFunction3() {
		var test = /^[a-zA-Z]+$/;
		document.getElementById("par3").innerHTML = "";
		if(!document.getElementById("nomeT").value.match(test)){
			document.getElementById("par3").innerHTML = "Il nome deve contenere solo caratteri";
		}
		var n = document.getElementById("nomeT").value.length;
		if(n>30){
			document.getElementById("par3").innerHTML = "Il nome deve contenere al massimo 30 caratteri";
		}
	}

	function myFunction4() {
		var test = /^[a-zA-Z]+$/;
		document.getElementById("par4").innerHTML = "";
		if(!document.getElementById("cognomeT").value.match(test)){
			document.getElementById("par4").innerHTML = "Il cognome deve contenere solo caratteri";
		}
		var n = document.getElementById("cognomeT").value.length;
		if(n>30){
			document.getElementById("par4").innerHTML = "Il cognome deve contenere al massimo 30 caratteri";
		}
	}

	function myFunction6() {
		var i;
		document.getElementById("par6").innerHTML = "";
		var n = document.getElementById("passwordT").value.lenght;
		if(n < 8||n>20){
			document.getElementById("par6").innerHTML = "La password deve avere tra gli 8 e 20 caratteri";
		}
	}

	function myFunction8() {
		var i;
		var test = /^[0-9]+\S?$/;
		document.getElementById("par8").innerHTML = "";
		if(!document.getElementById("numeroT").value.match(test)){
			document.getElementById("par8").innerHTML = "Il numero deve contenere solo numeri";
		}
		var n = document.getElementById("numeroT").value.length;
		if(n!=10){
			document.getElementById("par8").innerHTML = "Il numero deve essere di 10 caratteri";
		}
	}

	function myFunction9() {
		var i;
		var test = /^[0-9]+\S?$/;
		document.getElementById("par9").innerHTML = "";
		if(document.getElementById("votoT").value > 110){
			document.getElementById("par9").innerHTML = "Il voto deve essere compreso tra 66 e 110";
		} else if(document.getElementById("votoT").value < 66){
			document.getElementById("par9").innerHTML = "Il voto deve essere compreso tra 66 e 110";
		} else if(!document.getElementById("votoT").value.match(test)){
			document.getElementById("par9").innerHTML = "Il voto deve contenere solo numeri";
		}
	}


	function myFunction10(){
		document.getElementById("par10").innerHTML = "";
		var frm = document.getElementsByTagName('form')[0];
		if(!frm.elements[10].value.match("png") && !frm.elements[10].value.match("jpg") && !frm.elements[10].value.match("jpeg")){
			document.getElementById("par10").innerHTML = " I file accettati sono jpg/png/jpeg";
		}
		var fullPath = frm.elements[10].value; 
		var elem = document.getElementById("path");
		elem.value = fullPath;
	}

	function myFunction11() {
		var test = /^[a-zA-Z]+$/;
		document.getElementById("par11").innerHTML = "";
		if(!document.getElementById("nomeS").value.match(test)){
			document.getElementById("par11").innerHTML = "Il nome deve contenere solo caratteri";
		}
		var n = document.getElementById("nomeS").value.length;
		if(n>30){
			document.getElementById("par11").innerHTML = "Il nome deve contenere al massimo 30 caratteri";
		}
	}

	function myFunction12() {
		var test = /^[a-zA-Z]+$/;
		document.getElementById("par12").innerHTML = "";
		if(!document.getElementById("cognomeS").value.match(test)){
			document.getElementById("par12").innerHTML = "Il cognome deve contenere solo caratteri";
		}
		var n = document.getElementById("cognomeS").value.length;
		if(n>30){
			document.getElementById("par12").innerHTML = "Il cognome deve contenere al massimo 30 caratteri";
		}
	}

	function myFunction14() {
		document.getElementById("par14").innerHTML = "";
		var n = document.getElementById("passwordS").value.length;
		if(n < 8 || n >20){
			document.getElementById("par14").innerHTML = "La password deve avere tra gli 8 e 20 caratteri";
		}
	}

	function myFunction16() {
		var i;
		var test = /^[0-9]+\S?$/;
		document.getElementById("par16").innerHTML = "";
		if(!document.getElementById("matricolaS").value.match(test)){
			document.getElementById("par16").innerHTML = "La matricola deve contenere solo numeri";
		}
		var n = document.getElementById("matricolaS").value.length;
		if(n!=10){
			document.getElementById("par16").innerHTML = "Il numero deve essere di 10 caratteri";
		}
	}

	function myFunction17(){
		document.getElementById("par17").innerHTML = "";
		var frm = document.getElementsByTagName('form')[0];
		if(!frm.elements[6].value.match("png") && !frm.elements[6].value.match("jpg") && !frm.elements[6].value.match("jpeg")){
			document.getElementById("par17").innerHTML = " I file accettati sono jpg/png/jpeg";
		}
		var fullPath = frm.elements[6].value; 
		var elem = document.getElementById("path");
		elem.value = fullPath; 
	}

	function myFunctionT() {
		alert("ciao");
		var f3 = document.getElementById("par3").innerHTML;
		var f4 = document.getElementById("par4").innerHTML;
		var f6 = document.getElementById("par6").innerHTML;
		var f7 = document.getElementById("par7").innerHTML;
		var f8 = document.getElementById("par8").innerHTML;
		var f9 = document.getElementById("par9").innerHTML;
		var f10 = document.getElementById("par10").innerHTML;
		document.getElementById("par7").innerHTML = "";
		if(document.getElementById("passwordT").value != document.getElementById("password2T").value){document.getElementById("par7").innerHTML = "Conferma password diversa da password";}
		if(f3 == "" && f4=="" && f6 =="" && f7 =="" && f8=="" && f9=="" && f10==""){
			document.getElementById("regT").disabled = true;
		} else {
			document.getElementById("regT").disabled = false;
		}
	}


	function myFunctionS() {
		var f3 = document.getElementById("par11").innerHTML;
		var f4 = document.getElementById("par12").innerHTML;
		var f6 = document.getElementById("par14").innerHTML;
		var f7 = document.getElementById("par15").innerHTML;
		var f8 = document.getElementById("par16").innerHTML;
		var f9 = document.getElementById("par17").innerHTML;
		document.getElementById("par15").innerHTML = "";
		if(document.getElementById("passwordS").value != document.getElementById("password2S").value){document.getElementById("par15").innerHTML = "Conferma password diversa da password";}
		if(f3 == "" && f4=="" && f6 =="" && f7 =="" && f8=="" && f9==""){
			document.getElementById("regS").disabled = true;
		} else {
			document.getElementById("regS").disabled = false;
		}
	}
</script>
</body>
</html> 