<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div align="center"><a href = "HomePage.html"><img src="img/logo.png" style="widht:50px;height:50px;"></a></div><br><br>
</div>
<title>
StudentsHelpLine
</title>
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
<form method="get" action="Login">
<p align="center">
<font face="sans-serif">
<input type="radio" name="tipoUtente"id="myCheck1" value="Tutor" required> TUTOR  <input type="radio" name="tipoUtente"id="myCheck2" value="Studente" required> STUDENTE <br><br>
 <font color="red">Email o password errati</font><br><br>
 <font color="black"><strong>Email:</strong></font><br><br>
 <input type="text" name="email"id="email"  onKeyUp="myFunction()" onKeyDown="myFunction2()" required>
 <p id="par1" style="color:red" align="center"></p></font>
 <p align="center"> <font color="black"><strong>Password:</strong></font><br>
  <input type="password" name="password"id="p" onKeyUp="myFunction3()" onKeyDown="myFunction2()" required><br><br>
  <p id="par2" style="color:red" align="center"></p></font>
 <center><input type="submit" value="Login" id="login"></center><br>
 <center><input type="submit" value="Registrati"  onclick="location.href='PaginaRegistrazione.html';" id="pulsante"></center><br>
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
		document.getElementById("par1").innerHTML = "";
		if(!document.getElementById("email").value.match(test)){
			document.getElementById("par1").innerHTML = "L'email non è del formato corretto (@unisa.it)";
		}
		if (n>60) {
			document.getElementById("par1").innerHTML = "L'email deve avere al massimo 60 carratteri";
		}
	} else if (checkBox2.checked == true){
		var test = "@studenti.unisa.it";
		document.getElementById("par1").innerHTML = "";
		if(!document.getElementById("email").value.match(test)){
			document.getElementById("par1").innerHTML = "L'email non è del formato corretto (@studenti.unisa.it)";
		} 
		if (n>60) {
			document.getElementById("par1").innerHTML = "L'email deve avere al massimo 60 carratteri";
		}
	}	
}

function myFunction3() {
	document.getElementById("par2").innerHTML = "";
	var n = document.getElementById("p").value.length;
	if (n>20 || n<8) {
		document.getElementById("par2").innerHTML = "La password deve essere tra 8 o 20 carratteri";
	}	
}

function myFunction2() {
	var f1 = document.getElementById("par1").innerHTML;
	var f2 = document.getElementById("par2").innerHTML;
	if(f1=="" && f2==""){document.getElementById("login").disabled = false;}
	else {document.getElementById("login").disabled = true;}
}
</script>
</body>
</html>
  
 