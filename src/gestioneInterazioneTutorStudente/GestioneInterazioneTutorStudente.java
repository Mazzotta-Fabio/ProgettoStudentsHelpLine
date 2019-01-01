package gestioneInterazioneTutorStudente;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.Part;

public interface GestioneInterazioneTutorStudente {
	public String upload(Part part)throws IOException;
	public List<String> listaTutor (String materia);
	public void inserisciDomanda(String oggetto, String testo, String url,String emailT,String emailS);
	public void valutaRisposta(int id,String valutazione);
	public Object visualizzaAccount(String email);
	public int[] valutazioniTot (String email);
}
