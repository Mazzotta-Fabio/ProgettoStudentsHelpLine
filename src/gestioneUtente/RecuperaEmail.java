package gestioneUtente;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiComuni.Studente;
import classiComuni.Tutor;
import classiComuni.Utente;
import storage.FactoryDAO;
import storage.ObjectDAO;


/**
 * La classe RecuperaEmail è una Servlet.
 * Questa classe permette di inviare una mail ad un utente permettendogli di recuperare la propria password.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/RecuperaEmail.html")
public class RecuperaEmail extends HttpServlet {
	     
    public RecuperaEmail() {}
	
	/**
	 * Il metodo serve per inviare la mail per recuperare la password.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destinatario = request.getParameter("email");
		String tipo = request.getParameter("tipoUtente");
		String password = null;
		
		if(tipo.equals("tutor")) {
			Tutor t = new Tutor(null, null,destinatario, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			o.recuperaDati(t);
			password = t.getPassword();
		} else {
			Studente s = new Studente(null, null,destinatario,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Studente");
			o.recuperaDati(s);
			password = s.getPassword();
		}
		
		String testo = null;
		String mittente = "StudentsHelpLine@gmail.com";                             
	    String oggetto = "RECUPERO PASSWORD";    
	    if(password!=null) {
	    	testo = "La password del tuo account di student's help line è: " + password;
	    } else {
	    	testo = "Account non presente sul sito";
	    }
	    String host ="mail.tin.it"; 
	    	    
	    Properties p = new Properties();                    
	    p.put("mail.smtp.host",host);                   
	    p.put("port",25);
	        
	    Session sessione = Session.getDefaultInstance(p);   
	    MimeMessage mail= new MimeMessage(sessione);  	        
	        
	   try{
	       mail.setFrom(new InternetAddress(mittente));   
	       mail.addRecipients(Message.RecipientType.TO, destinatario); 
	       mail.setSubject(oggetto);      
	       mail.setText(testo);           
	       Transport.send(mail);       	       
	       System.out.println("Il messaggio si è inviato correttamente");   	       
	   }   catch (Exception e){  
	       System.out.println("Si è verificato un errore");  
	       e.printStackTrace();                           
	   }  
	   
	   RequestDispatcher view = request.getRequestDispatcher("Home.html");
	   view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
