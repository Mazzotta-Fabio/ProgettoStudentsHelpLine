package testingUnità;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.*;

public class FactoryDAOTest extends TestCase {
	private FactoryDAO factory;
	protected void setUp() throws Exception {
		factory=new FactoryDAO();
	}

	protected void tearDown() throws Exception {
		factory=null;
	}
	
	public void testGetObject() {
		ObjectDAO rispostaDAO=new RispostaDAOImp();
		ObjectDAO domandaDAO=new DomandaDAOImp();
		ObjectDAO tutorDAO=new TutorDAOImp();
		ObjectDAO studenteDAO=new StudenteDAOImp();
		assertEquals(tutorDAO.getClass(),factory.getObject("Tutor").getClass());
		assertEquals(studenteDAO.getClass(),factory.getObject("Studente").getClass());
		assertEquals(domandaDAO.getClass(),factory.getObject("Domanda").getClass());
		assertEquals(rispostaDAO.getClass(),factory.getObject("Risposta").getClass());
	}
	
	public static Test suite() {
		return new TestSuite(FactoryDAOTest.class);
	}
}
