package gestioneUtente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import classiComuni.Domanda;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;


/**
 * Questa classe implementa l'interfaccia GestioneUtente.
 * @author Antonio Cimino
 * @version 1.0
 */
public class ImpGestioneUtente implements GestioneUtente {

	
	public ImpGestioneUtente() {}
	
	/**
	 * Il metodo serve per inviare la mail per recuperare la password.
	 * @param password,destinatario: sono uno la password da inviare e l'altro l'email dove inviare l'email
	 * @return 
	 */
	public String recuperaPassword(String tipo,String destinatario) {
		
		String password = null;
		if(tipo.equals("Tutor")) {
			Tutor t = new Tutor(null, null,destinatario, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			try {
				o.recuperaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			password = t.getPassword();
		} else {
			Studente s = new Studente(null, null,destinatario,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Studente");
			try {
				o.recuperaDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			password = s.getPassword();
		}
		
		String mittente = "StudentsHelpLine@gmail.com";   // questa variabile contiene l'indirizzo del mittente
	    String host="mail.tin.it";                  // questa variabile contiene l'indirizzo dell'host per l'invio email del nostro.. 
	                                                       //..gestore dell'alds , è da cambiare a seconda del gestore che si ha
	        
	    String oggetto = "RECUPERO PASSWORD";          // questa variabile contiene l'oggetto dell'email 
	    String testo = null;
	    if(password!=null) {
		 	testo = "La password del tuo account di student's help line è: " + password;
		} else {
		   	testo = "Account non presente sul sito";
		}     // questa variabile contiene il testo dell'email
	        
	        Properties p = new Properties();                   // creiamo l'oggetto proprietà
	        
	        p.put("mail.smtp.host",host);                  // definiamo i suoi parametri, host e porta 
	        p.put("port",25);
	        
	        Session sessione = Session.getDefaultInstance(p);   // creiamo oggetto sessione con i parametri delle proprietà
	         
	        MimeMessage mail= new MimeMessage(sessione);     // creiamo oggetto messaggio e diamogli come parametri quelli della sessione e a sua volta..
	                                                            // ..quelli delle proprietà
	        
	        
	   try{
	       mail.setFrom(new InternetAddress(mittente));    // settiamo il mittente
	       mail.addRecipients(Message.RecipientType.TO, destinatario); // settiamo il destinatario
	       
	       mail.setSubject(oggetto);    // settiamo l'oggetto dell'email    
	       mail.setText(testo);             // settiamo il testo dell'email
	       
	       Transport.send(mail);         // inviamo!
	       
	       System.out.println("Il messaggio si è inviato correttamente");   // se è tutto corretto esce questa scritta
	       
	       
	   }   catch (Exception e){
	       
	       System.out.println("Si è verificato un errore");   // se cè un errore esce questa scrita con..
	       e.printStackTrace();                             //.. il nome dell'errore
	   }
	   return password;  
	}
		 

 
	@Override
	public void registraAccount(String tipo, String nome, String cognome, String email, String password, 
			String path,String voto, String titolo, String numero, String materia) throws IOException {
		
		
        if(tipo.equals("Tutor")) {
        	Tutor t = new Tutor (nome, cognome,email,password,path,numero, materia, voto, titolo);
        	FactoryDAO fDAO = new FactoryDAO();
        	ObjectDAO o = fDAO.getObject("Tutor");
        	try {
				o.inserisciDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        } else {
        	Studente s = new Studente (nome, cognome,email,password,path,voto,titolo);
        	FactoryDAO fDAO = new FactoryDAO();
        	ObjectDAO o = fDAO.getObject("Studente");
        	try {
				o.inserisciDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
	}
	

	@Override
	public void eliminaAccount(String email,String tipo) {
		int i;
		if(tipo.equals("Tutor")) {
			Tutor t = new Tutor(null, null,email, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
			ObjectDAO o = fDAO.getObject("Domanda");
			List<Object> listaD = null;
			try {
				listaD = o.recuperaTutto();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for(i=0;i<listaD.size();i++) {
				 Domanda dom = (Domanda) listaD.get(i);
				 if(dom.getTutor().getEmail().equals(email)) {
					 try {
						 o.cancellaDati(dom);
					 } catch (SQLException e) {
						 e.printStackTrace();
					 }
				 }
			}
		    o = fDAO.getObject("Tutor");
			try {
				o.cancellaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			Studente s = new Studente(null, null,email,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
			ObjectDAO o = fDAO.getObject("Domanda");
			List<Object> listaD = null;
			try {
				listaD = o.recuperaTutto();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for(i=0;i<listaD.size();i++) {
				 Domanda dom = (Domanda) listaD.get(i);
				 if(email.equals(dom.getStudente().getEmail())) {
					 try {
						 o.cancellaDati(dom);
					 } catch (SQLException e) {
						 e.printStackTrace();
					 }
				 }
			}
		    o = fDAO.getObject("Studente");
			try {
				o.cancellaDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void modificaAccount(String tipo, String nome, String cognome, String email, String password,
			String path, String voto, String titolo, String numero, String materia) throws IOException {
	
        if(tipo.equals("Tutor")) {
        	Tutor t = new Tutor (nome, cognome,email,password,path,numero, materia, voto, titolo);
        	FactoryDAO fDAO = new FactoryDAO();
        	ObjectDAO o = fDAO.getObject("Tutor");
        	try {
				o.modificaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        } else {
        	Studente s = new Studente (nome, cognome,email,password,path,voto,titolo);
        	FactoryDAO fDAO = new FactoryDAO();
        	ObjectDAO o = fDAO.getObject("Studente");
        	try {
				o.modificaDati(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
	}

	@Override
	public Object loginAccount(String email, String password, String tipo) {
		boolean accesso = false;
		if(tipo.equals("Tutor")) {
			Tutor t = new Tutor(null, null,email, password, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			try {
				accesso = o.recuperaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (accesso == true) {return t;} else {t.setEmail(null); return t;}
		} else {
			Studente s = new Studente(null, null,email,password, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Studente");
			try {
				accesso = o.recuperaDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (accesso == true) {return s;} else {s.setEmail(null); return s;}
		}	
	}
	
	public Object infoAccount(String email, String tipo) {
		if(tipo.equals("Tutor")) {
			Tutor t = new Tutor(null, null,email, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			try {
				o.recuperaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return t;
		} else {
			Studente s = new Studente(null, null,email,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Studente");
			try {
				o.recuperaDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return s;
		}	
	}

}
