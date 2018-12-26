package gestioneUtente;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Questa classe permette di inviare una mail ad un utente permettendogli di recuperare la propria password.
 * @author Antonio Cimino
 * @version 1.0
 */
public class ImpGestioneUtente implements GestioneUtente {

	/**
	 * Il metodo serve per inviare la mail per recuperare la password.
	 * @param password,destinatario: sono uno la password da inviare e l'altro l'email dove inviare l'email
	 */
	public void recuperaPassword(String password,String destinatario) {
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
	}
}
