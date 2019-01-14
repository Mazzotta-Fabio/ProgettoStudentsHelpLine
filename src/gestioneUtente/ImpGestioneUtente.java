package gestioneUtente;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import com.email.durgesh.Email;
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
		
		try {
			Email email = new Email("helplinestudent53@gmail.com","st5d3nth3lpl1n3");
			email.setFrom("helplinestudent53@gmail.com", "Student's Help Line");
			email.setSubject("RECUPERO PASSWORD");
			String testo = null;
			if(password!=null) {
				testo = "La password del tuo account di student's help line è: " + password;
			} else {
			   	testo = "Account non presente sul sito";
			}            
			email.setContent("<h1>La tua password è " + testo + "</h1>","text/html");
			email.addRecipient(destinatario);
			email.send();
			System.out.print("INVIATOOOOO!!!!!!");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
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
