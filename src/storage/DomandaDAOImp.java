package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;


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
   * @throws SQLException 
   */
  public void inserisciDati(Object o) throws SQLException {
      Domanda d = (Domanda) o;
      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into Domanda (Contenuto,Allegato,"
      		+ "Oggetto,Visualizzata,Studente,Tutor,Risposta) values (?,?,?,?,?,?,?);");
      prepared.setString(1, d.getTesto());
      prepared.setString(2, d.getAllegato());
      prepared.setString(3, d.getOggetto());
      prepared.setString(4, d.getVis());
      prepared.setString(5, d.getStudente().getEmail());
      prepared.setString(6, d.getTutor().getEmail());
      prepared.setInt(7, d.getRisposta().getId());
      prepared.executeUpdate();
  }

  /**
   * Il metodo serve per cancellare le informazioni di una Domanda nel DataBase.
   * @param o: l'oggetto contenente le informazione della Domanda.
   * @throws SQLException 
   */
  public void cancellaDati(Object o) throws SQLException {
  	Domanda d = (Domanda) o;
    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from domanda"
         + " where IdDomanda = ?;");
    prepared.setInt(1,d.getId());
    prepared.execute();
  }  

  /**
   * Il metodo serve per recuperare le informazioni di una Domanda nel DataBase.
   * @param o: l'oggetto contenente le informazione della Domanda.
   * @throws SQLException 
   */
  public boolean recuperaDati(Object o) throws SQLException {
    Domanda d = (Domanda) o;
    String testo=d.getTesto();

      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from domanda where IdDomanda = ?;");
      prepared.setInt(1,d.getId());
      ResultSet result = (ResultSet) prepared.executeQuery();
      while (result.next())
      {
        d.setTesto(result.getString("Contenuto"));
        d.setAllegato(result.getString("Allegato"));
        d.setOggetto(result.getString("Oggetto"));
        Studente s = new Studente(null, null, result.getString("Studente"), null, null, null, null);
		d.setStudente(s);
        Tutor t = new Tutor(null, null, result.getString("Tutor"), null, null, null, null, null, null);
		d.setTutor(t);
        Risposta r = new Risposta (Integer.parseInt(result.getString("Risposta")), null,null,null, null);
		d.setRisposta(r);
		 if(d.getTesto().equals(testo)) {return true;} 
      }
      return false;
  	}

  /**
   * Il metodo serve per recuperare le informazioni di tutte le Domande nel DataBase.
   * @return una lista di oggetti di tipo Domanda con tutte le informazioni reperite su DataBase per ognuna di esse.
   * @throws SQLException 
   * @throws NumberFormatException 
   */
  public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException {
  	ArrayList<Object> listaD = new ArrayList<>(); 

    Statement query = (Statement) con.createStatement();
    ResultSet result = (ResultSet) query.executeQuery("select * from domanda;");
    while (result.next())
    {
       	Domanda d = new Domanda (0, null, null, null, null, null, null, null);
       	d.setId(Integer.parseInt(result.getString("IdDomanda")));
       	d.setTesto(result.getString("Contenuto"));
        d.setAllegato(result.getString("Allegato"));
        d.setOggetto(result.getString("Oggetto"));
        Studente s = new Studente(null, null, result.getString("Studente"), null, null, null, null);
		d.setStudente(s);
        Tutor t = new Tutor(null, null, result.getString("Tutor"), null, null, null, null, null, null);
		d.setTutor(t);
        Risposta r = new Risposta (Integer.parseInt(result.getString("Risposta")), null,null,null, null);
		d.setRisposta(r);
		d.setVis(result.getString("Visualizzata"));
        listaD.add(d);
    }
    return listaD;
  }
  
}
