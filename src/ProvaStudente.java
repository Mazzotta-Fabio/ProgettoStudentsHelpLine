import java.sql.SQLException;
import java.util.ArrayList;

import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;

public class ProvaStudente {
	public static void main(String[] args) {
		String a = "a";
		FactoryDAO f = new FactoryDAO();
		ObjectDAO oggetto = f.getObject("Studente");
	    
	    /*Tutor o = new Tutor(a, a, a, a, a, a, a, a, a);
	    try {
			oggetto.inserisciDati(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	         
	    Studente t = new Studente(a, a, a, a, a, a, a);
	    try {
			oggetto.recuperaDati(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    System.out.println("Email dello studente a: " + t.getEmail());
	    
	    ArrayList<Object> listaT = null;
		try {
			listaT = oggetto.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    for(int i = 0;i<listaT.size();i++) {
	      Studente all = (Studente) listaT.get(i);
	      System.out.println("Email:" + all.getEmail());
	      System.out.println("Cognome:" +all.getCognome());
	      System.out.println("");
	    }
	}
}
