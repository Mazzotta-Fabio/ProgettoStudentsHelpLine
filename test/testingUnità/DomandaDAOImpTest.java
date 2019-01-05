package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;
import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.DomandaDAOImp;

public class DomandaDAOImpTest extends TestCase {
	
	private DomandaDAOImp domandaDao;
	private Risposta risposta;
	private Risposta risposta1;
	private Tutor tutor;
	private Tutor tutor2;
	private Studente studente;
	private Studente studente2;
	private Domanda domanda;
	private Domanda domanda2;
	protected void setUp() throws Exception {
		risposta=new Risposta(0,"CIAOIOIO","allegato","ON","SI");
		risposta1=new Risposta(0,"CIAOIOIO","allegato","ON","SI");
		tutor=new Tutor("Mario","Rossi","fabio.mazzotta@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
		tutor2=new Tutor("Ezechiele","Nuvola","federico.coiro@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
		studente=new Studente("Rosa","Marini","antonio.derita@gmail.com","12345678","/home/xyz","0522500518","2");
		studente2=new Studente("Chiara","Giani","ines.votta@gmail.com","123456err","/home/xyz/o","0512102515","1");
		domanda=new Domanda(1001,"CIAO","OGGETTO","ALLEGATO",studente,tutor,risposta,"NO");
		domanda2=new Domanda(1002,"Giani","giani@gmail.com","ALLEGATO",studente2,tutor2,risposta1,"NO");
		domandaDao=new DomandaDAOImp();
	}

	protected void tearDown() throws Exception {
		risposta=null;
		risposta1=null;
		tutor=null;
		tutor2=null;
		studente=null;
		studente2=null;
		domanda=null;
		domanda2=null;
		domandaDao=null;
	}
	
	public void testInserisciDati() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			Domanda domanda=new Domanda(1001,"CIAO","OGGETTO","ALLEGATO",studente,tutor,risposta);
			Domanda domanda2=new Domanda(1002,"Giani","giani@gmail.com","ALLEGATO",studente2,tutor2,risposta1);
			*/
			domandaDao.inserisciDati(domanda);
			domandaDao.inserisciDati(domanda2);
			assertEquals(true,domandaDao.recuperaDati(domanda));
			assertEquals(true,domandaDao.recuperaDati(domanda2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void testRecuperaDati() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			Domanda domanda=new Domanda(1001,"CIAO","OGGETTO","ALLEGATO",studente,tutor,risposta);
			Domanda domanda2=new Domanda(1002,"Giani","giani@gmail.com","ALLEGATO",studente2,tutor2,risposta1);
			*/
			assertEquals(false,domandaDao.recuperaDati(domanda));
			assertEquals(false,domandaDao.recuperaDati(domanda2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void testRecuperaTutto() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			Domanda domanda=new Domanda(1001,"CIAO","OGGETTO","ALLEGATO",studente,tutor,risposta);
			Domanda domanda2=new Domanda(1002,"Giani","giani@gmail.com","ALLEGATO",studente2,tutor2,risposta1);
			*/
			ArrayList<Object>domandeObject=domandaDao.recuperaTutto();
			assertEquals(6,domandeObject.size());
			/*
			for(Object o:domandeObject) {
				Domanda t=(Domanda)o;
				assertEquals(domanda,t);
				assertEquals(domanda2,t);
			}
			*/
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void testCancellaDati() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			Domanda domanda=new Domanda(1001,"CIAO","OGGETTO","ALLEGATO",studente,tutor,risposta);
			Domanda domanda2=new Domanda(1002,"Giani","giani@gmail.com","ALLEGATO",studente2,tutor2,risposta1);
			*/
			domandaDao.cancellaDati(domanda);
			domandaDao.cancellaDati(domanda2);
			assertEquals(false,domandaDao.recuperaDati(domanda));
			assertEquals(false,domandaDao.recuperaDati(domanda2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public static Test suite() {
		return new TestSuite(DomandaDAOImpTest.class);
	}

}
