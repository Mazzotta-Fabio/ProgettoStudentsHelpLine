<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<header id=header">
<div class="header-content">
<p>
<img class="position" src="img/logo.png" alt="StudentHelpline" style="whidth:100px;height:100px;">
<font size="10px" style="margin-left:32%"> Student's Help Line</font>
</p>
</div>
<div style="background:#2b78e4">
<p><a href="javascript:history.back()" titlo="Indietro"><img class="log" src="img/back.svg" style="width:3%; margin-left:3%;"></img></a>
<font color="white" style="margin-left:32%"><strong>VISUALIZZA DOMANDA CON RISPOSTA</strong><span style="margin-left:34%"><a  href="Logout"><img src="img/logout.png" style="width:50px;height:50px;align:right;"></img></a></span></font></p>
</header>
<body>
<section id="main">
<div class="container">
  <div class="row">
  <div class="col">
<div class="btn-group-vertical lista-bottone" style="margin-top:100%; margin-right:10%;">
 
  <%if(session.getAttribute("tipo").equals("Studente")){%>
  
  <%if(session.getAttribute("vis").equals("si")){ %>
  <a  href="Login?email=<%=session.getAttribute("email")%>&password=<%=session.getAttribute("pass")%>&tipoUtente=<%=session.getAttribute("tipo")%>" title="Mio Account">
  <button type="button" class="MioAccount btn btn-light border border-dark" style="width: 175%;text-align: left;">Mio Account</button>
  </a>
  <a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="testoSinistra Fai_Domanda_al_Tutor btn btn-light border border-dark" style="width:114%; text-align: left;">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="testoSinistra Domande_Risposte btn btn-light border border-dark" style = "width:100%;text-align: left;">Domande Risposte <img src="img/CerchioBlu.png" style="width:8%; margin-left:9%;"></img></button>
  </a>
  <%}else{ %>
  <a  href="Login?email=<%=session.getAttribute("email")%>&password=<%=session.getAttribute("pass")%>&tipoUtente=<%=session.getAttribute("tipo")%>" title="Mio Account">
  <button type="button" class="MioAccount btn btn-light border border-dark" style="width: 175%;text-align: left;">Mio Account</button>
  </a>
  <a  href="html/PaginaSelezionaMateria.html" title="Fai Domanda al Tutor">
  <button type="button" class="testoSinistra Fai_Domanda_al_Tutor btn btn-light border border-dark" style="width:114%; text-align: left;">Fai Domanda al Tutor</button>
  </a>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="testoSinistra Domande_Risposte btn btn-light border border-dark" style = "width:128%;text-align: left;">Domande Risposte</button>
  </a>
  <%} %>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande senza Risposta">
  <button type="button" class="testoSinistra btn btn-light border border-dark" style="text-align: left;">Domande senza Risposta</button>
  </a>
  
  <%}else{%>
  
  <%if(session.getAttribute("vis").equals("si")){ %>
  
  
  <a  href="Login?email=<%=session.getAttribute("email")%>&password=<%=session.getAttribute("pass")%>&tipoUtente=<%=session.getAttribute("tipo")%>" title="Mio Account">
 <button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style=" width:195%; text-align: left;font-size: 80%;">Mio Account</button>
  </a>
  
  <a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:144%;text-align: left;font-size: 80%;">Domande Risposte</button>
  </a>
  
   
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande non Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:101%;text-align: left;font-size: 80%;">Domande non Risposte <img src="img/CerchioBlu.png" style="width:8%; margin-left:9%;"></img></button>
  </a>
  <%} else{ %>
  
  <a  href="Login?email=<%=session.getAttribute("email")%>&password=<%=session.getAttribute("pass")%>&tipoUtente=<%=session.getAttribute("tipo")%>" title="Mio Account">
<button type="button" id = "ButtomMioAccount" class="MioAccount btn btn-light border border-dark" style="width: 194%; text-align: left;font-size: 80%;">Mio Account</button>
  	</a>
  	<a  href="ServletTabDomandaRisposte" title="Domande Risposte">
  <button type="button" class="btn btn-light border border-dark" style="width:144%;text-align: left;font-size: 80%;">Domande Risposte</button>
  </a>
  
  <a  href="ServletTabDomandaSenzaRisposta" title="Domande non Risposte">
  <button type="button" class="btn btn-light border border-dark"style="text-align: left;font-size: 80%; width:121%;">Domande non Risposte</button>
  </a>
  
  
   <%} %>
  
  <a  href="ServletVisualizzaValutazioniTot" title="Visualizza Valutazioni">
  <button type="button" class="btn btn-light border border-dark" style="width:131%;text-align: left;font-size: 80%;">Visualizza Valutazioni</button>
  </a>
  
  <%}%>

</div>
</div>
<div class="col" style="margin-right:15%; margin-bottom:2%;">
<%
	List ris = (List) request.getAttribute("listaInfo");
%>
<br>
<div style="margin-left:40%;width:700px;border-style: solid;padding-left:20px;padding-right:20px;padding-top:20px;">
  <div class="jumbotron">
    <h5>Inviata da: <a href='ServletVisualizzaProfilo?email=<%=ris.get(0)%>'><%=ris.get(0)%></a></h5>     
    <h5>Oggetto: <%=ris.get(1)%></h5>  
    <p><%=ris.get(2)%></p>
    <% 
		String url = (String) ris.get(3);
		if(url.equals("")){}
		else{
			out.print("<form enctype='multipart/form-data' action='ScaricaAllegato' method='post'><input  type = 'hidden' name = 'url' value='"+ris.get(3)+"'><input  type = 'hidden' name = 'idD' value='"+ris.get(4)+"'><img src='img/download.png' style='width:30px;height:30px;'/><input type='submit' value='Scarica Allegato'></form>");
		}
		out.print("<a href='ServletEliminaDomanda?id="+ris.get(4)+"'><img src='img/elimina.png' style='width:50px;height:50px;margin-left:400px;'/></a>");   %> 
  </div>
  <div class="jumbotron">
    <h5>Inviata da: <a href='ServletVisualizzaProfilo?email=<%=ris.get(5)%>'><%=ris.get(5)%></a></h5>       
    <p><%=ris.get(6)%></p>
	 <% 
		url = (String) ris.get(7);
 		if(url.equals("")){}
 		else{
 			out.print("<form enctype='multipart/form-data' action='ScaricaAllegato' method='post'><input  type = 'hidden' name = 'url' value='"+ris.get(3)+"'><input  type = 'hidden' name = 'idD' value='"+ris.get(4)+"'><img src='img/download.png' style='width:30px;height:30px;'/><input type='submit' value='Scarica Allegato'></form>");
		}
    	
    	String v = (String) ris.get(8);
    	if(v.equals("like")){
    		out.print("<img src='img/index.png' style='width:50px;height:50px;margin-left:400px'/>");
		} else if(v.equals("dislike")) {
			out.print("<img src='img/index2.png' style='width:50px;height:50px;margin-left:400px'/>");
		} else {
			if(session.getAttribute("tipo").equals("Studente")){
				out.print("<a href='ServletValutaRisposta?idR="+ris.get(9)+"&valutazione=like&idD="+ris.get(4)+"'><img src='img/index.png' style='width:50px;height:50px;margin-left:350px'/></a><a href='ServletValutaRisposta?idR="+ris.get(9)+"&valutazione=dislike&idD="+ris.get(4)+"'><img src='img/index2.png' style='width:50px;height:50px;'/></a>");
			}
		}
    %>
     </div>
</div>  
</div>
</div>
</div>
</section>
</body>
</html>