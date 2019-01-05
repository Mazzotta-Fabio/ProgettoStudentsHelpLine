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
	List risControllo = (List) request.getAttribute("listaInfo");
	Iterator it = ris.iterator();
	Iterator itC = risControllo.iterator();
%>
<br>
<div style="margin-left:40%;width:700px;border-style: solid;padding-left:20px;padding-right:20px;padding-top:20px;">
  <div class="jumbotron">
    <h5>Inviata da: <%=it.next()%> </h5>     
    <h5>Oggetto: <%=it.next()%></h5>  
    <p><%=it.next()%></p>
    <% 
    	itC.next();
   		itC.next();
    	itC.next();
    	if(itC.next() != null){
    		out.print("<a href='ScaricaAllegato?url="+it.next()+"'><img src='../img/download.png' style='width:50px;height:50px;'/></a>");
		} else {
			it.next();
		}
		out.print("<a href='ServletEliminaDomanda?id="+it.next()+"'><img src='../img/elimina.png' style='width:50px;height:50px;'/>/></a>");
    %>
    
  </div>
  <div class="jumbotron">
    <h5>Inviata da: <%it.next();%></h5>       
    <p><%it.next();%></p>
	 <% 
   		itC.next();
    	itC.next();
    	if(itC.next() != null){
    		out.print("<a href='ScaricaAllegato?url="+it.next()+"'><img src='../img/download.png' style='width:50px;height:50px;'/></a>");
		} else {
			it.next();
		}
    	
    	String v = (String) itC.next();
    	if(v.equals("like")){
    		out.print("<img src='../img/index.png' style='width:50px;height:50px;margin-left:400px'/>");
		} else if(v.equals("dislike")) {
			out.print("<img src='../img/index2.png' style='width:50px;height:50px;margin-left:400px'/>");
		} else {
			out.print("<a href='ServletValutaRisposta?ID="+it.next()+"valutazione=like'><img src='../img/index.png' style='width:50px;height:50px;margin-left:400px'/></a><a href='ServletValutaRisposta?ID="+it.next()+"valutazione=dislike'><img src='../img/index2.png' style='width:50px;height:50px;'/></a>");
		}
    %>
     </div>
</div>  


</body>
</html>