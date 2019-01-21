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
<font color="white" style="margin-left:40%"><strong>MODIFICA ACCOUNT</strong><span style="margin-left:600px"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
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
<form enctype="multipart/form-data" action="ModificaStudente.html" method="post" name="modulo">
<center>
<font color="black"><strong>Nome:</strong></font><br><br>
<input type="text" name="nome" value="<%=request.getAttribute("Nome") %>" id="nomeT" required><br><br><span id="par3"></span><br><br>
<font color="black"><strong>Cognome:</strong></font><br><br>
<input type="text" name="cognome" value="<%=request.getAttribute("Cognome") %>" id="cognomeT" required><br><br><span id="par4"></span><br><br>
<font color="black"><strong>Password:</strong></font><br><br>
<input type="text" name="password" value="<%=request.getAttribute("Password") %>" id="passwordT"   required><br><br><span id="par6"></span><br><br>
<font color="black"><strong>Conferma Password:</strong></font><br><br>
<input type="text" name="pass2" id="password2T"  value="<%=request.getAttribute("Password") %>"  required><br><br><span id="par7"></span><br><br>
<font color="black"><strong>Numero di cellulare:</strong></font><br><br>
<input type="text" name="numero" value="<%=request.getAttribute("Cellulare") %>" id="numeroT" required><br><br><span id="par8"></span><br><br>
<font color="black"><strong>Voto laurea:</strong></font><br><br>
<input type="text" name="voto" value="<%=request.getAttribute("Voto") %>" id="votoT" required><br><br><span id="par9"></span><br><br>
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
  <option value="IS">Ingegneria del Software</option>
  <option value="PD">Programmazione distribuita</option>
  <option value="ETC">Elementi di teoria della computazione</option>
  <option value="RO">Ricerca operativa</option>
</select><br><br>
<font color="black"><strong>Aggiungi immagine:</strong></font><br><br>
<input type="file" name="fileT" value="<%=request.getAttribute("Immagine") %>" id="immagineT" enable><br><br><span id="par10"></span> <input type="hidden" name ="url" id="path" value="<%=request.getAttribute("Immagine") %>"><br><br>
<input type="button" value="MODIFICA" id="regT"name="button" onclick="myFunctionT()"><br><br>
</font>
</center>
</p>
</form>
<%}else{%>
<form enctype="multipart/form-data" action="ModificaStudente.html" method="post" name="modulo2">
<p align="center" id="text2" >
<font face="sans-serif">
<font color="black"><strong>Nome:</strong></font><br><br>
<input type="text" name="nome" value="<%=request.getAttribute("Nome") %>" id="nomeS" required><br><br><span id="par11"></span><br><br>
 <font color="black"><strong>Cognome:</strong></font><br><br>
<input type="text" name="cognome" value="<%=request.getAttribute("Cognome") %>" id="cognomeS" required><br><br><span id="par12"></span><br><br>
<font color="black"><strong>Password:</strong></font><br><br>
<input type="text" name="password" value="<%=request.getAttribute("Password") %>" id="passwordS"  required><br><br><span id="par14"></span><br><br>
<font color="black"><strong>Conferma Password:   </strong></font><br><br>
<input type="text" name="password2" id="password2S" value="<%=request.getAttribute("Password") %>"  required><br><br><span id="par15"></span><br><br>
<font color="black"><strong>Matricola:</strong></font><br><br>
<input type="text" name="matricola" value="<%=request.getAttribute("Matricola") %>" id="matricolaS"  required><br><br><span id="par16"></span><br><br>
<font color="black"><strong>Anno di corso:</strong></font><br><br>
 <select name="annocorso"><br><br>
  <option value="1°">Primo</option>
  <option value="2°">Secondo</option>
  <option value="3°">Terzo</option>
</select><br><br>
<font color="black"><strong>Aggiungi immagine:</strong></font><br><br>
<input type="file" name="fileS" value="<%=request.getAttribute("Immagine") %>" id="immagineS"><br><br><span id="par17"></span><br><br><input type="hidden" name ="url" id="path" value="<%=request.getAttribute("Immagine") %>"><br><br>
<input type="button" value="MODIFICA" id="regS" name="button" onclick="myFunctionS()"><br><br>
</tr> 
</tbody></table>
</font>
</p>
</form>
<%}%>
<script>
function myFunctionT() {
	//nome
	var test = /^[a-zA-Z]+$/;
	if(!document.getElementById("nomeT").value.match(test)){
		alert("Il nome deve contenere solo caratteri");
		return false;
	}
	var n = document.getElementById("nomeT").value.length;
	if(n>30){
		alert("Il nome deve contenere al massimo 30 caratteri");
		return false;
	}
	//cognome
	if(!document.getElementById("cognomeT").value.match(test)){
		alert("Il cognome deve contenere solo caratteri");
		return false;
	}
	var n = document.getElementById("cognomeT").value.length;
	if(n>30){
		alert("Il cognome deve contenere al massimo 30 caratteri");
		return false;
	}
	//conferma password
	if(document.getElementById("passwordT").value != document.getElementById("password2T").value){
		alert("Conferma password diversa da password"); 
		return false;
	}
	//numero
	var test = /^[0-9]+\S?$/;
	if(!document.getElementById("numeroT").value.match(test)){
		alert("Il numero cellulare deve contenere solo numeri");
		return false;
	}
	var n = document.getElementById("numeroT").value.length;
	if(n!=10){
		alert("Il numero di cellulare deve essere di 10 caratteri");
		return false;
	}
	//voto
	var test = /^[0-9]+\S?$/;
	if(document.getElementById("votoT").value > 110){
		alert("Il voto deve essere compreso tra 66 e 110");
		return false;
	} else if(document.getElementById("votoT").value < 66){
		alert("Il voto deve essere compreso tra 66 e 110");
		return false;
	} else if(!document.getElementById("votoT").value.match(test)){
		alert("Il voto deve contenere solo numeri");
		return false;
	}
	//foto
	var frm = document.getElementsByTagName('form')[0];
	alert(frm.elements[8].value);
	if(!frm.elements[8].value == "false"){
		if(!frm.elements[8].value.match("png") && !frm.elements[8].value.match("jpg") && !frm.elements[8].value.match("jpeg")){
			alert("I file accettati sono jpg/png/jpeg");
			return false;
		}
		var fullPath = frm.elements[8].value; 
		var elem = document.getElementById("path");
		elem.value = fullPath;
	}
	//lunghezza password
	var n = document.getElementById("passwordT").value.length;
	if(n<8||n>20){
		alert("La password deve avere tra gli 8 e 20 caratteri");
		return false;
	}
	document.modulo.submit();
}

function myFunctionS() {
	//nome
	var test = /^[a-zA-Z]+$/;
	if(!document.getElementById("nomeS").value.match(test)){
		alert("Il nome deve contenere solo caratteri");
		return false;
	}
	var n = document.getElementById("nomeS").value.length;
	if(n>30){
		alert("Il nome deve contenere al massimo 30 caratteri");
		return false;
	}
	//cognome
	if(!document.getElementById("cognomeS").value.match(test)){
		alert("Il cognome deve contenere solo caratteri");
		return false;
	}
	var n = document.getElementById("cognomeS").value.length;
	if(n>30){
		alert("Il cognome deve contenere al massimo 30 caratteri");
		return false;
	}
	//conferma password
	if(document.getElementById("passwordS").value != document.getElementById("password2S").value){
		alert("Conferma password diversa da password"); 
		return false;
	}
	//matricola
	var test = /^[0-9]+\S?$/;
	if(!document.getElementById("matricolaS").value.match(test)){
		alert("La matricola deve contenere solo numeri");
		return false;
	}
	var n = document.getElementById("matricolaS").value.length;
	if(n!=10){
		alert("La matricola deve essere di 10 caratteri");
		return false;
	}
	//foto
	var frm = document.getElementsByTagName('form')[0];
	//alert(frm.elements[6].value);
	if(!frm.elements[6].value == ""){
		if(!frm.elements[6].value.match("png") && !frm.elements[6].value.match("jpg") && !frm.elements[6].value.match("jpeg")){
			alert("I file accettati sono jpg/png/jpeg");
			return false;
		}
		var fullPath = frm.elements[6].value; 
		var elem = document.getElementById("path");
		elem.value = fullPath;
	}
	//lunghezza password
	var n = document.getElementById("passwordS").value.length;
	if(n<8 || n>20){
		alert("La password deve avere tra gli 8 e 20 caratteri");
		return false;
	}
	document.modulo2.submit();
}
</script>
</body>
</html> 