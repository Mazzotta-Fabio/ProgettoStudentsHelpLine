package testingIntegrazione;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import classiComuni.Tutor;
import gestioneDomanda.GestioneDomanda;
import gestioneDomanda.ImpGestioneDomanda;
import gestioneInterazioneTutorStudente.GestioneInterazioneTutorStudente;
import gestioneInterazioneTutorStudente.ImpGestioneInterazioneTutorStudente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImpGestioneInterazioneTutorStudenteTest extends TestCase {
	
	private GestioneInterazioneTutorStudente gestioneInterazione;
	
	public void setUp() {
		gestioneInterazione=new ImpGestioneInterazioneTutorStudente();
	}
	
	public void tearDown() {
		gestioneInterazione=null;
	}
	
	public void testInserisciDomanda() {
		GestioneDomanda gestDom=new ImpGestioneDomanda();
		gestioneInterazione.inserisciDomanda("OGGETTO","TESTO","URL", "EMAIL TUTOR", "EMAIL STUDENTE");
		gestioneInterazione.inserisciDomanda("OGGETTO 1", "TESTO 1", "URL 2", "EMAIL TUTOR1", "EMAIL STUDENTE2");
		List<String> domande=gestDom.visualizzaDomanda(0,"EMAIL TUTOR");
		List<String> domande2=gestDom.visualizzaDomanda(1,"EMAIL TUTOR1");
		for(int i=0;i<domande.size();i++) {
			String d=domande.get(i);
			switch(i) {
			case 0:
				assertEquals("EMAIL STUDENTE",d);
				break;
			case 1:
				assertEquals("OGGETTO",d);
				break;
			case 2:
				assertEquals("TESTO",d);
				break;
			case 3:
				assertEquals("URL",d);
				break;
			}
		}
		for(int j=0;j<domande2.size();j++) {
			String d=domande2.get(j);
			switch(j) {
			case 0:
				assertEquals("EMAIL STUDENTE 2",d);
				break;
			case 1:
				assertEquals("OGGETTO 1",d);
				break;
			case 2:
				assertEquals("TESTO 1",d);
				break;
			case 3:
				assertEquals("URL 2",d);
				break;
			}
		}
	}
	
	public void testInserisciRisposta() {
		GestioneDomanda gestDom=new ImpGestioneDomanda();
		gestioneInterazione.inserisciRisposta("TESTO", 0, "URL");
		gestioneInterazione.inserisciRisposta("TESTO 1", 1, "URL 2");
		List<String> domande=gestDom.visualizzaDomanda(0,"EMAIL TUTOR");
		List<String> domande2=gestDom.visualizzaDomanda(1,"EMAIL TUTOR1");
		for(int i=0;i<domande.size();i++) {
			String d=domande.get(i);
			switch(i) {
			case 4:
				assertEquals("0",d);
				break;
			case 6:
				assertEquals("TESTO",d);
				break;
			case 7:
				assertEquals("URL",d);
				break;
			}
		}
		for(int j=0;j<domande2.size();j++) {
			String d1=domande2.get(j);
			switch(j) {
			case 4:
				assertEquals("1",d1);
				break;
			case 6:
				assertEquals("TESTO 1",d1);
				break;
			case 7:
				assertEquals("URL 2",d1);
				break;
			}
		}
	}
	
	public void testValutaRisposta() {
		gestioneInterazione.valutaRisposta(2, "like");
		gestioneInterazione.valutaRisposta(1, "unlike");
		GestioneDomanda gestDom=new ImpGestioneDomanda();
		List<String> domande=gestDom.visualizzaDomanda(2,"EMAIL TUTOR");
		List<String> domande2=gestDom.visualizzaDomanda(1,"EMAIL TUTOR1");
		for(int i=0;i<domande.size();i++) {
			String d=domande.get(i);
			switch(i) {
			case 8:
				assertEquals("like",d);
				break;
			}
		}
		for(int j=0;j<domande2.size();j++) {
			String d1=domande2.get(j);
			switch(j) {
			case 8:
				assertEquals("unlike",d1);
				break;
			}
		}
	}
	
	public void testVisualizzaAccount() {
		Tutor tutor=new Tutor("Mario","Rossi","fabio.mazzotta@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
		Tutor ogg=(Tutor)gestioneInterazione.visualizzaAccount(tutor.getEmail());
		assertEquals(ogg.getNome(),tutor.getNome());
		assertEquals(ogg.getCognome(),tutor.getCognome());
		assertEquals(ogg.getNumeroDiCellulare(),tutor.getNumeroDiCellulare());
	}
	
	public void testValutazioniTot() {
		int [] valutazioni=gestioneInterazione.valutazioniTot("EMAIL");
		assertEquals(valutazioni[0],45);
		assertEquals(valutazioni[1],52);
	}
	
	public void testListaTutor() {
		List<String> tutors=gestioneInterazione.listaTutor("Programmazione 1");
		for(int i=0;i<tutors.size();i++) {
			String d=tutors.get(i);
			switch(i) {
			case 0:
				assertEquals("MARIO",d);
				break;
			case 1:
				assertEquals("ROSSI",d);
				break;
			}
		}
	}
	public static Test suite() {
		return new TestSuite(ImpGestioneInterazioneTutorStudenteTest.class);
	}
	
}
