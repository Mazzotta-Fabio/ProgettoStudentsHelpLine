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
			assertEquals(false,rispostaDao.recuperaDati(risposta));
			assertEquals(false,rispostaDao.recuperaDati(risposta1));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test3RecuperaTutto() {
		try {
			ArrayList<Object>rispostaObject=rispostaDao.recuperaTutto();
			assertEquals(9,rispostaObject.size());
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
