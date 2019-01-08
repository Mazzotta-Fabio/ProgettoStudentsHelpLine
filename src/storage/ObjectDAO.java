package storage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ObjectDAO {
  public void inserisciDati(Object o) throws SQLException;
  public void cancellaDati(Object o) throws SQLException;
  public boolean recuperaDati(Object o) throws SQLException;
  public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException;
  public void modificaDati(Object o) throws SQLException;
}
