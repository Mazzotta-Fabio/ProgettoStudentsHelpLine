package provaClassi;

import java.util.ArrayList;
import classiComuni.Domanda;
import classiComuni.Studente;
import storage.DomandaDAOImp;
import storage.ObjectDAO;
import storage.StudenteDAOImp;



public class ProvaDomanda {

  public static void main(String[] args) {

    String a = "a";
    ObjectDAO oggetto = new DomandaDAOImp ();
    ObjectDAO oggetto2 = new StudenteDAOImp();
    
    Studente s = new Studente(null, null, null, null, null, null, null);
    Domanda o = new Domanda(6, a, a, a, s);
    oggetto.inserisciDati(o);
         
    
    Domanda d = new Domanda(13, null, null, null, s);
    oggetto.recuperaDati(d);
    System.out.println(d.getAllegato());
    
    oggetto.cancellaDati(d);
    
    ArrayList<Object> listaT = oggetto.recuperaTutto();
    for(int i = 0;i<listaT.size();i++) {
      Domanda all = (Domanda) listaT.get(i);
      oggetto2.recuperaDati(all.getStudente());
      System.out.println(all.getId());
      System.out.println(all.getStudente().getCognome());
      System.out.println("");
    }

  }
}
