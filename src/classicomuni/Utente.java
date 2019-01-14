package classicomuni;

/**
 * La classe Utente rappresenta un utente registrato al sistema Student's Help Line.
 * Questa classe serve per gestire i dati dell'utente.
 * Questa classe permette di ottenere e di modificare tutti dati personali dell'utente
 * @author Fabio Mazzotta
 * @version 1.0
 */
public class Utente {
  private String nome;
  private String cognome;
  private String email;
  private String password;
  private String linkImmagine;
  /**
   *Il costruttore  della classe.
   * @author Fabio Mazzotta
   * @version 1.0
   */
  
  public Utente(String nome, String cognome, String email, String password, String linkImmagine) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
    this.linkImmagine = linkImmagine;
  }
  /**
   * Il metodo restituisce il nome di un utente.
   * @return nome dell'utente
   */
  
  public String getNome() {
    return nome;
  }
  /**
   * Il metodo serve per modificare il nome dell'utente.
   * @param nome il nuovo nome da sostituire con quello vecchio
   */
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  /**
   * Il metodo  restituisce il cognome di un utente.
   * @return cognome dell'utente
   */
  
  public String getCognome() {
    return cognome;
  }
  /**
   * Il metodo serve per modificare il cognome dell'utente.
   * @param cognome il nuovo cognome da sostituire con quello vecchio
   */
  
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }
  /**
   * Il metodo restituisce l'email di un utente.
   * @return email dell'utente
   */
  
  public String getEmail() {
    return email;
  }
  /**
   * Il metodo serve per modificare l'email dell'utente.
   * @param email la nuova email da sostituire con quella vecchia
   */
  
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * Il metodo restituisce la password di un utente.
   * @return password dell'utente
   */
  
  public String getPassword() {
    return password;
  }
  /**
   * Il metodo serve per modificare la password dell'utente.
   * @param password la nuova password da sostituire con quella vecchia
   */
  
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * Il metodo  restituisceil link dell'immagine del profilo di un utente.
   * @return link dell'immagine del profilo dell'utente
   */
  
  public String getLinkImmagine() {
    return linkImmagine;
  }
  /**
   * Il metodo serve per modificare il link dell'immagine del profilo dell'utente.
   * @param linkImmagine il nuovo link dell'immagine da sostituire con quella vecchia
   */
  
  public void setLinkImmagine(String linkImmagine) {
    this.linkImmagine = linkImmagine;
  }
}
