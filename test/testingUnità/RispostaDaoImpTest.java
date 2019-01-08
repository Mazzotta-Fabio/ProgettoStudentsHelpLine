package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import classiComuni.Risposta;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.RispostaDAOImp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RispostaDaoImpTest extends TestCase{
	private Risposta risposta;
	private Risposta risposta1;
	private RispostaDAOImp rispostaDao;
	public void setUp() throws Exception {
		risposta=new Risposta(0,"RISPOSTA","allegato","ON","SI");
		risposta1=new Risposta(0,"RISPOSTA1","allegato","ON","SI");
		rispostaDao=new RispostaDAOImp();
	}

	public void tearDown() throws Exception {
		risposta=null;
		risposta1=null;
		rispostaDao=null;
	}
	
	public void test2InserisciDati() {
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
			rispostaDao.inserisciDati(risposta);
			rispostaDao.inserisciDati(risposta1);
			ArrayList<Object>risposte=rispostaDao.recuperaTutto();
			Risposta aiuto=(Risposta) risposte.get(risposte.size()-2);
			risposta.setId(aiuto.getId());
			Risposta aiuto1=(Risposta) risposte.get(risposte.size()-1);
			risposta1.setId(aiuto1.getId());
			assertEquals(true,rispostaDao.recuperaDati(risposta));
			assertEquals(true,rispostaDao.recuperaDati(risposta1));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test1RecuperaDati() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			*/
			assertEquals(false,rispostaDao.recuperaDati(risposta));
			assertEquals(false,rispostaDao.recuperaDati(risposta1));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test3RecuperaTutto() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			*/
			ArrayList<Object>rispostaObject=rispostaDao.recuperaTutto();
			//System.out.println(rispostaObject.size());
			assertEquals(7,rispostaObject.size());
			/*
			for(Object o:rispostaObject) {
				Risposta t=(Risposta)o;
				assertEquals(risposta,t);
				assertEquals(risposta1,t);
			}
			*/
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test4ModificaDati() {
		try {
			ArrayList<Object>risposte=rispostaDao.recuperaTutto();
			Risposta aiuto=(Risposta) risposte.get(risposte.size()-2);
			risposta.setId(aiuto.getId());
			Risposta aiuto1=(Risposta) risposte.get(risposte.size()-1);
			risposta1.setId(aiuto1.getId());
			risposta.setValutazione("like");
			risposta1.setVis("SI!!!!");
			rispostaDao.modificaDati(risposta);
			rispostaDao.modificaDati(risposta1);
			risposte=rispostaDao.recuperaTutto();
			for(Object ogg:risposte) {
				Risposta rispostaOgg=(Risposta)ogg;
				if(rispostaOgg.getId()==risposta.getId()){
					assertEquals("like",rispostaOgg.getValutazione());
				}
				
				if(rispostaOgg.getId()==risposta1.getId()){
					assertEquals("SI!!!!",rispostaOgg.getVis());
				}
				
			}
			
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test5CancellaDati() {
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
			ArrayList<Object>risposte=rispostaDao.recuperaTutto();
			Risposta aiuto=(Risposta) risposte.get(risposte.size()-2);
			risposta.setId(aiuto.getId());
			Risposta aiuto1=(Risposta) risposte.get(risposte.size()-1);
			risposta1.setId(aiuto1.getId());
			rispostaDao.cancellaDati(risposta);
			rispostaDao.cancellaDati(risposta1);
			assertEquals(false,rispostaDao.recuperaDati(risposta));
			assertEquals(false,rispostaDao.recuperaDati(risposta1));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public static Test suite() {
		return new TestSuite(RispostaDaoImpTest.class);
	}
}
