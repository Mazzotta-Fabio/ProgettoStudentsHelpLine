package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.DomandaDAOImp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DomandaDAOImpTest extends TestCase {
	private Domanda domanda;
	private Domanda domanda2;
	private DomandaDAOImp domandaDao;
	protected void setUp() throws Exception {
		Risposta risposta=new Risposta(1,"CIAOIOIO","allegato","ON","SI");
		Risposta risposta1=new Risposta(2,"CIAOIOIO","allegato","ON","SI");
		Tutor tutor=new Tutor("Mario","Rossi","fabio.mazzotta@unisa.it","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
		Tutor tutor2=new Tutor("Ezechiele","Nuvola","federico.coiro@unisa.it","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
		Studente studente=new Studente("Rosa","Marini","antonio.derita@studenti.unisa.it","12345678","/home/xyz","0522500518","2");
		Studente studente2=new Studente("Chiara","Giani","ines.votta@studenti.unisa.it","123456err","/home/xyz/o","0512102515","1");
		domanda=new Domanda(0,"CIAO","OGGETTO","ALLEGATO",studente,tutor,risposta,"NO");
		domanda2=new Domanda(0,"Giani","giani@gmail.com","ALLEGATO",studente2,tutor2,risposta1,"NO");
		domandaDao=new DomandaDAOImp();
	}

	protected void tearDown() throws Exception {
		domanda=null;
		domanda2=null;
		domandaDao=null;
	}
	
	public void test2InserisciDati() {
		try {
			domandaDao.inserisciDati(domanda);
			domandaDao.inserisciDati(domanda2);
			ArrayList<Object>domande=domandaDao.recuperaTutto();
			Domanda aiuto=(Domanda) domande.get(domande.size()-1);
			domanda2.setId(aiuto.getId());
			Domanda aiuto1=(Domanda) domande.get(domande.size()-2);
			domanda.setId(aiuto1.getId());
			assertEquals(true,domandaDao.recuperaDati(domanda));
			assertEquals(true,domandaDao.recuperaDati(domanda2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test1RecuperaDati() {
		try {
			assertEquals(false,domandaDao.recuperaDati(domanda));
			assertEquals(false,domandaDao.recuperaDati(domanda2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test3RecuperaTutto() {
		try {
			ArrayList<Object>domandeObject=domandaDao.recuperaTutto();
			assertEquals(9,domandeObject.size());
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test4ModificaDati() {
		try {
			ArrayList<Object>domande=domandaDao.recuperaTutto();
			Domanda aiuto=(Domanda) domande.get(domande.size()-1);
			domanda2.setId(aiuto.getId());
			Domanda aiuto1=(Domanda) domande.get(domande.size()-2);
			domanda.setId(aiuto1.getId());
			domanda.setVis("SI?");
			domanda2.setVis("SI?!");
			domandaDao.modificaDati(domanda);
			domandaDao.modificaDati(domanda2);
			domande=domandaDao.recuperaTutto();
			for(Object ogg:domande) {
				Domanda domandaOgg=(Domanda)ogg;
				if(domandaOgg.getId()==domanda.getId()){
					assertEquals("SI?",domandaOgg.getVis());
				}
				
				if(domandaOgg.getId()==domanda2.getId()){
					assertEquals("SI?!",domandaOgg.getVis());
				}
				
			}
			
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test5CancellaDati() {
		try {
			ArrayList<Object>domande=domandaDao.recuperaTutto();
			Domanda aiuto=(Domanda) domande.get(domande.size()-1);
			domanda2.setId(aiuto.getId());
			Domanda aiuto1=(Domanda) domande.get(domande.size()-2);
			domanda.setId(aiuto1.getId());
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
