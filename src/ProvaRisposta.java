import java.sql.SQLException;
import java.util.ArrayList;

import classiComuni.Risposta;
import storage.FactoryDAO;
import storage.ObjectDAO;
import storage.RispostaDAOImp;

public class ProvaRisposta {
	public static void main(String[] args) {
		String a = "a";
		FactoryDAO f = new FactoryDAO();
		ObjectDAO oggetto = f.getObject("Risposta");
	    
	    Risposta o = new Risposta(0, a, a, a, a);
	    try {
			oggetto.inserisciDati(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	         
	   /* Risposta r = new Risposta(4, null, null,null);
	    try {
			oggetto.recuperaDati(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    System.out.println("Testo di risposta 4: " + r.getTesto());
	    
	    ArrayList<Object> listaT = null;
		try {
			listaT = oggetto.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    for(int i = 0;i<listaT.size();i++) {
	      Risposta all = (Risposta) listaT.get(i);
	      System.out.println("Id risposta:" + all.getId());
	      System.out.println("Testo risposta:" +all.getTesto());
	      System.out.println("");
	    }*/
	}
}
