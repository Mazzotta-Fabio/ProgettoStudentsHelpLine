package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import classiComuni.Studente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.StudenteDAOImp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	
	public void test2InserisciDati() {
		try {
			studenteDAO.inserisciDati(studente);
			studenteDAO.inserisciDati(studente2);
			assertEquals(true,studenteDAO.recuperaDati(studente));
			assertEquals(true,studenteDAO.recuperaDati(studente2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test1RecuperaDati() {
		try {
			assertEquals(false,studenteDAO.recuperaDati(studente));
			assertEquals(false,studenteDAO.recuperaDati(studente2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test3RecuperaTutto() {
		try {
			ArrayList<Object>studentiObject=studenteDAO.recuperaTutto();
			assertEquals(studentiObject.size(),6);
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	
	public void test4ModificaDati() {
		try {
			studente.setNome("Gianluca");
			studente2.setMatricola("0512100001");
			studenteDAO.modificaDati(studente);
			studenteDAO.modificaDati(studente2);
			ArrayList<Object>studenti=studenteDAO.recuperaTutto();
			for(Object ogg:studenti) {
				Studente studenteOgg=(Studente)ogg;
				if(studenteOgg.getEmail().equals(studente.getEmail())){
					assertEquals(studenteOgg.getNome(),"Gianluca");
				}
				if(studenteOgg.getEmail().equals(studente2.getEmail())){
					assertEquals(studenteOgg.getMatricola(),"0512100001");
				}
			}
			
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test5CancellaDati() {
		try {
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
