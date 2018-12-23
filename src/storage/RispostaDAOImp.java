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

public class RispostaDAOImp implements ObjectDAO {

  private Connection con;
  
  public RispostaDAOImp() {
    SingletonDataBase db = SingletonDataBase.getInstance();
    con = db.getConnessione();
  }
  
  @Override
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

  @Override
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

  @Override
  public boolean recuperaDati(Object o) {
    Risposta r = (Risposta) o;
    try 
    {
      PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from risposta where IdRisposta = ?;");
      prepared.setInt(1,r.getId());
      ResultSet result = (ResultSet) prepared.executeQuery();
      while (result.next())
      {
        Domanda d = new Domanda(0, null, null, null, null);
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

  @Override
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
