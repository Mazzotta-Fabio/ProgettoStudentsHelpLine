package storage;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
  * La classe Singleton rappresenta il singleton che ci consente di connetterci con il database.
  * Questa classe serve per ottenere un istanza unica di connessione al database
  * @author Antonio Cimino
  * @version 1.0
  */
public class SingletonDataBase {
  private static Connection con;
  private static SingletonDataBase db = new SingletonDataBase();
    
  private SingletonDataBase() {
    con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://den1.mysql4.gear.host/studenthelpline";
      String username = "studenthelpline";
      String pwd = "st5d3nth3lpl1n3?";
      con = (Connection) DriverManager.getConnection(url,username,pwd);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * Il metodo consente di poter ottenere un istanza unica della classe.
   * @return db istanza della classe Singleton DataBase
   */
  
  public static SingletonDataBase getInstance() {
    return db;
  }
  /**
   * Il metodo consente di ottenere il driver per la connessione al database.
   * @return con driver per la connesione al database
   */
  
  public Connection getConnessione() {
    return con;
  }
}
