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
    <h6>Testo: <%=ris.get(2)%></h6>
    <% 
		String url = (String) ris.get(3);
    	if(url.equals("")){}
    	else{
    		out.print("<form enctype='multipart/form-data' action='ScaricaAllegato' method='post'><input  type = 'hidden' name = 'url' value='"+ris.get(3)+"'><input  type = 'hidden' name = 'idD' value='"+ris.get(4)+"'><img src='img/download.png' style='width:30px;height:30px;'/><input type='submit' value='Scarica Allegato'></form>");
		}
    	out.print("<a href='ServletFormRisposta?IdDomanda="+ris.get(4)+"'>Invia Risposta ></a>");
    	out.print("<a href='ServletEliminaDomanda?id="+ris.get(4)+"'><img src='img/elimina.png' style='width:50px;height:50px;margin-left:400px;'/></a>");
    	
	%>
     </div>
</div>  


</body>
</html>
  </div>
</div>  


</body>
</html>