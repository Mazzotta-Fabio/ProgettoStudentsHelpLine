package storage;

import java.util.ArrayList;

public interface ObjectDAO {
  public void inserisciDati(Object o);
  public void cancellaDati(Object o);
  public boolean recuperaDati(Object o);
  public ArrayList<Object> recuperaTutto();
}
