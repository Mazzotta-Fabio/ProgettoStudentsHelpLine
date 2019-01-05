package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;
import classiComuni.Risposta;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.RispostaDAOImp;

public class RispostaDaoImpTest extends TestCase{
	private Risposta risposta;
	private Risposta risposta1;
	private RispostaDAOImp rispostaDao;
	public void setUp() throws Exception {
		risposta=new Risposta(0,"CIAOIOIO","allegato","ON","SI");
		risposta1=new Risposta(0,"CIAOIOIO","allegato","ON","SI");
		rispostaDao=new RispostaDAOImp();
	}

	public void tearDown() throws Exception {
		risposta=null;
		risposta1=null;
		rispostaDao=null;
	}
	
	public void testInserisciDati() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			*/
			rispostaDao.inserisciDati(risposta);
			rispostaDao.inserisciDati(risposta1);
			assertEquals(true,rispostaDao.recuperaDati(risposta));
			assertEquals(true,rispostaDao.recuperaDati(risposta1));
	
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
			*/
			assertEquals(false,rispostaDao.recuperaDati(risposta));
			assertEquals(false,rispostaDao.recuperaDati(risposta1));
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
			*/
			ArrayList<Object>rispostaObject=rispostaDao.recuperaTutto();
			System.out.println(rispostaObject.size());
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
	
	public void testCancellaDati() {
		try {
			/*
			Risposta risposta=new Risposta(5000,"CIAOIOIO","allegato","ON");
			Risposta risposta1=new Risposta(5001,"CIAOIOIO","allegato","ON");
			*/
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
