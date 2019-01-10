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
	
	public void testEliminaDomanda() {
		List<String>domande=gestioneDomanda.recuperaDomandeSenzaRisposta("EMAIL");
		List<String>domandeRisposte=gestioneDomanda.recuperaDomandeConRisposta("EMAIL");
		int somma=domande.size()+domandeRisposte.size();
		gestioneDomanda.eliminaDomanda(somma-1);
		gestioneDomanda.eliminaDomanda(somma-2);
		domande=gestioneDomanda.recuperaDomandeSenzaRisposta("EMAIL");
		domandeRisposte=gestioneDomanda.recuperaDomandeConRisposta("EMAIL");
		int sommaResidua=domande.size()+domandeRisposte.size();
		assertEquals(somma-2,sommaResidua);
	}
	public void testRecuperaDomandaSenzaRisposta() {
		List<String>domande=gestioneDomanda.recuperaDomandeSenzaRisposta("EMAIL");
		assertEquals(domande.size(),6);
	}
	public void testRecuperaDomandaConRisposta() {
		List<String>domande=gestioneDomanda.recuperaDomandeConRisposta("EMAIL");
		assertEquals(domande.size(),6);
	}
	
	public static Test suite() {
		return new TestSuite(ImpGestioneDomandaTest.class);
	}
	
}
