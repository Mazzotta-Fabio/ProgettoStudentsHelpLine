package gestioneDomanda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface GestioneDomanda {
	public void scaricaAllegato(String fileName)throws IOException;
	public void eliminaDomanda(int id);
	public List<String> recuperaDomandeSenzaRisposta(String email);
	public List<String> recuperaDomandeConRisposta(String email);
	public ArrayList<String> visualizzaDomanda (int id);
	public void inserisciRisposta(String testo, int idDomanda,String url);
	public boolean domandeDaVisualizzare(String email);
	public boolean risposteDaVisualizzare(String email);
	public void settaViste(String email,String tipo);
}
