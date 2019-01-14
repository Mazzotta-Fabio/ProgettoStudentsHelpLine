package classicomuni;

/**
 * La classe Studente rappresenta un utente registrato come studente nel sistema Student's Help Line
 * Questa classe permette di gestire i dati dello studente
 * La classe permette di modificare e ottenere tutti i dati dello studente.
 * @author Fabio Mazzotta
 * @version 1.0
 */
public class Studente extends Utente {
  private String matricola;
  private String annoCorso;
  /**
   * Costruttore della classe.
   * @author Fabio Mazzotta
   * @version 1.0
   */
  
  public Studente(String nome, String cognome, String email, String password, 
      String linkImmagine, String matricola, String annoCorso) {
    super(nome, cognome, email, password, linkImmagine);
    this.matricola = matricola;
    this.annoCorso = annoCorso;
  }
  /**
   * Il metodo restituisce la matricola dello studente.
   * @return matricola dello studente
   */
  
  public String getMatricola() {
    return matricola;
  }
  /**
   * Il metodo serve per modificare la matricola dello studente.
   * @param matricola nuova matricola da inserire
   */
  
  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }
  /**
   * Il metodo restituisce l'anno di corso dello studente.
   * @return anno di corso
   */
  
  public String getAnnoCorso() {
    return annoCorso;
  }
  /**
   * Il metodo serve modificare l'anno di corso dello studente.
   * @param annoCorso nuovo anno di corso da inserire
   */
  
  public void setAnnoCorso(String annoCorso) {
    this.annoCorso = annoCorso;
  }
}
