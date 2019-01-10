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
 <font color="red">Email o password errati</font><br>
 <font color="black"><strong>Email:</strong></font><br><br>
 <input type="text" name="email"id="email"  onKeyUp="myFunction()" onKeyDown="myFunction2()" required>
 <p id="par1" style="color:red" align="center"></p></font>
 <p align="center"> <font color="black"><strong>Password:</strong></font><br>
  <input type="password" name="password"id="p" onKeyDown="myFunction2()" required><br><br>
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
	if (checkBox1.checked == true){
		var test = "@unisa.it";
		document.getElementById("par1").innerHTML = "";
		if(!document.getElementById("email").value.match(test)){
			document.getElementById("par1").innerHTML = "L'email non è del formato corretto (@unisa.it)";
		}
	} else if (checkBox2.checked == true){
		var test = "@studenti.unisa.it";
		document.getElementById("par1").innerHTML = "";
		if(!document.getElementById("email").value.match(test)){
			document.getElementById("par1").innerHTML = "L'email non è del formato corretto (@studenti.unisa.it)";
		}
	}	
}

function myFunction2() {
	var f1 = document.getElementById("par1").innerHTML;
	if(f1==""){document.getElementById("login").disabled = false;}
	else {document.getElementById("login").disabled = true;}
}
</script>
</body>
</html>
  
 