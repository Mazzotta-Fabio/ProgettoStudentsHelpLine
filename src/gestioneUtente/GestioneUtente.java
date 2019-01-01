package gestioneUtente;

import java.io.IOException;
import javax.servlet.http.Part;

public interface GestioneUtente {
	public void recuperaPassword (String tipo,String password,String destinatario);
	public void eliminaAccount(String destinatario,String tipo);
	public Object loginAccount(String email,String password,String tipo);
	public Object infoAccount(String email, String tipo);
	public void registraAccount (String tipo, String nome,String cognome,String email,String password,
			Part linkImmagine,String voto,String titolo,String numero,String materia) throws IOException;
	public void modificaAccount (String tipo, String nome,String cognome,String email,String password,
			Part linkImmagine,String voto,String titolo,String numero,String materia) throws IOException;
}
