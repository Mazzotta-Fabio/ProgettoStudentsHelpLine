package gestioneUtente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;

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

	private String destLocation;
	
	public ImpGestioneUtente() {
		destLocation = new String("C:\\Users\\Antonio\\git\\ProgettoStudentsHelpLine\\file");
	}
	
	/**
	 * Il metodo serve per inviare la mail per recuperare la password.
	 * @param password,destinatario: sono uno la password da inviare e l'altro l'email dove inviare l'email
	 */
	public void recuperaPassword(String tipo,String password,String destinatario) {
		
		if(tipo.equals("tutor")) {
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

 
	@Override
	public void registraAccount(String tipo, String nome, String cognome, String email, String password, 
			Part linkImmagine,String voto, String titolo, String numero, String materia) throws IOException {
		
		String fileName = extractFileName(linkImmagine);
		File sourceLocation = new File(fileName);
    	File targetFolder = new File(destLocation);
        InputStream in = new FileInputStream(sourceLocation);
        OutputStream out = new FileOutputStream(targetFolder + "\\"+ sourceLocation.getName(), true);            
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        
        String path =(targetFolder + "\\"+ sourceLocation.getName());
  
        if(tipo.equals("Studente")) {
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
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String [] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.lastIndexOf("=")+2,s.length()-1);
			}
		}
		return "";
	}

	@Override
	public void eliminaAccount(String destinatario,String tipo) {
		if(tipo.equals("tutor")) {
			Tutor t = new Tutor(null, null,destinatario, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			try {
				o.cancellaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			Studente s = new Studente(null, null,destinatario,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			try {
				o.cancellaDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void modificaAccount(String tipo, String nome, String cognome, String email, String password,
			Part linkImmagine, String voto, String titolo, String numero, String materia) throws IOException {
	
		String fileName = extractFileName(linkImmagine);
		File sourceLocation = new File(fileName);
    	File targetFolder = new File(destLocation);
        InputStream in = new FileInputStream(sourceLocation);
        OutputStream out = new FileOutputStream(targetFolder + "\\"+ sourceLocation.getName(), true);            
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        
        String path =(targetFolder + "\\"+ sourceLocation.getName());
  
        if(tipo.equals("Studente")) {
        	Tutor t = new Tutor (nome, cognome,email,password,path,numero, materia, voto, titolo);
        	FactoryDAO fDAO = new FactoryDAO();
        	ObjectDAO o = fDAO.getObject("Tutor");
        	try {
				o.cancellaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
				o.cancellaDati(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	try {
				o.inserisciDati(s);
			} catch (SQLException e) {
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
