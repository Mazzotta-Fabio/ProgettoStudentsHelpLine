package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Risposta;


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
   * @throws SQLException 
   */
  public void inserisciDati(Object o) throws SQLException {
      Risposta r = (Risposta) o;
 
      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into risposta (Contenuto,"
          + "Allegato,Visualizzata,Valutazione) values (?,?,?,?);");
      prepared.setString(1, r.getTesto());
      prepared.setString(2, r.getAllegato());
      prepared.setString(3, r.getVis());
      prepared.setString(4, r.getValutazione());
      prepared.executeUpdate();
  }

  /**
   * Il metodo serve per cancellare le informazioni di una Risposta nel DataBase.
   * @param o: l'oggetto contenente le informazione della Risposta.
   * @throws SQLException 
   */
  public void cancellaDati(Object o) throws SQLException {
      Risposta r = (Risposta) o;
      
       PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from risposta"
          + " where IdRisposta = ?;");
       prepared.setInt(1,r.getId());
       prepared.execute();
  }  

  /**
   * Il metodo serve per recuperare le informazioni di una Risposta nel DataBase.
   * @param o: l'oggetto contenente le informazione della Risposta.
   * @throws SQLException 
   */
  @Override
  public boolean recuperaDati(Object o) throws SQLException {
    Risposta r = (Risposta) o;

    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from risposta where "
   		+ "IdRisposta = ?;");
    prepared.setInt(1,r.getId());
    ResultSet result = (ResultSet) prepared.executeQuery();
    while (result.next())
    {
      r.setTesto(result.getString("Contenuto"));
      r.setAllegato(result.getString("Allegato"));
      r.setVis(result.getString("Visualizzata"));
      r.setValutazione(result.getString("Valutazione"));
    }
    if(r.getTesto() != null) {return true;} 
    else {return false;}
  }
  
  /**
   * Il metodo serve per recuperare le informazioni di tutte le Risposte nel DataBase.
   * @return una lista di oggetti di tipo Risposta con tutte le informazioni reperite su DataBase per ognuna di esse.
   * @throws SQLException 
   */
  public ArrayList<Object> recuperaTutto() throws SQLException {
    ArrayList<Object> listaR = new ArrayList<>(); 
    
    Statement query = (Statement) con.createStatement();
    ResultSet result = (ResultSet) query.executeQuery("select * from risposta;");
    while (result.next())
    {
        Risposta r = new Risposta(0, null, null, null, null);
        r.setId(result.getInt("IdRisposta"));
        r.setTesto(result.getString("Contenuto"));
        r.setAllegato(result.getString("Allegato"));
        r.setValutazione(result.getString("Valutazione"));
        r.setVis(result.getString("Visualizzata"));
        listaR.add(r);
    }
    return listaR;
  }

}
