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
<body>
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
		out.print("<a href='ServletFormRisposta?IdDomanda="+ris.get(4)+"'>Invia Risposta ></a>");
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
 		out.print("<a href='ServletFormRisposta?IdDomanda="+ris.get(4)+"'>Invia Risposta ></a>");
    	
    	String v = (String) ris.get(8);
    	if(v.equals("like")){
    		out.print("<img src='img/index.png' style='width:50px;height:50px;margin-left:400px'/>");
		} else if(v.equals("dislike")) {
			out.print("<img src='img/index2.png' style='width:50px;height:50px;margin-left:400px'/>");
		} else {
			out.print("<a href='ServletValutaRisposta?idR="+ris.get(9)+"&valutazione=like&idD="+ris.get(4)+"'><img src='img/index.png' style='width:50px;height:50px;margin-left:350px'/></a><a href='ServletValutaRisposta?idR="+ris.get(9)+"&valutazione=dislike&idD="+ris.get(4)+"'><img src='img/index2.png' style='width:50px;height:50px;'/></a>");
		}
    %>
     </div>
</div>  


</body>
</html>