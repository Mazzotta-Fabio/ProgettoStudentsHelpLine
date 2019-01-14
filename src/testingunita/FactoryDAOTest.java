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
		factory=null;
	}
	
	public void testGetObject() {
		ObjectDao rispostaDAO=new RispostaDaoImp();
		ObjectDao domandaDAO=new DomandaDaoImp();
		ObjectDao tutorDAO=new TutorDaoImp();
		ObjectDao studenteDAO=new StudenteDaoImp();
		assertEquals(tutorDAO.getClass(),factory.getObject("Tutor").getClass());
		assertEquals(studenteDAO.getClass(),factory.getObject("Studente").getClass());
		assertEquals(domandaDAO.getClass(),factory.getObject("Domanda").getClass());
		assertEquals(rispostaDAO.getClass(),factory.getObject("Risposta").getClass());
	}
	
	public static Test suite() {
		return new TestSuite(FactoryDAOTest.class);
	}
}
