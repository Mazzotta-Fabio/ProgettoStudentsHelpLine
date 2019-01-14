package testingintegrazione;

import classicomuni.Studente;
import classicomuni.Tutor;
import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import gestioneutente.ImpGestioneUtente;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImpGestioneUtenteTest extends TestCase {
  private Tutor tutor1;
  private Tutor tutor2;
  private Studente studente1;
  private Studente studente2;
  private ImpGestioneUtente gestioneUtente;
  
  protected void setUp() throws Exception {
    tutor1 = new Tutor("Mario","Rossi","mario.rossi@gmail.com","12345678","/home/xyz","1234567891",
        "matematica","86","Laurea Triennale");
    tutor2 = new Tutor("Ezechiele","Nuvola","ezechiele.nuvola@gmail.com","1234567845","/home/xyz/o",
        "1234567891","progrmmazione 2","108","Dottorato di ricerca");
    studente1 = new Studente("Rosa","Marini","rosa.marini@gmail.com","12345678","/home/xyz",
        "0522500518","2");
    studente2 = new Studente("Chiara","Giani","chiara.giani@gmail.com","123456err","/home/xyz/o",
        "0512102515","1");
    gestioneUtente = new ImpGestioneUtente();
  }
  
  protected void tearDown() throws Exception {
    tutor1 = null;
    tutor2 = null;
    studente1 = null;
    studente2 = null;
    gestioneUtente = null;
  }
  
  public void test1RegistrazioneAccount() {
    try {
      gestioneUtente.registraAccount("Tutor",tutor1.getNome(),tutor1.getCognome(),tutor1.getEmail(),
          tutor1.getPassword(),tutor1.getLinkImmagine(),tutor1.getVotoDiLaurea(),
          tutor1.getMateriaDiCompetenza(),tutor1.getNumeroDiCellulare(),tutor1.getTitoloDiStudio());
      gestioneUtente.registraAccount("Tutor",tutor2.getNome(),tutor2.getCognome(),tutor2.getEmail(),
          tutor2.getPassword(),tutor2.getLinkImmagine(),tutor2.getVotoDiLaurea(),
          tutor2.getMateriaDiCompetenza(),tutor2.getNumeroDiCellulare(),tutor2.getTitoloDiStudio());
      gestioneUtente.registraAccount("Studente",studente1.getNome(),studente1.getCognome(),
          studente1.getEmail(),studente1.getPassword(),studente1.getLinkImmagine(),
          studente1.getMatricola(),studente1.getAnnoCorso(),null,null);
      gestioneUtente.registraAccount("Studente",studente2.getNome(),studente2.getCognome(),
          studente2.getEmail(),studente2.getPassword(),studente2.getLinkImmagine(),
          studente2.getMatricola(),studente2.getAnnoCorso(),null,null);
      GestioneInterazioneTutorStudente gestioneInterazione = 
              new ImpGestioneInterazioneTutorStudente();
      gestioneInterazione.inserisciDomanda("OGGETTO","TESTO","URL", tutor1.getEmail(), 
          studente1.getEmail());
      gestioneInterazione.inserisciDomanda("OGGETTO","TESTO","URL", tutor2.getEmail(), 
          studente2.getEmail());
      Studente st = (Studente)gestioneUtente.infoAccount(studente1.getEmail(), "Studente");
      Studente st2 = (Studente)gestioneUtente.infoAccount(studente2.getEmail(), "Studente");
      Tutor st3 = (Tutor)gestioneUtente.infoAccount(tutor1.getEmail(), "Tutor");
      assertEquals(studente1.getNome(),st.getNome());
      assertEquals(studente2.getNome(),st2.getNome());
      assertEquals(tutor1.getNome(),st3.getNome());
      Tutor st4 = (Tutor)gestioneUtente.infoAccount(tutor2.getEmail(), "Tutor");
      assertEquals(tutor2.getNome(),st4.getNome());
    } catch (IOException e) {
      fail("Connessione interrotta");
    }
  }
  
  public void test2LoginAccount() {
    Tutor t = null;
    t = (Tutor) gestioneUtente.loginAccount(tutor1.getEmail(),tutor1.getPassword(), "Tutor");
    assertEquals("Mario",t.getNome());
    assertEquals("Rossi",t.getCognome());
    t = (Tutor) gestioneUtente.loginAccount(tutor2.getEmail(),tutor2.getPassword(), "Tutor");
    assertEquals("Ezechiele",t.getNome());
    assertEquals("Nuvola",t.getCognome());
    Studente s = null;
    s = (Studente) gestioneUtente.loginAccount(studente1.getEmail(),studente1.getPassword(),
        "Studente");
    assertEquals("Rosa",s.getNome());
    assertEquals("Marini",s.getCognome());
    s = (Studente) gestioneUtente.loginAccount(studente2.getEmail(),studente2.getPassword(),
        "Studente");
    assertEquals("Chiara",s.getNome());
    assertEquals("Giani",s.getCognome());
  }
  
  public void test3RecuperaPassword() {
    String password;
    password = gestioneUtente.recuperaPassword("Tutor", tutor1.getEmail());
    assertEquals("12345678",password);
    password = gestioneUtente.recuperaPassword("Tutor", tutor2.getEmail());
    assertEquals("1234567845",password);
    password = gestioneUtente.recuperaPassword("Studente", studente1.getEmail());
    assertEquals("12345678",password);
    password = gestioneUtente.recuperaPassword("Studente", studente2.getEmail());
    assertEquals("123456err",password);
  }
  
  public void test4ModificaAccount() {
    try {
      gestioneUtente.modificaAccount("Tutor",tutor1.getNome(),"Russo",tutor1.getEmail(),
          tutor1.getPassword(),tutor1.getLinkImmagine(),tutor1.getVotoDiLaurea(),
          tutor1.getMateriaDiCompetenza(),tutor1.getNumeroDiCellulare(),tutor1.getTitoloDiStudio());
      gestioneUtente.modificaAccount("Tutor","Matteo",tutor2.getCognome(),tutor2.getEmail(),
          tutor2.getPassword(),tutor2.getLinkImmagine(),tutor2.getVotoDiLaurea(),
          tutor2.getMateriaDiCompetenza(),tutor2.getNumeroDiCellulare(),tutor2.getTitoloDiStudio());
      gestioneUtente.modificaAccount("Studente",studente1.getNome(),"Mozzillo",studente1.getEmail(),
          studente1.getPassword(),studente1.getLinkImmagine(),studente1.getMatricola(),
          studente1.getAnnoCorso(),null,null);
      gestioneUtente.modificaAccount("Studente","Giorgia",studente2.getCognome(),
          studente2.getEmail(),studente2.getPassword(),studente2.getLinkImmagine(),
          studente2.getMatricola(),studente2.getAnnoCorso(),null,null);
      Studente st = (Studente)gestioneUtente.infoAccount(studente1.getEmail(), "Studente");
      Studente st2 = (Studente)gestioneUtente.infoAccount(studente2.getEmail(), "Studente");
      Tutor st3 = (Tutor)gestioneUtente.infoAccount(tutor1.getEmail(), "Tutor");
      assertEquals("Mozzillo",st.getCognome());
      assertEquals("Giorgia",st2.getNome());
      assertEquals("Russo",st3.getCognome());
      Tutor st4 = (Tutor)gestioneUtente.infoAccount(tutor2.getEmail(), "Tutor");
      assertEquals("Matteo",st4.getNome());
    } catch (IOException e) {
      fail("Connessione interrotta");
    }
  }
  
  public void test5EliminaAccount() {
    gestioneUtente.eliminaAccount(tutor1.getEmail(), "Tutor");
    gestioneUtente.eliminaAccount(studente2.getEmail(), "Studente");
    gestioneUtente.eliminaAccount(tutor2.getEmail(), "Tutor");
    gestioneUtente.eliminaAccount(studente1.getEmail(), "Studente");
    Studente st = (Studente)gestioneUtente.infoAccount(studente1.getEmail(), "Studente");
    Studente st2 = (Studente)gestioneUtente.infoAccount(studente2.getEmail(), "Studente");
    Tutor st3 = (Tutor)gestioneUtente.infoAccount(tutor1.getEmail(), "Tutor");
    assertEquals(null,st.getNome());
    assertEquals(null,st2.getNome());
    assertEquals(null,st3.getNome());
    Tutor st4 = (Tutor)gestioneUtente.infoAccount(tutor2.getEmail(), "Tutor");
    assertEquals(null,st4.getNome());
  }
  
  public static Test suite() {
    return new TestSuite(ImpGestioneUtenteTest.class);
  }

}

