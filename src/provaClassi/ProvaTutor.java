package provaClassi;

import java.util.ArrayList;
import classiComuni.Tutor;
import storage.ObjectDAO;
import storage.TutorDAOImp;

public class ProvaTutor {

  public static void main(String[] args) {

    String a = "a";
    ObjectDAO oggetto = new TutorDAOImp ();
    
    Tutor o = new Tutor(a,a,a,a,a,a,a,a,a);
    oggetto.inserisciDati(o);
         
    Tutor t = new Tutor(null, null, null, null, null, null, null, null, null);
    t.setEmail(a);
    oggetto.recuperaDati(t);
    System.out.println(t.getCognome());
    
    oggetto.cancellaDati(t);
    
    ArrayList<Object> listaT = oggetto.recuperaTutto();
    for(int i = 0;i<listaT.size();i++) {
      Tutor all = (Tutor) listaT.get(i);
      System.out.println(all.getNome() + " " + all.getCognome());
      System.out.println(all.getEmail());
      System.out.println(all.getPassword());
      System.out.println(all.getLinkImmagine());
      System.out.println("");
    }

  }

}

