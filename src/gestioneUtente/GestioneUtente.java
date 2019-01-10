package gestioneUtente;

import java.io.IOException;

public interface GestioneUtente {
	public String recuperaPassword (String tipo,String destinatario);
	public void eliminaAccount(String destinatario,String tipo);
	public Object loginAccount(String email,String password,String tipo);
	public Object infoAccount(String email, String tipo);
	public void registraAccount (String tipo, String nome,String cognome,String email,String password,
			String path,String voto,String titolo,String numero,String materia) throws IOException;
	public void modificaAccount (String tipo, String nome,String cognome,String email,String password,
			String path,String voto,String titolo,String numero,String materia) throws IOException;
}
