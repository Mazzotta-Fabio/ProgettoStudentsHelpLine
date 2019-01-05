<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List" import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/SelezionaMateria.css">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<style>
.header {
  padding: 0.05px;
  text-align: center;
  background: #2b78e4;
  color: white;
  font-size: 30px;
}

.rectangle {
padding-top: 22px;
background: #CCCCCC;
border-style: solid;
 text-align: center;
}
.footer {
  position: fixed;
  width: 100%;
  bottom: 0px;
  text-align: center;
  background: #2b78e4;
  color: white;
  font-size: 20px;
}


.imgs {
  max-width: 25%;
  height: auto;

}
</style>
<div class="header">
  <img class="left" src="img/2.PNG"><br><br>
 </div>
<title>STUDENT'S HELP LINE</title>


</head>
<body>


</div>
</div>

<div class="rectangle">
<center><strong><h2>SELEZIONA TUTOR</h2></strong></center><br><br>
</div>
</a>
</nav>
</div><br><br>
<div id ="card" class="card-deck" style="width: 30%;padding-left:5%;">

<%  
			List <String> listaTutor= (List <String>) request.getAttribute("listaTutor");
			Iterator it=listaTutor.iterator();
			for(int i=0; i< listaTutor.size()/6;i++){
				String nome=(String) it.next();
				String cognome=(String) it.next();
				String url =(String) it.next();
				String valutazioneP =(String) it.next();
				String valutazioneN =(String) it.next();
				String email=(String) it.next();
				
				out.println("<div class='card'><img  src='img/AccountsenzaFoto.png'><div class='card-body'><h5 class='card-title'>Tutor</h5><p class='card-text'>"+nome +" "+cognome+"<br><img  src='img/+.png' width='30' height='30'>&nbsp;&nbsp;&nbsp;"+valutazioneP+"&nbsp;&nbsp;&nbsp;<img  src='img/-.png' width='30' height='30'>&nbsp;&nbsp;&nbsp;"+valutazioneN+"<center><a href='ServletFormDomanda?tutor="+email+"'> FAI DOMANDA ></center></p></div></div>");
				
			}			
%>

</div>
<div>
<div class="footer">
<h1>STUDENT'S HELP LINE. SEE MORE. DO MORE.</h1>
</div>
</body>
</html>