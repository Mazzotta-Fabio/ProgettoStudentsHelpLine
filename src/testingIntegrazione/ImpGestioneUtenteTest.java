package testingIntegrazione;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Part;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import classiComuni.Studente;
import classiComuni.Tutor;
import gestioneUtente.ImpGestioneUtente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import storage.StudenteDAOImp;
import storage.TutorDAOImp;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImpGestioneUtenteTest extends TestCase   {
	private Tutor tutor1;
	private Tutor tutor2;
	private Studente studente1;
	private Studente studente2;
	private StudenteDAOImp studenteDao;
	private TutorDAOImp tutorDao;
	private ImpGestioneUtente GestioneUtente;
	private Part p;
	
	protected void setUp() throws Exception {
		p = null;
		
		tutor1 = new Tutor("Mario","Rossi","mario.rossi@gmail.com","12345678","/home/xyz","1234567891","matematica","86","Laurea Triennale");
		tutor2 = new Tutor("Ezechiele","Nuvola","ezechiele.nuvola@gmail.com","1234567845","/home/xyz/o","1234567891","progrmmazione 2","108","Dottorato di ricerca");
		studente1 = new Studente("Rosa","Marini","rosa.marini@gmail.com","12345678","/home/xyz","0522500518","2");
		studente2 = new Studente("Chiara","Giani","chiara.giani@gmail.com","123456err","/home/xyz/o","0512102515","1");
		
		GestioneUtente = new ImpGestioneUtente();
		studenteDao = new StudenteDAOImp();
		tutorDao = new TutorDAOImp();
	}

	protected void tearDown() throws Exception {
		tutor1 = null;
		tutor2 = null;
		studente1 = null;
		studente2 = null;
		studenteDao = null;
		tutorDao = null;
		GestioneUtente = null;
	}
	
	public void test1RegistrazioneAccount() {
		try {
			
			GestioneUtente.registraAccount("Tutor",tutor1.getNome(),tutor1.getCognome(),tutor1.getEmail(),tutor1.getPassword(),p,tutor1.getVotoDiLaurea(),tutor1.getMateriaDiCompetenza(),tutor1.getNumeroDiCellulare(),tutor1.getTitoloDiStudio());
			GestioneUtente.registraAccount("Tutor",tutor2.getNome(),tutor2.getCognome(),tutor2.getEmail(),tutor2.getPassword(),p,tutor2.getVotoDiLaurea(),tutor2.getMateriaDiCompetenza(),tutor2.getNumeroDiCellulare(),tutor2.getTitoloDiStudio());
			GestioneUtente.registraAccount("Studente",studente1.getNome(),studente1.getCognome(),studente1.getEmail(),studente1.getPassword(),p,studente1.getMatricola(),studente1.getAnnoCorso(),null,null);
			GestioneUtente.registraAccount("Studente",studente2.getNome(),studente2.getCognome(),studente2.getEmail(),studente2.getPassword(),p,studente2.getMatricola(),studente2.getAnnoCorso(),null,null);
			
			ArrayList<Object> tutor = null;
			try {
				tutor = tutorDao.recuperaTutto();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(Object ogg:tutor) {
				Tutor tutorOgg = (Tutor) ogg;
				if(tutorOgg.getEmail().equals(tutor1.getEmail())){
					assertEquals("Mario",tutorOgg.getNome());
					assertEquals("Rossi",tutorOgg.getCognome());
				}
				if(tutorOgg.getEmail().equals(tutor2.getCognome())){
					assertEquals("Ezechiele",tutorOgg.getNome());
					assertEquals("Nuvola",tutorOgg.getCognome());
				}
			}
			
			ArrayList<Object> studente = null;
			try {
				studente = studenteDao.recuperaTutto();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(Object ogg:studente) {
				Studente studenteOgg = (Studente) ogg;
				if(studenteOgg.getEmail().equals(studente1.getEmail())){
					assertEquals("Rosa",studenteOgg.getNome());
					assertEquals("Marini",studenteOgg.getCognome());
				}
				if(studenteOgg.getEmail().equals(studente2.getEmail())){
					assertEquals("Chiara",studenteOgg.getNome());
					assertEquals("Giani",studenteOgg.getCognome());
				}
			}

		} catch (IOException e) {
			fail("Connessione interrotta");
		}
	}
	
	
	public void test2LoginAccount() {
			Tutor t = null;
			Studente s = null;
			
			t = (Tutor) GestioneUtente.loginAccount(tutor1.getEmail(),tutor1.getPassword(), "Tutor");
			assertEquals("Mario",t.getNome());
			assertEquals("Rossi",t.getCognome());
			
			t = (Tutor) GestioneUtente.loginAccount(tutor2.getEmail(),tutor2.getPassword(), "Tutor");
			assertEquals("Ezechiele",t.getNome());
			assertEquals("Nuvola",t.getCognome());
			
			s = (Studente) GestioneUtente.loginAccount(studente1.getEmail(),studente1.getPassword(), "Studente");
			assertEquals("Rosa",s.getNome());
			assertEquals("Marini",s.getCognome());
			
			s = (Studente) GestioneUtente.loginAccount(studente2.getEmail(),studente2.getPassword(), "Studente");
			assertEquals("Chiara",s.getNome());
			assertEquals("Giani",s.getCognome());
	}
	
	public void testModificaAccount() {
		try {
			
			GestioneUtente.modificaAccount("Tutor",tutor1.getNome(),"Russo",tutor1.getEmail(),tutor1.getPassword(),p,tutor1.getVotoDiLaurea(),tutor1.getMateriaDiCompetenza(),tutor1.getNumeroDiCellulare(),tutor1.getTitoloDiStudio());
			GestioneUtente.modificaAccount("Tutor","Matteo",tutor2.getCognome(),tutor2.getEmail(),tutor2.getPassword(),p,tutor2.getVotoDiLaurea(),tutor2.getMateriaDiCompetenza(),tutor2.getNumeroDiCellulare(),tutor2.getTitoloDiStudio());
			GestioneUtente.modificaAccount("Studente",studente1.getNome(),"Mozzillo",studente1.getEmail(),studente1.getPassword(),p,studente1.getMatricola(),studente1.getAnnoCorso(),null,null);
			GestioneUtente.modificaAccount("Studente","Giorgia",studente2.getCognome(),studente2.getEmail(),studente2.getPassword(),p,studente2.getMatricola(),studente2.getAnnoCorso(),null,null);
			
			ArrayList<Object> tutor = null;
			try {
				tutor = tutorDao.recuperaTutto();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(Object ogg:tutor) {
				Tutor tutorOgg = (Tutor) ogg;
				if(tutorOgg.getEmail().equals(tutor1.getEmail())){
					assertEquals("Russo",tutorOgg.getCognome());
				}
				if(tutorOgg.getEmail().equals(tutor2.getCognome())){
					assertEquals("Matteo",tutorOgg.getNome());
				}
			}
			
			ArrayList<Object> studente = null;
			try {
				studente = studenteDao.recuperaTutto();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(Object ogg:studente) {
				Studente studenteOgg = (Studente) ogg;
				if(studenteOgg.getEmail().equals(studente1.getEmail())){
					assertEquals("Mozzillo",studenteOgg.getCognome());
				}
				if(studenteOgg.getEmail().equals(studente2.getEmail())){
					assertEquals("Giorgia",studenteOgg.getNome());
				}
			}

		} catch (IOException e) {
			fail("Connessione interrotta");
		}
	}
	
	public void test3RecuperaPassword() {
		String password;
		
		password = GestioneUtente.recuperaPassword("Tutor", tutor1.getEmail());
		assertEquals("12345678",password);

		password = GestioneUtente.recuperaPassword("Tutor", tutor2.getEmail());
		assertEquals("1234567845",password);
		
		password = GestioneUtente.recuperaPassword("Studente", studente1.getEmail());
		assertEquals("12345678",password);
		
		password = GestioneUtente.recuperaPassword("Studente", studente2.getEmail());
		assertEquals("123456err",password);
	}
	
	public static Test suite() {
		return new TestSuite(ImpGestioneUtenteTest.class);
	}

}

