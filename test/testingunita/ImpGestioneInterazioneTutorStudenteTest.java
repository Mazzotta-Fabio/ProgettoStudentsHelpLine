package testingunita;

import classicomuni.Tutor;
import gestionedomanda.GestioneDomanda;
import gestionedomanda.ImpGestioneDomanda;
import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import java.io.File;
import java.io.IOException;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImpGestioneInterazioneTutorStudenteTest extends TestCase {
  private GestioneInterazioneTutorStudente gestioneInterazione;
  
  public void setUp() {
    gestioneInterazione = new ImpGestioneInterazioneTutorStudente();
  }
  
  public void tearDown() {
    gestioneInterazione = null;
  }
  
  public void test1InserisciDomanda() {
    GestioneDomanda gestDom = new ImpGestioneDomanda();
    gestioneInterazione.inserisciDomanda("OGGETTO","TESTO","URL", "fabio.mazzotta@unisa.it", 
        "antonio.cimino@studenti.unisa.it");
    gestioneInterazione.inserisciDomanda("OGGETTO 1", "TESTO 1", "URL 2", 
        "francesco.verdi@unisa.it","antonio.derita@studenti.unisa.it");
    List<String> domande1 = 
        gestDom.recuperaDomandeSenzaRisposta("antonio.cimino@studenti.unisa.it");
    List<String> domande2 = 
        gestDom.recuperaDomandeSenzaRisposta("antonio.derita@studenti.unisa.it");
    List<String> domanda1 = 
        gestDom.visualizzaDomanda(Integer.parseInt(domande1.get(domande1.size() - 4)),"Tutor");
    List<String> domanda2 = 
        gestDom.visualizzaDomanda(Integer.parseInt(domande2.get(domande2.size() - 4)),"Studente");
    for (int i = 0;i < domanda1.size() - 1;i++) {
      String d = domanda1.get(i);
      switch (i) {
        case 1:
          assertEquals("OGGETTO",d);
          break;
        case 2:
          assertEquals("TESTO",d);
          break;
        case 3:
          assertEquals("URL",d);
          break;
        default:
          break;
      }
    }
    for (int j = 0;j < domanda2.size() - 1;j++) {
      String d = domanda2.get(j);
      switch (j) {
        case 1:
          assertEquals("OGGETTO 1",d);
          break;
        case 2:
          assertEquals("TESTO 1",d);
          break;
        case 3:
          assertEquals("URL 2",d);
          break;
        default:
          break;
      }
    }
  }
  
  public void test2InserisciRisposta() {
    GestioneDomanda gestDom = new ImpGestioneDomanda();
    gestioneInterazione.inserisciRisposta("TESTO", 6, "URL");
    gestioneInterazione.inserisciRisposta("TESTO 1", 7, "URL 2");
    List<String> domande = gestDom.visualizzaDomanda(6,"Studente");
    List<String> domande2 = gestDom.visualizzaDomanda(7,"Tutor");
    for (int i = 0;i < domande.size() - 1;i++) {
      String d = domande.get(i);
      switch (i) {
        case 6:
          assertEquals("TESTO",d);
          break;
        case 7:
          assertEquals("URL",d);
          break;
        default:
          break;
      }
    }
    for (int j = 0;j < domande2.size() - 1;j++) {
      String d1 = domande2.get(j);
      switch (j) {
        case 6:
          assertEquals("TESTO 1",d1);
          break;
        case 7:
          assertEquals("URL 2",d1);
          break;
        default:
          break;
      }
    }
  }
  
  public void test3ValutaRisposta() {
    gestioneInterazione.valutaRisposta(2, "like");
    gestioneInterazione.valutaRisposta(3, "dislike");
    GestioneDomanda gestDom = new ImpGestioneDomanda();
    List<String> domande1 = gestDom.visualizzaDomanda(1,"Tutor");
    List<String> domande2 = gestDom.visualizzaDomanda(2,"Studente");
    for (int i = 0;i < domande1.size() - 1;i++) {
      String d = domande1.get(i);
      switch (i) {
        case 8:
          assertEquals("like",d);
          break;
        default:
          break;
      }
    }
    for (int j = 0;j < domande2.size();j++) {
      String d1 = domande2.get(j);
      switch (j) {
        case 8:
          assertEquals("dislike",d1);
          break;
        default:
          break;
      }
    }
  }
  
  public void test4VisualizzaAccount() {
    Tutor tutor = new Tutor("Fabio","Mazzotta","fabio.mazzotta@unisa.it","3452128996","/home/xyz",
        "3452128996","matematica","86","Laurea Triennale");
    Tutor ogg = (Tutor)gestioneInterazione.visualizzaAccount(tutor.getEmail());
    assertEquals(ogg.getNome(),tutor.getNome());
    assertEquals(ogg.getCognome(),tutor.getCognome());
    assertEquals(ogg.getNumeroDiCellulare(),tutor.getNumeroDiCellulare());
  }
  
  public void test5ValutazioniTot() {
    int [] valutazioni = gestioneInterazione.valutazioniTot("federico.coiro@unisa.it");
    assertEquals(valutazioni[0],0);
    assertEquals(valutazioni[1],1);
  }
  
  public void test6ListaTutor() {
    List<String> tutors = gestioneInterazione.listaTutor("Analisi1");
    for (int i = 0;i < tutors.size();i++) {
      String d = tutors.get(i);
      switch (i) {
        case 0:
          assertEquals("Fabio",d);
          break;
        default:
          break;
      }
    }
  }
  
  public void test0DomandeDaVisualizzare() {
    boolean notifica = gestioneInterazione.domandeDaVisualizzare(
        "antonio.derita@studenti.unisa.it","Studente");
    assertEquals(false,notifica);
    notifica = gestioneInterazione.domandeDaVisualizzare("ines.votta@studenti.unisa.it", 
        "Studente");
    assertEquals(true,notifica);
    notifica = gestioneInterazione.domandeDaVisualizzare("fabio.mazzotta@unisa.it", "Tutor");
    assertEquals(true,notifica);
    notifica = gestioneInterazione.domandeDaVisualizzare("federico.coiro@unisa.it", "Tutor");
    assertEquals(false,notifica);
  }
  
  public void test7Upload() {
    String file = "agg_Account.png";
    try {
      gestioneInterazione.upload(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
    File f = new File("C:\\Users\\Antonio\\git\\ProgettoStudentsHelpLine\\WebContent\\img"
        + "\\agg_Account.png");
    assertEquals(true,f.exists());
  }
  
  public static Test suite() {
    return new TestSuite(ImpGestioneInterazioneTutorStudenteTest.class);
  }
}
