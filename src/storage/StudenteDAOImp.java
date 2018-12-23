package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Studente;

public class StudenteDAOImp implements ObjectDAO {

  private Connection con;
  
  public StudenteDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  @Override
  public void inserisciDati(Object o) {
      Studente s = (Studente) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into studente(Nome,Cognome,Email,"
            + "Matricola,Password,AnnoCorso,Immagine) values (?,?,?,?,?,?,?);");
        prepared.setString(1, s.getNome());
        prepared.setString(2, s.getCognome());
        prepared.setString(3, s.getEmail());
        prepared.setString(4, s.getMatricola());
        prepared.setString(5, s.getPassword());
        prepared.setString(6, s.getAnnoCorso());
        prepared.setString(7, s.getLinkImmagine());
        prepared.executeUpdate();
      } 
      catch (SQLException e) {}
  }

  @Override
  public void cancellaDati(Object o) {
      Studente s = (Studente) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from studente"
            + " where Email = ?;");
        prepared.setString(1, s.getEmail());
        prepared.execute();
      } 
      catch (SQLException e) {}
  }  

  @Override
  public boolean recuperaDati(Object o) {
    Studente s = (Studente) o;
    String pass = s.getPassword();
    try 
    {
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
        s.setPassword(result.getString("Password"));
        if(s.getPassword().equals(pass)) {return true;}
      }
    } 
    catch (SQLException e) {}
    return false;
  }

  @Override
  public ArrayList<Object> recuperaTutto() {
    ArrayList<Object> listaS = new ArrayList<>(); 
    try {
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
          s.setPassword(result.getString("Password"));
          listaS.add(s);
        }
    } 
    catch (SQLException e) {} 
    return listaS;
  }

}
