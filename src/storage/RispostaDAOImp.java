package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Tutor;

/**
 * La classe RispostaDAOImp implementa i metodi dell'interfaccia ObjectDAO.
 * Questa classe permette di aggiungere, reperire e eliminare informazioni per le Risposte su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */

public class RispostaDAOImp implements ObjectDAO {

  private Connection con;
  
  public RispostaDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  /**
   * Il metodo serve per inserire le informazioni di una Risposta nel DataBase.
   * @param o: l'oggetto contenente le informazione della Risposta.
   */
  public void inserisciDati(Object o) {
      Risposta r = (Risposta) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into risposta (Contenuto,"
            + "Allegato,Valutazione,Tutor,Domanda) values (?,?,?,?);");
        prepared.setString(1, r.getTesto());
        prepared.setString(2, r.getAllegato());
        prepared.setString(3, r.getValutazione());
        prepared.setString(4, r.getTutor().getEmail());
        prepared.setInt(5, r.getDomanda().getId());
        prepared.executeUpdate();
      } 
      catch (SQLException e) {}
  }

  /**
   * Il metodo serve per cancellare le informazioni di una Risposta nel DataBase.
   * @param o: l'oggetto contenente le informazione della Risposta.
   */
  public void cancellaDati(Object o) {
      Risposta r = (Risposta) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from risposta"
            + " where IdRisposta = ?;");
        prepared.setInt(1,r.getId());
        prepared.execute();
      } 
      catch (SQLException e) {}
  }  

  /**
   * Il metodo serve per recuperare le informazioni di una Risposta nel DataBase.
   * @param o: l'oggetto contenente le informazione della Risposta.
   */
  @Override
  public boolean recuperaDati(Object o) {
    Risposta r = (Risposta) o;
    Domanda d = r.getDomanda();
    try 
    {
      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from risposta where Domanda = ?;");
      prepared.setInt(1,d.getId());
      ResultSet result = (ResultSet) prepared.executeQuery();
      while (result.next())
      {
        d = new Domanda(0, null, null, null, null);
        Tutor t = new Tutor(null, null, null, null, null, null, null, null, null);
        r.setId(result.getInt("IdDomanda"));
        r.setTesto(result.getString("Contenuto"));
        r.setAllegato(result.getString("Allegato"));
        d.setId(result.getInt("Domanda"));
        r.setDomanda(d);
        t.setEmail(result.getString("Tutor"));
        r.setTutor(t);
      }
    } 
    catch (SQLException e) {}
    return false;
  }
  
  /**
   * Il metodo serve per recuperare le informazioni di tutte le Risposte nel DataBase.
   * @return una lista di oggetti di tipo Risposta con tutte le informazioni reperite su DataBase per ognuna di esse.
   */
  public ArrayList<Object> recuperaTutto() {
    ArrayList<Object> listaR = new ArrayList<>(); 
    try {
        Statement query = (Statement) con.createStatement();
        ResultSet result = (ResultSet) query.executeQuery("select * from risposta;");
        while (result.next())
        {
          Risposta r = new Risposta(0, null, null, null, null);
          Domanda d = new Domanda(0, null, null, null, null);
          Tutor t = new Tutor(null, null, null, null, null, null, null, null, null);
          r.setId(result.getInt("IdRisposta"));
          r.setTesto(result.getString("Contenuto"));
          r.setAllegato(result.getString("Allegato"));
          d.setId(result.getInt("Domanda"));
          r.setDomanda(d);
          t.setEmail(result.getString("Tutor"));
          r.setTutor(t);
          listaR.add(r);
        }
    } 
    catch (SQLException e) {} 
    return listaR;
  }

}
