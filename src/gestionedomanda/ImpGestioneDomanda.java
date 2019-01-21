package gestionedomanda;

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
import storage.FactoryDao;
import storage.ObjectDao;

/**
* Questa classe implementa l'interfaccia GestioneDomanda.
* @author Antonio Cimino
* @version 1.0
*/

public class ImpGestioneDomanda implements GestioneDomanda {
  public ImpGestioneDomanda() {}
  
  /**
  * Il metodo serve per scaricare l'allegato nella cartella downloads.
  * @param fileName il nome dell'allegato da scaricare.
  */

  public void scaricaAllegato(String fileName) throws IOException {
    File sourceLocation = new File(fileName);
    String destLocation = new String("C:\\Users\\Antonio\\Downloads");
    File targetFolder = new File(destLocation);
    InputStream in = new FileInputStream(sourceLocation);
    OutputStream out = new FileOutputStream(targetFolder + "\\"
        + sourceLocation.getName(),true);           
    byte[] buf = new byte[1024];
    int len;
    while ((len = in.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    in.close();
    out.close();
  } 
  /**
   * il metodo serve per eliminare una domanda.
   * @param id della domanda da eliminare
   */

  public void eliminaDomanda(int id) {
    Domanda d = new Domanda(id, null, null, null, null, null, null, null);
    FactoryDao fd = new FactoryDao();
    ObjectDao o = fd.getObject("Domanda");
    try {
      o.cancellaDati(d);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  

  /**
  * il metodo serve  per recuperare tutte le domande senza risposta.
  * @param email per il recupero della domanda
  */
  
  public List<String> recuperaDomandeSenzaRisposta(String email) {
    FactoryDao fd = new FactoryDao();
    ObjectDao o = fd.getObject("Domanda");
    ArrayList<Object> listaD = null;
    try {
      listaD = o.recuperaTutto();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    List<String> listaDomande = new ArrayList<String>();
    for (int i = 0; i < listaD.size(); i++) {
      Domanda d = (Domanda) listaD.get(i);
      if (d.getRisposta().getId() == 1) {
        if (email.equals(d.getStudente().getEmail()) || email.equals(d.getTutor().getEmail())) {
          listaDomande.add(String.valueOf(d.getId()));
          listaDomande.add(d.getOggetto());
          listaDomande.add(d.getVis());
          listaDomande.add(d.getTutor().getEmail());
        }
      }
    }
    return listaDomande;
  }

  /**
  * il metodo permette di recuperare le domande con le relative risposte.
  * @param email per il recupero delle domande
  */

  public List<String> recuperaDomandeConRisposta(String email) {
    FactoryDao fd = new FactoryDao();
    ObjectDao o = fd.getObject("Domanda");
    ArrayList<Object> listaD = null;
    try {
      listaD = o.recuperaTutto();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    o = fd.getObject("Risposta");
    List<String> listaDomande = new ArrayList<String>();
    for (int i = 0; i < listaD.size(); i++) {
      Domanda d = (Domanda) listaD.get(i);
      if (d.getRisposta().getId() != 1) {
        if (email.equals(d.getStudente().getEmail())  || email.equals(d.getTutor().getEmail())) {
          listaDomande.add(String.valueOf(d.getId()));
          listaDomande.add(d.getOggetto());
          Risposta r = new Risposta(d.getRisposta().getId(), null, null, null, null);
          try {
            o.recuperaDati(r);
          } catch (SQLException e) {
            e.printStackTrace();
          }
          listaDomande.add(r.getVis());
          listaDomande.add(d.getTutor().getEmail());
        }
      }
    }
    return listaDomande;
  }

  /**
  * il metodo permette di visualizzare la domanda.
  * @param id della domanda
  * @param tipo identifica la tipologiua di utente
  */
  
  public ArrayList<String> visualizzaDomanda(int id,String tipo) {
    FactoryDao fd = new FactoryDao();
    Domanda d = new Domanda(id, null, null, null, null, null, null, "no");
    ObjectDao o = fd.getObject("Domanda");
    try {
      o.recuperaDati(d);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (tipo.equals("Tutor")) {
      d.setVis("si");
      try {
        o.modificaDati(d);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    Studente s = d.getStudente(); 
    o = fd.getObject("Studente");
    try {
      o.recuperaDati(s);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    ArrayList<String> listaInfo = new ArrayList<String>();
    listaInfo.add(d.getStudente().getEmail());
    listaInfo.add(d.getOggetto());
    listaInfo.add(d.getTesto());
    listaInfo.add(d.getAllegato());
    listaInfo.add(String.valueOf(d.getId()));
 
    Tutor t = d.getTutor(); 
    o = fd.getObject("Tutor");
    try {
      o.recuperaDati(t);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    listaInfo.add(t.getEmail());
    Risposta r = d.getRisposta();
    o = fd.getObject("Risposta");
    try {
      o.recuperaDati(r);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    listaInfo.add(r.getTesto());
    listaInfo.add(r.getAllegato());
    listaInfo.add(r.getValutazione());
    listaInfo.add(String.valueOf(r.getId()));
    listaInfo.add(String.valueOf(r.getId()));
    if (tipo.equals("Studente")) {
      r.setVis("si");
      try {
        o.modificaDati(r);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return listaInfo;
  }
}
