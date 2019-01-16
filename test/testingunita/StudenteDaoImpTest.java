package testingunita;

import classicomuni.Studente;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import storage.StudenteDaoImp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudenteDaoImpTest extends TestCase {
  private Studente studente;
  private Studente studente2;
  private StudenteDaoImp studenteDao;

  public void setUp() {
    studente = new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
    studente2 = new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o",
         "0512102515","1");
    studenteDao = new StudenteDaoImp();
  }
  
  public void tearDown() {
    studente = null;
    studente2 = null;
    studenteDao = null;
  }

  public void test2InserisciDati() {
    try {
      studenteDao.inserisciDati(studente);
      studenteDao.inserisciDati(studente2);
      assertEquals(true,studenteDao.recuperaDati(studente));
      assertEquals(true,studenteDao.recuperaDati(studente2));
    } catch (SQLException e) {
      fail("Errore di connessione");
    }
  }

  public void test1RecuperaDati() {
    try {
      assertEquals(false,studenteDao.recuperaDati(studente));
      assertEquals(false,studenteDao.recuperaDati(studente2));
    } catch (SQLException e) {
      fail("Errore di connessione");
    }
  }

  public void test3RecuperaTutto() {
    try {
      ArrayList<Object> studentiObject = studenteDao.recuperaTutto();
      assertEquals(studentiObject.size(),6);
    } catch (SQLException e) {
      fail("Errore di connessione");
    }
  }

  public void test4ModificaDati() {
    try {
      studente.setNome("Gianluca");
      studente2.setMatricola("0512100001");
      studenteDao.modificaDati(studente);
      studenteDao.modificaDati(studente2);
      ArrayList<Object> studenti = studenteDao.recuperaTutto();
      for (Object ogg:studenti) {
        Studente studenteOgg = (Studente)ogg;
        if (studenteOgg.getEmail().equals(studente.getEmail())) {
          assertEquals(studenteOgg.getNome(),"Gianluca");
        }
        if (studenteOgg.getEmail().equals(studente2.getEmail())) {
          assertEquals(studenteOgg.getMatricola(),"0512100001");
        }
      }
    } catch (SQLException e) {
      fail("Errore di connessione");
    }
  }

  public void test5CancellaDati() {
    try {
      studenteDao.cancellaDati(studente2);
      studenteDao.cancellaDati(studente);
      assertEquals(false,studenteDao.recuperaDati(studente));
      assertEquals(false,studenteDao.recuperaDati(studente2));
    } catch (SQLException e) {
      fail("Errore di connessione");
    }
  }

  public static Test suite() {
    return new TestSuite(StudenteDaoImpTest.class);
  }
}
