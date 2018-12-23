package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import classiComuni.Domanda;
import classiComuni.Studente;


/**
 * La classe DomandaDAOImp implementa i metodi dell'interfaccia ObjectDAO.
 * Questa classe permette di aggiungere, reperire e eliminare informazioni per le Domande su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */

public class DomandaDAOImp implements ObjectDAO {

  private Connection con;
  
  public DomandaDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  /**
   * Il metodo serve per inserire le informazioni di una Domanda nel DataBase.
   * @param o: l'oggetto contenente le informazione della Domanda.
   */
  public void inserisciDati(Object o) {
      Domanda d = (Domanda) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into domanda (Contenuto,"
            + "Allegato,Oggetto,Studente) values (?,?,?,?);");
        prepared.setString(1, d.getTesto());
        prepared.setString(2, d.getAllegato());
        prepared.setString(3, d.getOggetto());
        prepared.setString(4, d.getStudente().getEmail());
        prepared.executeUpdate();
      } 
      catch (SQLException e) {}
  }

  /**
   * Il metodo serve per cancellare le informazioni di una Domanda nel DataBase.
   * @param o: l'oggetto contenente le informazione della Domanda.
   */
  public void cancellaDati(Object o) {
      Domanda d = (Domanda) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from domanda"
            + " where IdDomanda = ?;");
        prepared.setInt(1,d.getId());
        prepared.execute();
      } 
      catch (SQLException e) {}
  }  

  /**
   * Il metodo serve per recuperare le informazioni di una Domanda nel DataBase.
   * @param o: l'oggetto contenente le informazione della Domanda.
   */
  public boolean recuperaDati(Object o) {
    Domanda d = (Domanda) o;
    try 
    {
      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from domanda where IdDomanda = ?;");
      prepared.setInt(1,d.getId());
      ResultSet result = (ResultSet) prepared.executeQuery();
      while (result.next())
      {
        Studente s = new Studente(null, null, null, null, null, null, null);
        d.setId(result.getInt("IdDomanda"));
        d.setTesto(result.getString("Contenuto"));
        d.setAllegato(result.getString("Allegato"));
        d.setOggetto(result.getString("Oggetto"));
        s.setEmail(result.getString("Studente"));
        d.setStudente(s);
      }
    } 
    catch (SQLException e) {}
    return false;
  }

  /**
   * Il metodo serve per recuperare le informazioni di tutte le Domande nel DataBase.
   * @return una lista di oggetti di tipo Domanda con tutte le informazioni reperite su DataBase per ognuna di esse.
   */
  public ArrayList<Object> recuperaTutto() {
    ArrayList<Object> listaD = new ArrayList<>(); 
    try {
        Statement query = (Statement) con.createStatement();
        ResultSet result = (ResultSet) query.executeQuery("select * from domanda;");
        while (result.next())
        {
          Domanda d = new Domanda(0, null, null, null, null);
          Studente s = new Studente(null, null, null, null, null, null, null);
          d.setId(result.getInt("IdDomanda"));
          d.setTesto(result.getString("Contenuto"));
          d.setAllegato(result.getString("Allegato"));
          d.setOggetto(result.getString("Oggetto"));
          s.setEmail(result.getString("Studente"));
          d.setStudente(s);
          listaD.add(d);
        }
    } 
    catch (SQLException e) {} 
    return listaD;
  }

}
