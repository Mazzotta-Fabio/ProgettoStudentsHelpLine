
import java.sql.SQLException;
import java.util.ArrayList;
import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;



public class ProvaDomanda {
	  
	public static void main(String[] args) {

		String a = "a";
		FactoryDAO f = new FactoryDAO();
		ObjectDAO oggetto = f.getObject("Domanda");
		//ObjectDAO oggetto2 = null;
		  
		Studente s = new Studente(null, null, a, null, null, null, null);
		Tutor t = new Tutor(null, null, a, null, null, null, null, null, null);
		Risposta r = new Risposta (1, null,null,null, null);
		Domanda o = new Domanda(0, a, a, "Ciao sono l'allegato", s, t, r, null);
		try {
			oggetto.inserisciDati(o);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		            
		/*Domanda d = new Domanda(13, null, null, null, null, null, null);
		try {
			oggetto.recuperaDati(d);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println(d.getAllegato());
		    
		try {
			oggetto.cancellaDati(d);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		    
		ArrayList<Object> listaT = null;
		try {
			listaT = oggetto.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;i<listaT.size();i++) {
			d = (Domanda) listaT.get(i);
		    oggetto2 = f.getObject("Studente");
		    try {
		    	oggetto2.recuperaDati(d.getStudente());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    oggetto2 = f.getObject("Tutor");
		    try {
		    	oggetto2.recuperaDati(d.getTutor());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    oggetto2 = f.getObject("Risposta");
		    try {
		    	if(d.getRisposta() != null) {
		    		oggetto2.recuperaDati(d.getRisposta());
		    	}
		    } catch (SQLException e) {
				e.printStackTrace();
			}
		    System.out.println("ID domanda: " + d.getId());
		    System.out.println("Cognome studente che ha fatto la domanda: " + d.getStudente().getCognome());
		    System.out.println("Cognome tutor che risponde alla domanda: " + d.getTutor().getCognome());
		    if(d.getRisposta() != null) {
		   	  System.out.println("ID Risposta: " + d.getRisposta().getId() +"\n\n");
		    } else {
		   	  System.out.println("Nessuna risposta\n\n");
		    }
		}*/
	 }
}
