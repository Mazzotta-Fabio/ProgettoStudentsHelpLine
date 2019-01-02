package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Tutor;

/**
 * La classe TutorDAOImp implementa i metodi dell'interfaccia ObjectDAO.
 * Questa classe permette di aggiungere, reperire e eliminare informazioni per i Tutor su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
public class TutorDAOImp implements ObjectDAO {

  private Connection con;
  
  public TutorDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  /**
   * Il metodo serve per inserire le informazioni di un Tutor nel DataBase.
   * @param o: l'oggetto contenente le informazione del Tutor.
   * @throws SQLException 
   */
  @Override
  public void inserisciDati(Object o) throws SQLException {
      Tutor t = (Tutor) o;

      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into tutor (Email,Pass,"
          + "Immagine,TitoloDiStudio,MateriaDiCompetenza,Nome,Cognome,VotoDiLaurea,NumeroDiCellulare) "
          + "values (?,?,?,?,?,?,?,?,?);"); 
            
      prepared.setString(1, t.getEmail());
      prepared.setString(2, t.getPassword());
      prepared.setString(3, t.getLinkImmagine());
      prepared.setString(4, t.getTitoloDiStudio());
      prepared.setString(5, t.getMateriaDiCompetenza());
      prepared.setString(6, t.getNome());
      prepared.setString(7, t.getCognome());
      prepared.setString(8, t.getVotoDiLaurea());
      prepared.setString(9, t.getNumeroDiCellulare());
      prepared.executeUpdate();
  	}

  /**
   * Il metodo serve per cancellare le informazioni di un Tutor nel DataBase.
   * @param o: l'oggetto contenente le informazione dell Tutor.
   * @throws SQLException 
   */
  @Override
  public void cancellaDati(Object o) throws SQLException {
      Tutor t = (Tutor) o;
      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from tutor"
          + " where Email = ?;");
      prepared.setString(1, t.getEmail());
      prepared.execute();
  }  

  /**
   * Il metodo serve per recuperare le informazioni di un Tutor nel DataBase.
   * @param o: l'oggetto contenente le informazione del Tutor.
   * @return true se il Tutor è presente sul DataBase, e la password corrisponde, altrimenti false.
   * @throws SQLException 
   */
  @Override
  public boolean recuperaDati(Object o) throws SQLException {
    Tutor t = (Tutor) o;
    String pass = t.getPassword();

    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from tutor where Email = ?;");
    prepared.setString(1, t.getEmail());
    ResultSet result = (ResultSet) prepared.executeQuery();
    while (result.next())
    {
      t.setNome(result.getString("Nome"));
      t.setCognome(result.getString("Cognome"));
      t.setEmail(result.getString("Email"));
      t.setLinkImmagine(result.getString("Immagine"));
      t.setMateriaDiCompetenza(result.getString("MateriaDiCompetenza"));
      t.setNumeroDiCellulare(result.getString("NumeroDiCellulare"));
      t.setPassword(result.getString("Pass"));
      t.setTitoloDiStudio(result.getString("TitoloDiStudio"));
      t.setVotoDiLaurea(result.getString("VotoDiLaurea"));
      if (t.getPassword().equals(pass)) {return true;}
    }
    return false;
  }

  /**
   * Il metodo serve per recuperare le informazioni di tutte dei Tutor nel DataBase.
   * @return una lista di oggetti di tipo Tutor con tutte le informazioni reperite su DataBase per ognuna di essi.
   * @throws SQLException 
   */
  @Override
  public ArrayList<Object> recuperaTutto() throws SQLException {
    ArrayList<Object> listaT = new ArrayList<>(); 

    Statement query = (Statement) con.createStatement();
    ResultSet result = (ResultSet) query.executeQuery("select * from tutor;");
    while (result.next())
    {
        Tutor t = new Tutor(null, null, null, null, null, null, null, null, null);
        t.setNome(result.getString("Nome"));
        System.out.print(result.getString("Nome"));
        t.setCognome(result.getString("Cognome"));
        t.setEmail(result.getString("Email"));
        t.setLinkImmagine(result.getString("Immagine"));
        t.setMateriaDiCompetenza(result.getString("MateriaDiCompetenza"));
        t.setNumeroDiCellulare(result.getString("NumeroDiCellulare"));
        t.setPassword(result.getString("Pass"));
        t.setTitoloDiStudio(result.getString("TitoloDiStudio"));
        t.setVotoDiLaurea(result.getString("VotoDiLaurea"));
        listaT.add(t);
    }
    return listaT;
  }

}

