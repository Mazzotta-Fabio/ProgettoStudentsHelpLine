package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Studente;

/**
 * La classe StudenteDAOImp implementa i metodi dell'interfaccia ObjectDAO.
 * Questa classe permette di aggiungere, reperire e eliminare informazioni per gli Studenti su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
public class StudenteDAOImp implements ObjectDAO {

  private Connection con;
  
  public StudenteDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  /**
   * Il metodo serve per inserire le informazioni di uno Studente nel DataBase.
   * @param o: l'oggetto contenente le informazione dello Studente.
   * @throws SQLException 
   */
  @Override
  public void inserisciDati(Object o) throws SQLException {
    Studente s = (Studente) o;

    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into studente(Email,Pass,"
   		+ "Matricola,Immagine,AnnoCorso,Nome,Cognome) values (?,?,?,?,?,?,?);");
    prepared.setString(6, s.getNome());
    prepared.setString(7, s.getCognome());
    prepared.setString(1, s.getEmail());
    prepared.setString(3, s.getMatricola());
    prepared.setString(2, s.getPassword());
    prepared.setString(5, s.getAnnoCorso());
    prepared.setString(4, s.getLinkImmagine());
    prepared.executeUpdate();
  }

  /**
   * Il metodo serve per cancellare le informazioni di uno Studente nel DataBase.
   * @param o: l'oggetto contenente le informazione dello Studente.
   * @throws SQLException 
   */
  @Override
  public void cancellaDati(Object o) throws SQLException {
	  Studente s = (Studente) o;

	  PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from studente"
          + " where Email = ?;");
	  prepared.setString(1, s.getEmail());
	  prepared.execute();
  	}  

  /**
   * Il metodo serve per recuperare le informazioni di uno Studente nel DataBase.
   * @param o: l'oggetto contenente le informazione dello Studente.
   * @return true se lo Studente è presente sul DataBase, e la password corrisponde, altrimenti false.
   * @throws SQLException 
   */
  @Override
  public boolean recuperaDati(Object o) throws SQLException {
    Studente s = (Studente) o;
    String pass = s.getPassword();
    
    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from studente where Email = ?;");
    prepared.setString(1, s.getEmail());
    ResultSet result = (ResultSet) prepared.executeQuery();
    while (result.next())
    {
      s.setNome(result.getString("Nome"));
      s.setCognome(result.getString("Cognome"));
      s.setEmail(result.getString("Email"));
      s.setLinkImmagine(result.getString("Immagine"));
      s.setAnnoCorso(result.getString("AnnoCorso"));
      s.setMatricola(result.getString("Matricola"));
      s.setPassword(result.getString("Pass"));
      if(s.getPassword().equals(pass)) {return true;}
    }
    return false;
  }

  /**
   * Il metodo serve per recuperare le informazioni di tutti gli Studenti nel DataBase.
   * @return una lista di oggetti di tipo Studente con tutte le informazioni reperite su DataBase per ognuna di essi.
   * @throws SQLException 
   */
  @Override
  public ArrayList<Object> recuperaTutto() throws SQLException {
    ArrayList<Object> listaS = new ArrayList<>(); 
   
    Statement query = (Statement) con.createStatement();
    ResultSet result = (ResultSet) query.executeQuery("select * from studente;");
    while (result.next())
    {
        Studente s = new Studente(null, null, null, null, null, null, null);
        s.setNome(result.getString("Nome"));
        s.setCognome(result.getString("Cognome"));
        s.setEmail(result.getString("Email"));
        s.setLinkImmagine(result.getString("Immagine"));
        s.setAnnoCorso(result.getString("AnnoCorso"));
        s.setMatricola(result.getString("Matricola"));
        s.setPassword(result.getString("Pass"));
        listaS.add(s);
    }
    return listaS;
  }

}
