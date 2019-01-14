package gestioneinterazionetutorstudente;

import classicomuni.Domanda;
import classicomuni.Risposta;
import classicomuni.Studente;
import classicomuni.Tutor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import storage.FactoryDAO;
import storage.ObjectDAO;

public class ImpGestioneInterazioneTutorStudente implements GestioneInterazioneTutorStudente {
  private String destLocation;
  /**
   * Il costruttore della classe.
   */
  
  public ImpGestioneInterazioneTutorStudente() {
    destLocation = new String("C:\\Users\\Antonio\\git\\ProgettoStudentsHelpLine\\file");
  }
  /**
   * Il metodo serve per caricare un file o una foto nella cartella file.
   * @param fileName corrisponde al path dove si trovo il file
   * @return d è il path in cui viene caricato il file
   */  
  
  public String upload(String fileName)throws IOException {
    String d = "";
    if (!fileName.equals("")) {
      File sourceLocation = new File(fileName);
      File targetFolder = new File(destLocation);
      InputStream in = new FileInputStream(sourceLocation);
      OutputStream out = new FileOutputStream(targetFolder + "\\" + sourceLocation.getName(), true);
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      in.close();
      out.close();   
      d = (targetFolder + "\\" + sourceLocation.getName());
    }
    return d;
  }    
  /**
   * Il metodo serve per restituire un insieme di tutti i tutor presenti sul database.
   * @param materia corrisponde alla materia quale i tutor restituiti devono essere competenti
   * @return listaTutor lista dei tutor
   */
  
  public List<String> listaTutor(String materia) {
    FactoryDAO fd = new FactoryDAO();
    ObjectDAO o = fd.getObject("Tutor");
    List<Object> listaT = null;
    try {
      listaT = o.recuperaTutto();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    List<String> listaTutor = new ArrayList<String>();
    for (int i = 0;i < listaT.size();i++) {
      Tutor t = (Tutor) listaT.get(i);
      if (t.getMateriaDiCompetenza().equals(materia)) {
        listaTutor.add(t.getNome());
        listaTutor.add(t.getCognome());
        listaTutor.add(t.getLinkImmagine());
        int[] num = valutazioniTot(t.getEmail());
        listaTutor.add(String.valueOf(num[0]));
        listaTutor.add(String.valueOf(num[1]));
        listaTutor.add(t.getEmail());
      }
    }
    return listaTutor;
  }

  /**
   * Il metodo serve per inserire una domanda nel database.
   * @param oggetto oggetto della domanda
   * @param test testo della domanda
   * @param url url del file correlato alla domanda
   * @param emailT email del tutor a cui si fa la domanda
   * @param emailS email dello studente che ha inviato la domanda
   */
  
  public void inserisciDomanda(String oggetto, String test,String url,String emailT,String emailS) {
    Tutor t = new Tutor(null, null, emailT, null, null, null, null, null, null);
    Studente s = new Studente(null, null, emailS, null, null, null, null);
    Risposta r = new Risposta(1, null, null,null, null);
    Domanda d = new Domanda(0, test, oggetto, url, s, t, r, "no");
    FactoryDAO fd = new FactoryDAO();
    ObjectDAO o = fd.getObject("Domanda");
    try {
      o.inserisciDati(d);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  /**
   * Il metodo serve per caricare la valutazione ad una risposta.
   * @param id corrisponde all'id della risposta valutata
   * @param valutazione corrisponde alla valutazione 
   */
  
  public void valutaRisposta(int id, String valutazione) {
    Risposta r = new Risposta(id,null,null, null, null);
    FactoryDAO fd = new FactoryDAO();
    ObjectDAO o = fd.getObject("Risposta");
    try {
      o.recuperaDati(r);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    r.setValutazione(valutazione);
    try {
      o.modificaDati(r);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Il metodo serve per visualizzare le informazioni di un account.
   * @param email corrisponde all'email dell'account da visualizzare
   * @return l'oggetto con le informazioni dell'utente
   */
  public Object visualizzaAccount(String email) {
    Studente s = new Studente(null, null, email, null, null, null, null);
    FactoryDAO fd = new FactoryDAO();
    ObjectDAO o = fd.getObject("Studente");
    try {
      o.recuperaDati(s);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (s.getNome() != null) {
      return s;
    } else {
      Tutor t = new Tutor(null, null, email, null, null, null, null,null,null);
      o = fd.getObject("Tutor");
      try {
        o.recuperaDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if (t.getNome() != null) {
        return t;
      } else {
        return null;
      }
    }
  }
  /**
   * Il metodo serve per restituire le valutazioni totali di un tutor.
   * @param email email del tutor di cui si voglioni le valutazioni
   * @return voti è l'array con quanti like e dislike ha il tutor
   */
  
  public int[] valutazioniTot(String email) {
    int [] voti = new int[2];
    voti[0] = 0;
    voti[1] = 0;
    FactoryDAO fd = new FactoryDAO();
    ObjectDAO o = fd.getObject("Domanda");
    List<Object> listD = null;
    try {
      listD = o.recuperaTutto();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    o = fd.getObject("Risposta");
    for (int i = 0;i < listD.size();i++) {
      Domanda d = (Domanda) listD.get(i);
      if (email.equals(d.getTutor().getEmail())) {
        Risposta r = new Risposta(d.getRisposta().getId(), null, null, null, null);
        try {
          o.recuperaDati(r);
        } catch (SQLException e) {
          e.printStackTrace();
        }
        if (r.getValutazione().equals("like")) {
          voti[0]++;
        } else if (r.getValutazione().equals("dislike")) {
          voti[1]++;
        }
      }
    }
    return voti;
  }
  /**
   * Il metodo serve per inserire una risposta.
   * @param testo il testo della risposta
   * @param idDomanda id della domanda a cui associare la risposta
   * @param url url del file associato alla risposta
   */
  
  public void inserisciRisposta(String testo, int idDomanda, String url) {
    FactoryDAO fd = new FactoryDAO();
    ObjectDAO o = fd.getObject("Risposta");
    Risposta r = new Risposta(0, testo, url,null, "no");
    try {
      o.inserisciDati(r);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    List<Object> risposte = null;
    try {
      risposte = o.recuperaTutto();
    } catch (NumberFormatException e1) {
      e1.printStackTrace();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    int n = risposte.size();
    r = (Risposta) risposte.get(n - 1);
    o = fd.getObject("Domanda");
    Domanda d = new Domanda(idDomanda, null, null, null, null, null, null, null);
    try {
      o.recuperaDati(d);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    d.setRisposta(r);
    try {
      o.modificaDati(d);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /**
   * Il metodo serve per capire se ci sono domande da visualizzare.
   * @param email chiave primaria di una utente.
   * @param tipo tipo di utente.
   * @return true se ci sono domande o risposte da vedere, a seconda che sia un tutor
   o uno studente, oppure false.
   */
  
  public boolean domandeDaVisualizzare(String email,String tipo) {
    FactoryDAO fd = new FactoryDAO();
    if (tipo.equals("Tutor")) {
      ObjectDAO o = fd.getObject("Domanda");
      ArrayList<Object> listaD = null;
      try {
        listaD = o.recuperaTutto();
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      for (int i = 0;i < listaD.size();i++) {
        Domanda d = (Domanda) listaD.get(i);
        if (d.getTutor().getEmail().equals(email)) {
          if (d.getVis().equals("no")) {
            return true;
          } else {
            return false;
          }
        }
      }
    } else {
      ObjectDAO o = fd.getObject("Domanda");
      ArrayList<Object> listaD = null;
      try {
        listaD = o.recuperaTutto();
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      o = fd.getObject("Risposta");
      for (int i = 0;i < listaD.size();i++) {
        Domanda d = (Domanda) listaD.get(i);
        if (d.getStudente().getEmail().equals(email)) {
          Risposta r = new Risposta(d.getRisposta().getId(), null, null, null, null);
          try {
            o.recuperaDati(r);
          } catch (SQLException e) {
            e.printStackTrace();
          }
          if (r.getVis().equals("no")) {
            return true;
          } else {
            return false;
          }
        }
      }
    }
    return false;
  }
}
