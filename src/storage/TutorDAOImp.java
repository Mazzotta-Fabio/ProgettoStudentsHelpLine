package storage;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import classiComuni.Tutor;

public class TutorDAOImp implements ObjectDAO {

  private Connection con;
  
  public TutorDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  @Override
  public void inserisciDati(Object o) {
      Tutor t = (Tutor) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into tutor (Email,Password,"
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
      catch (SQLException e) {}
  }

  @Override
  public void cancellaDati(Object o) {
      Tutor t = (Tutor) o;
      try {
        PreparedStatement prepared = (PreparedStatement) con.prepareStatement("delete from tutor"
            + " where Email = ?;");
        prepared.setString(1, t.getEmail());
        prepared.execute();
      } 
      catch (SQLException e) {}
  }  

  @Override
  public boolean recuperaDati(Object o) {
    Tutor t = (Tutor) o;
    String pass = t.getPassword();
    try 
    {
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
        t.setPassword(result.getString("Password"));
        t.setTitoloDiStudio(result.getString("TitoloDiStudio"));
        t.setVotoDiLaurea(result.getString("VotoDiLaurea"));
        if (t.getPassword().equals(pass)) {return true;}
      }
    } 
    catch (SQLException e) {}
    return false;
  }

  @Override
  public ArrayList<Object> recuperaTutto() {
    ArrayList<Object> listaT = new ArrayList<>(); 
    try {
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
          t.setPassword(result.getString("Password"));
          t.setTitoloDiStudio(result.getString("TitoloDiStudio"));
          t.setVotoDiLaurea(result.getString("VotoDiLaurea"));
          listaT.add(t);
        }
    } 
    catch (SQLException e) {} 
    return listaT;
  }

}

