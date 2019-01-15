package gestioneutente;

import classicomuni.Domanda;
import classicomuni.Studente;
import classicomuni.Tutor;
import com.email.durgesh.Email;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import javax.mail.MessagingException;
import storage.FactoryDao;
import storage.ObjectDao;


/**
 * Questa classe implementa l'interfaccia GestioneUtente.
 * @author Antonio Cimino
 * @version 1.0
 */
public class ImpGestioneUtente implements GestioneUtente {
  /**
   * Il metodo serve per inviare la mail per recuperare la password.
   * @param tipo tipologia utente
   * @param destinatario l'email dove inviare l'email
   * @return password non vuota se l'utentr viene trovato
   */
  public String recuperaPassword(String tipo,String destinatario) {
    String password = null;
    if (tipo.equals("Tutor")) {
      Tutor t = new Tutor(null, null,destinatario, null, null, null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Tutor");
      try {
        o.recuperaDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      password = t.getPassword();
    } else {
      Studente s = new Studente(null, null,destinatario,null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Studente");
      try {
        o.recuperaDati(s);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      password = s.getPassword();
    }
    try {
      Email email = new Email("helplinestudent53@gmail.com","st5d3nth3lpl1n3");
      email.setFrom("helplinestudent53@gmail.com", "Student's Help Line");
      email.setSubject("RECUPERO PASSWORD");
      String testo = null;
      if (password != null) {
        testo = "La password del tuo account di student's help line è: " + password;
      } else {
        testo = "Account non presente sul sito";
      }            
      email.setContent("<h1>La tua password è " + testo + "</h1>","text/html");
      email.addRecipient(destinatario);
      email.send();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    }
    return password;  
  }
 
  /**
   * Il metodo serve per registrare un utente.
   * @param tipo tipologia dell'utente
   * @param cognome cognome dell'utente
   * @param email dell'utente
   * @param password dell'account dell'utente
   * @param path dell'immagine di profilo
   * @param voto preso dal tutor alla laurea per lo studente rappresenta la matricola
   * @param titolo del tutor per lo studente rappresenta l'anno di corso
   * @param numero di cellular del tutor
   * @param materia di competence del tutor
   */
  
  public void registraAccount(String tipo, String nome, String cognome, String email,
       String password,String path,String voto, String titolo, String numero, 
       String materia) throws IOException {
    if (tipo.equals("Tutor")) {
      Tutor t = new Tutor(nome, cognome,email,password,path,numero, materia, voto, titolo);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Tutor");
      try {
        o.inserisciDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      Studente s = new Studente(nome, cognome,email,password,path,voto,titolo);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Studente");
      try {
        o.inserisciDati(s);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * Il metodo elimina un utente dal sistema.
   * @param email dell'utente
   * @param tipo di utente da cancellare
   */
   
  public void eliminaAccount(String email,String tipo) {
    int i;
    if (tipo.equals("Tutor")) {
      Tutor t = new Tutor(null, null,email, null, null, null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Domanda");
      List<Object> listaD = null;
      try {
        listaD = o.recuperaTutto();
      } catch (NumberFormatException e1) {
        e1.printStackTrace();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      for (i = 0;i < listaD.size();i++) {
        Domanda dom = (Domanda) listaD.get(i);
        if (dom.getTutor().getEmail().equals(email)) {
          try {
            o.cancellaDati(dom);
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
      o = fdao.getObject("Tutor");
      try {
        o.cancellaDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      Studente s = new Studente(null, null,email,null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Domanda");
      List<Object> listaD = null;
      try {
        listaD = o.recuperaTutto();
      } catch (NumberFormatException e1) {
        e1.printStackTrace();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      for (i = 0;i < listaD.size();i++) {
        Domanda dom = (Domanda) listaD.get(i);
        if (email.equals(dom.getStudente().getEmail())) {
          try {
            o.cancellaDati(dom);
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
      o = fdao.getObject("Studente");
      try {
        o.cancellaDati(s);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * il metodo viene utilizzato per modificare i dati di un utente.
   * @param: tipo dell'utenteb dei dati da modificare
   * @param: nome dell'utente da modificare
   *  @param: cognome dell'utente da modificare
   *  @param: email dell'utente da modificare
   *  @param: password dell'utente da modificare
   *  @param: path della foto dell'utente da modificare
   *  @param: voto dell'utente da modificare
   *  @param: titolo di studio dell'utente da modificare
   *  @param: numero di cellulare dell'utente da modificare
   *  @param: materia dell'utente da modificare
   */
  
  public void modificaAccount(String tipo, String nome, String cognome, String email,
            String password,String path, String voto, String titolo, String numero, 
            String materia) throws IOException {
    if (tipo.equals("Tutor")) {
      Tutor t = new Tutor(nome, cognome,email,password,path,numero, materia, "1", titolo);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Tutor");
      try {
        o.modificaDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      Studente s = new Studente(nome, cognome,email,password,path,voto,titolo);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Studente");
      try {
        o.modificaDati(s);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * il metodo viene utilizzato per effettuare il login di un utente.
   * @param: email dell'utente
   * @param: password dell'utente 
   * @param: tipo dell'utente
   */
  
  public Object loginAccount(String email, String password, String tipo) {
    boolean accesso = false;
    if (tipo.equals("Tutor")) {
      Tutor t = new Tutor(null, null,email, password, null, null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Tutor");
      try {
        accesso = o.recuperaDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if (accesso == true) {
        return t;
      } else {
        t.setEmail(null); 
        return t;
      }
    } else {
      Studente s = new Studente(null, null,email,password, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Studente");
      try {
        accesso = o.recuperaDati(s);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if (accesso == true) {
        return s;
      } else {
        s.setEmail(null);
        return s;
      }
    }
  }
  /**
   * il metodo viene utilizzato per recuperare info di un utente.
   * @param: email dell'utente 
   * @param: tipo dell'utente
   */
  
  public Object infoAccount(String email, String tipo) {
    if (tipo.equals("Tutor")) {
      Tutor t = new Tutor(null, null,email, null, null, null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Tutor");
      try { 
        o.recuperaDati(t);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return t;
    } else {
      Studente s = new Studente(null, null,email,null, null, null, null);
      FactoryDao fdao = new FactoryDao();
      ObjectDao o = fdao.getObject("Studente");
      try {
        o.recuperaDati(s);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return s;
    }
  }
}
