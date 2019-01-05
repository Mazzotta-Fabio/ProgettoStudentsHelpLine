package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;

import classiComuni.Studente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.StudenteDAOImp;

public class StudenteDAOImpTest extends TestCase {
	private Studente studente;
	private Studente studente2;
	private StudenteDAOImp studenteDAO;
	
	public void setUp() {
		studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
		studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
		studenteDAO=new StudenteDAOImp();
	}
	public void tearDown() {
		studente=null;
		studente2=null;
		studenteDAO=null;
	}
	
	public void testInserisciDati() {
		try {
			/*
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			*/
			studenteDAO.inserisciDati(studente);
			studenteDAO.inserisciDati(studente2);
			assertEquals(true,studenteDAO.recuperaDati(studente));
			assertEquals(true,studenteDAO.recuperaDati(studente2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void testRecuperaDati() {
		try {
			/*
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			*/
			assertEquals(false,studenteDAO.recuperaDati(studente));
			assertEquals(false,studenteDAO.recuperaDati(studente2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void testRecuperaTutto() {
		try {
			/*
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			*/
			ArrayList<Object>studentiObject=studenteDAO.recuperaTutto();
			//System.out.println(studentiObject.size());
			assertEquals(studentiObject.size(),4);
			/*
			for(Object o:studentiObject) {
				Studente t=(Studente)o;
				assertEquals(studente,t);
				assertEquals(studente2,t);
			}
			*/
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void testCancellaDati() {
		try {
			/*
			Studente studente=new Studente("Rosa","Marini","rm@gmail.com","12345678","/home/xyz","0522500518","2");
			Studente studente2=new Studente("Chiara","Giani","giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
			*/
			studenteDAO.cancellaDati(studente2);
			studenteDAO.cancellaDati(studente);
			assertEquals(false,studenteDAO.recuperaDati(studente));
			assertEquals(false,studenteDAO.recuperaDati(studente2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public static Test suite() {
		return new TestSuite(StudenteDAOImpTest.class);
	}
}
