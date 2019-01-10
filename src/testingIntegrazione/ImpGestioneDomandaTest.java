package testingIntegrazione;

import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import gestioneDomanda.GestioneDomanda;
import gestioneDomanda.ImpGestioneDomanda;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImpGestioneDomandaTest extends TestCase {
	
	private GestioneDomanda gestioneDomanda;
	
	public void setUp() {
		gestioneDomanda=new ImpGestioneDomanda();
	}
	
	public void tearDown(){
		gestioneDomanda=null;
	}
	
	public void test3EliminaDomanda() {
		List<String> domandeSR = gestioneDomanda.recuperaDomandeSenzaRisposta("antonio.cimino@studenti.unisa.it");
		List<String> domandeR = gestioneDomanda.recuperaDomandeConRisposta("antonio.cimino@studenti.unisa.it");
		int somma = (domandeSR.size()/4) + (domandeSR.size()/4);
		gestioneDomanda.eliminaDomanda(Integer.parseInt(domandeSR.get(0)));
		gestioneDomanda.eliminaDomanda(Integer.parseInt(domandeR.get(0)));
		domandeSR = gestioneDomanda.recuperaDomandeSenzaRisposta("antonio.cimino@studenti.unisa.it");
		domandeR = gestioneDomanda.recuperaDomandeConRisposta("antonio.cimino@studenti.unisa.it");
		int sommaResidua = (domandeSR.size()/4) + (domandeSR.size()/4);
		assertEquals(somma-2,sommaResidua);
	}
	
	public void test1RecuperaDomandaSenzaRisposta() {
		List<String> domande = gestioneDomanda.recuperaDomandeSenzaRisposta("antonio.cimino@studenti.unisa.it");
		assertEquals(1,domande.size()/4);
	}
	
	public void test2RecuperaDomandaConRisposta() {
		List<String> domande = gestioneDomanda.recuperaDomandeConRisposta("antonio.cimino@studenti.unisa.it");
		assertEquals(1,domande.size()/4);
	}
	
	public static Test suite() {
		return new TestSuite(ImpGestioneDomandaTest.class);
	}
	
}
