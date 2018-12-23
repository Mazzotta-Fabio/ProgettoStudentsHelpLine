import java.util.ArrayList;

import classiComuni.Tutor;
import storage.ObjectDAO;
import storage.TutorDAOImp;

public class Prova {

  public static void main(String[] args) {

    ObjectDAO oggetto = new TutorDAOImp ();
    ArrayList<Object> listaT = oggetto.recuperaTutto();
     
    
   for(int i = 0;i<listaT.size();i++) {
      Tutor s = (Tutor) listaT.get(i);
      System.out.println(s.getNome() + " " + s.getCognome());
      System.out.println(s.getEmail());
      System.out.println(s.getPassword());
      System.out.println(s.getLinkImmagine());
      System.out.println("");
    }

  }

}
