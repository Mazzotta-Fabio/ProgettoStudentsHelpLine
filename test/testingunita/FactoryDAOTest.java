package testingunita;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.*;

public class FactoryDAOTest extends TestCase {
  private FactoryDao factory;
  
  protected void setUp() throws Exception {
    factory = new FactoryDao();
  }

  protected void tearDown() throws Exception {
    factory = null;
  }

  public void testGetObject() {
    ObjectDao tutorDao = new TutorDaoImp();
    assertEquals(tutorDao.getClass(),factory.getObject("Tutor").getClass());
    ObjectDao studenteDao = new StudenteDaoImp();
    assertEquals(studenteDao.getClass(),factory.getObject("Studente").getClass());
    ObjectDao domandaDao = new DomandaDaoImp();
    assertEquals(domandaDao.getClass(),factory.getObject("Domanda").getClass());
    ObjectDao rispostaDao = new RispostaDaoImp();
    assertEquals(rispostaDao.getClass(),factory.getObject("Risposta").getClass());
  }

  public static Test suite() {
    return new TestSuite(FactoryDAOTest.class);
  }
}
