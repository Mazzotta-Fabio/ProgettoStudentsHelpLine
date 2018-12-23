package provaClassi;

import java.util.ArrayList;
import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Tutor;
import storage.DomandaDAOImp;
import storage.ObjectDAO;
import storage.RispostaDAOImp;
import storage.TutorDAOImp;



public class ProvaRisposta {

  public static void main(String[] args) {

    String a = "a";
    ObjectDAO oggetto = new RispostaDAOImp ();
    ObjectDAO oggetto2 = new DomandaDAOImp ();
    ObjectDAO oggetto3 = new TutorDAOImp();
    
    Tutor t = new Tutor(a, a, a, a, a, a, a, a, a);
    Domanda d = new Domanda(12, a, a, a, null);
    Risposta o = new Risposta(0, a, a, t, d);
    
    oggetto.inserisciDati(o);
         
    
    Risposta r = new Risposta(4, null, null, t, d);
    oggetto.recuperaDati(r);
    System.out.println(r.getId());
    
    oggetto.cancellaDati(r);
    
    ArrayList<Object> listaT = oggetto.recuperaTutto();
    for(int i = 0;i<listaT.size();i++) {
      Risposta all = (Risposta) listaT.get(i);
      oggetto3.recuperaDati(all.getTutor());
      oggetto2.recuperaDati(all.getDomanda());
      System.out.println(all.getId());
      System.out.println(all.getTutor().getCognome());
      System.out.println(all.getDomanda().getId());
      System.out.println("");
    }

  }
}
