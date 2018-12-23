package provaClassi;

import java.util.ArrayList;

import classiComuni.Studente;
import storage.ObjectDAO;
import storage.StudenteDAOImp;


public class ProvaStudente {

  public static void main(String[] args) {

    String a = "a";
    ObjectDAO oggetto = new StudenteDAOImp ();
    
    Studente o = new Studente(a,a,a,a,a,a,a);
    oggetto.inserisciDati(o);
         
    Studente s = new Studente(null, null, null, null, null, null, null);
    s.setEmail(a);
    oggetto.recuperaDati(s);
    System.out.println(s.getCognome());
    
    oggetto.cancellaDati(s);
    
    ArrayList<Object> listaT = oggetto.recuperaTutto();
    for(int i = 0;i<listaT.size();i++) {
      Studente all = (Studente) listaT.get(i);
      System.out.println(all.getNome() + " " + all.getCognome());
      System.out.println(all.getEmail());
      System.out.println(all.getPassword());
      System.out.println(all.getLinkImmagine());
      System.out.println("");
    }

  }
}