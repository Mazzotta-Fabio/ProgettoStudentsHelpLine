<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div align="center"><a href = "HomePage.html"><img src="img/logo.png" style="widht:50px;height:50px;"></a></div><br><br>
</div>
<title>
Student's Help Line
</title>
<link rel="icon" type="image" href="img/ICONA.ico">
<style>
#pulsante {
 background: #0095cd;
 color:white;
}

#login {
 background: #0095cd;
 color:white;
}
</style>
</head>
<body>
<table width="600" align="center" bgcolor="black" border="3" style="margin-top:-30px;"><tbody> 
<tr>
<td width="600" bgcolor="white">
<div align="center"><img class="left" src="img/3.png" width="100" height="100" ></div>
<form method="get" action="Login" name="modulo">
<p align="center">
<font face="sans-serif">
<input type="radio" name="tipoUtente"id="myCheck1" value="Tutor" checked> TUTOR  <input type="radio" name="tipoUtente"id="myCheck2" value="Studente" required> STUDENTE <br><br>
 <font color="red">Email o password errati</font><br><br>
 <font color="black"><strong>Email:</strong></font><br><br>
 <input type="text" name="email"id="email"   required>
 <p id="par1" style="color:red" align="center"></p></font>
 <p align="center"> <font color="black"><strong>Password:</strong></font><br>
  <input type="password" name="password"id="password" required><br><br>
  <p id="par2" style="color:red" align="center"></p></font>
 <center><input type="button" value="Login" id="login" onclick="myFunction()"></center><br>
 <center><input type="button" value="Registrati"  onclick="location.href='PaginaRegistrazione.html';" id="pulsante"></center><br>
 <a href="PaginaRecuperaPassword.html"><font color="black"><center>Password o username dimenticata?</center></font><br></a><br>
 </form>
</tr> 
</tbody></table>
</font>
</p>

<script type="text/javascript">
function myFunction() {
	var checkBox1 = document.getElementById("myCheck1");
	var checkBox2 = document.getElementById("myCheck2");
	var n = document.getElementById("email").value.length;
	if (checkBox1.checked == true){
		var test = "@unisa.it";
		if(!document.getElementById("email").value.match(test)){
			alert("L'email non � del formato corretto (@unisa.it)");
			return false;
		}
		if (n>60) {
			alert("L'email deve avere al massimo 60 carratteri");
			return false;
		}
	} else if (checkBox2.checked == true){
		var test = "@studenti.unisa.it";
		if(!document.getElementById("email").value.match(test)){
			alert("L'email non � del formato corretto (@studenti.unisa.it)");
			return false;
		} 
		if (n>60) {
			alert("L'email deve avere al massimo 60 carratteri");
			return false;
		}
	}
	var n = document.getElementById("password").value.length;
	if (n>20 || n<8) {
		alert("La password deve essere tra 8 o 20 carratteri");
		return false;
	}
	document.modulo.submit();
}
</script>
</body>
</html>
  
 