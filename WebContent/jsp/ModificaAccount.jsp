<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image" href="../img/ICONA.ico">
<style>
.header {
  padding: 0.05px;
  text-align: center;
  background: #2b78e4;
  color: white;
  font-size: 30px;
}
</style>
<div class="header">
<h1>MODIFICA ACCOUNT</h1>
</div>
<title>StudentsHelpLine</title>
</head>
<img class="left" src="img/1.PNG">
<div STYLE="position:absolute; top:190px; left:745px">
<div align="center"><img src="img/2.PNG" vspace="1"></div>
</div>
<table width="600" align="center" bgcolor="black" border="2"><tbody> 
<tr>
<td width="600" bgcolor="#E2E2E2">
<%if(session.getAttribute("tipo").equals("Tutor")){%>
<p align="center" id="text">
<font face="sans-serif">
<font color="black"><strong>Nome:</strong></font><br><br>
<input type="text" name="nome" value="<%=request.getAttribute("Nome") %>"><br><br>
<font color="black"><strong>Cognome:</strong></font><br><br>
<input type="text" name="cognome" value="<%=request.getAttribute("Cognome") %>"><br><br>
<font color="black"><strong>Password:</strong></font><br><br>
<input type="text" name="password" value="<%=request.getAttribute("Password") %>"><br><br>
<font color="black"><strong>Conferma Password:</strong></font><br><br>
<input type="text" name="pass2"id="u"><br><br>
<font color="black"><strong>Numero di cellulare:</strong></font><br><br>
<input type="text" name="numero" value="<%=request.getAttribute("Cellulare") %>"><br><br>
<font color="black"><strong>Voto laurea:</strong></font><br><br>
<input type="text" name="voto" value="<%=request.getAttribute("Voto") %>"><br><br>
<font color="black"><strong>Titolo di studio:</strong></font><br><br>
 <select name="titolo" value="<%=request.getAttribute("Titolo") %>"><br><br>
  <option value="volvo">Triennale</option>
  <option value="saab">Magistrale</option>
  <option value="mercedes">Specialistica</option>
</select><br><br>
<font color="black"><strong>Materia di competenza:</strong></font><br><br>
 <select name="materia" value="<%=request.getAttribute("Materia") %>"><br><br>
  <option value="1">Programmazione 1</option>
  <option value="2">Analisi 1</option>
  <option value="3">Archiettura degli elaboratori</option>
  <option value="4">Matematica discreta</option>
  <option value="5">Strutture dati</option>
  <option value="6">MMI</option>
  <option value="7">Web</option>
  <option value="8">Reti</option>
  <option value="9">Algoritmi</option>
  <option value="10">CPSM</option>
  <option value="11">Sistemi operativi</option>
  <option value="12">Base dati</option>
  <option value="13">Web</option>
  <option value="14">IS</option>
  <option value="15">PD</option>
  <option value="16">ETC</option>
  <option value="17">RO</option>
</select><br><br>
<font color="black"><strong>Aggiungi immagine:</strong></font><br><br>
<input type="file" name="immagine" value="<%=request.getAttribute("Immagine") %>"><br><br>
<input type="submit" value="REGISTRATI" id="log"name="button"><br><br>
</font>
</p>
<%}else{%>
<form enctype="multipart/form-data" action="ModificaStudente" method="post">
<p align="center" id="text2" >
<font face="sans-serif">
<font color="black"><strong>Nome:</strong></font><br><br>
<input type="text" name="nome" value="<%=request.getAttribute("Nome") %>"><br><br>
 <font color="black"><strong>Cognome:</strong></font><br><br>
<input type="text" name="cognome" value="<%=request.getAttribute("Cognome") %>"><br><br>
<font color="black"><strong>Password:</strong></font><br><br>
<input type="text" name="password" value="<%=request.getAttribute("Password") %>"><br><br>
<font color="black"><strong>Matricola:</strong></font><br><br>
<input type="text" name="matricola" value="<%=request.getAttribute("Matricola") %>"><br><br>
<font color="black"><strong>Anno di corso:</strong></font><br><br>
 <select name="anno" value="<%=request.getAttribute("Anno") %>"><br><br>
  <option value="terzo">Triennale</option>
</select><br><br>
<font color="black"><strong>Aggiungi immagine:</strong></font><br><br>
<input type="file" name="immagine" value="<%=request.getAttribute("Immagine") %>"><br><br>
<input type="submit" value="REGISTRATI" id="log"name="button"><br><br>
</tr> 
</tbody></table>
</font>
</p>
</form>
<%}%>
</body>
</html> 