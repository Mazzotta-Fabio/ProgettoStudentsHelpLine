package gestioneInterazioneTutorStudente;

import java.io.IOException;

import javax.servlet.http.Part;

public interface GestioneInterazioneTutorStudente {
	public String Upload(Part part)throws IOException;
}
