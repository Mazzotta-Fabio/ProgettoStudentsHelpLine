package testingUnità;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import classiComuni.Tutor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.TutorDAOImp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorDAOImpTest extends TestCase {
	private Tutor tutor;
	private Tutor tutor2;
	private TutorDAOImp tutorDAO;
	
	public void setUp() {
		tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
		tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
		tutorDAO=new TutorDAOImp();
	}
	public void tearDown() {	
		tutor=null;
		tutor2=null;
		tutorDAO=null;
	}
	
	
	public void test2InserisciDati() {
		try {
			/*
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			*/
			tutorDAO.inserisciDati(tutor);
			tutorDAO.inserisciDati(tutor2);
			assertEquals(true,tutorDAO.recuperaDati(tutor));
			assertEquals(true,tutorDAO.recuperaDati(tutor2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test1RecuperaDati() {
		try {
			/*
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			*/
			assertEquals(false,tutorDAO.recuperaDati(tutor));
			assertEquals(false,tutorDAO.recuperaDati(tutor2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test3RecuperaTutto() {
		try {
			/*
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			*/
			ArrayList<Object>tutorsObject=tutorDAO.recuperaTutto();
			assertEquals(6,tutorsObject.size());
			/*
			for(Object o:tutorsObject) {
				Tutor t=(Tutor)o;
				assertEquals(tutor,t);
				assertEquals(tutor2,t);
			}
			*/
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test4ModificaDati() {
		try {
			tutor.setNome("Gianluca");
			tutor2.setTitoloDiStudio("Licenza elementare");
			tutorDAO.modificaDati(tutor);
			tutorDAO.modificaDati(tutor2);
			ArrayList<Object>studenti=tutorDAO.recuperaTutto();
			for(Object ogg:studenti) {
				Tutor tutorOgg=(Tutor)ogg;
				if(tutor.getEmail().equals(tutorOgg.getEmail())){
					//System.out.println("Ho fatto assert 1");
					assertEquals(tutorOgg.getNome(),"Gianluca");
				}
				if(tutor2.getEmail().equals(tutorOgg.getEmail())){
					assertEquals(tutorOgg.getTitoloDiStudio(),"Licenza elementare");
					//System.out.println("HO Fatto assert 2");
				}
			}
			
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	public void test5CancellaDati() {
		try {
			/*
			Tutor tutor=new Tutor("Mario","Rossi","mario@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
			Tutor tutor2=new Tutor("Ezechiele","Nuvola","nuvolina@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
			*/
			tutorDAO.cancellaDati(tutor);
			tutorDAO.cancellaDati(tutor2);
			assertEquals(false,tutorDAO.recuperaDati(tutor));
			assertEquals(false,tutorDAO.recuperaDati(tutor2));
		}
		catch(SQLException e) {
			fail("Errore di connessione");
		}
	}
	
	
	public static Test suite() {
		return new TestSuite(TutorDAOImpTest.class);
	}
}
