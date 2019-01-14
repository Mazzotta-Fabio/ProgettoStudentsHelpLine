package testingIntegrazione;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import gestionedomanda.GestioneDomanda;
import gestionedomanda.ImpGestioneDomanda;
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
		assertEquals(2,domande.size()/4);
	}
	
	public void test0ScaricaAllegato() {
		try {
			String s = "C:\\Users\\Antonio\\Desktop\\Documenti\\web\\File\\WebContent\\Immagine\\thumb-1920-737143.png";
			gestioneDomanda.scaricaAllegato(s);
			File f = new File("C:\\Users\\Antonio\\Downloads\\thumb-1920-737143.png");
			assertEquals(true,f.exists());
			
			
		}
		catch(IOException e) {
			fail("Errore scaricamento file");
		}
		
	}
	
	public static Test suite() {
		return new TestSuite(ImpGestioneDomandaTest.class);
	}
	
}
