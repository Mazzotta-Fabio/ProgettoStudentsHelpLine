<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image" href="../img/ICONA.ico">
<link rel="stylesheet" href="../css/Recupera password.css">
<style>
.header {
  padding: 0.05px;
  text-align: center;
  background: #2b78e4;
  color: white;
  font-size: 10px;
}

#login {
 background: #0095cd;
 color:white;
}
</style>
<div class="header">
<h1>RECUPERA PASSWORD</h1>
<title>Student's Help Line</title>
</div>
</head>


<div align="center"><a href = "HomePage.html"><img src="img/logo.png" style="widht:150px;height:150px;"></a></div><br><br>
<p>
<center><strong> HAI SMARRITO LA PASSWORD? INSERISCI LA TUA EMAIL ISTITUZIONALE E TE LA INVIEREMO!</strong></center><br><br>
</p>
<form method="get" action="RecuperaEmail.html">
<p align="center">
<input type="radio" name="tipoUtente" id="myCheck1"> TUTOR  <input type="radio" name="tipoUtente" id="myCheck2" required> STUDENTE <br><br>
 <font color="red">Email errata, non presente sul database</font><br><br>
 <font color="#2b78e4"> Email: </font> &nbsp; &nbsp; 
 <input type="text" name="email" id="email" onKeyUp="myFunction()" onKeyDown="myFunction2()" required>
 <p id="par1" style="color:red" align="center"></p></font>
 <p align="center"><input type="submit" value="INVIA" id="login" name="button"><br><br>
 <a href="HomePage.html">TORNA A HOME </a>
</p>
</form>
</head>
<body>
</body>
<script type="text/javascript">
function myFunction() {
	var checkBox1 = document.getElementById("myCheck1");
	var checkBox2 = document.getElementById("myCheck2");
	var n = document.getElementById("email").value.length;
	if (checkBox1.checked == true){
		var test = "@unisa.it";
		document.getElementById("par1").innerHTML = "";
		if(!document.getElementById("email").value.match(test)){
			document.getElementById("par1").innerHTML = "L'email non è del formato corretto (@unisa.it)";
		}
		if (n<60) {
			document.getElementById("par1").innerHTML = "L'email deve avere al massimo 60 carratteri";
		}
	} else if (checkBox2.checked == true){
		var test = "@studenti.unisa.it";
		document.getElementById("par1").innerHTML = "";
		if(!document.getElementById("email").value.match(test)){
			document.getElementById("par1").innerHTML = "L'email non è del formato corretto (@studenti.unisa.it)";
		} 
		if (n<60) {
			document.getElementById("par1").innerHTML = "L'email deve avere al massimo 60 carratteri";
		}
	}	
}

function myFunction2() {
	var f1 = document.getElementById("par1").innerHTML;
	if(f1==""){document.getElementById("login").disabled = true;}
	else {document.getElementById("login").disabled = false;}
}
</script>
</html>