package classicomuni;

/**
 * La classe Domanda rappresenta una domanda generata da uno studente
 * Questa classe serve per gestire i dati di una domanda
 * Questa classe permette di ottenere e di modificare tutti dati di una domanda.
 * @author Fabio Mazzotta
 * @version 1.0
 */
public class Domanda {
  private int id;
  private String testo;
  private String oggetto;
  private String allegato;
  private Studente studente;
  private Tutor tutor;
  private Risposta risposta;
  private String visualizzazione;
  
  /**
   * Costruttore della classe.
   * @author Fabio Mazzotta
   * @version 1.0
   */
  public Domanda(int id,String testo, String oggetto, String allegato, Studente studente,
        Tutor tutor,Risposta risposta,String visualizzazione) {
    this.testo = testo;
    this.id = id;
    this.oggetto = oggetto;
    this.allegato = allegato;
    this.studente = studente;
    this.tutor = tutor;
    this.risposta = risposta;
    this.visualizzazione = visualizzazione;
  }
  /**
   * Il metodo  restituisce l'id di una domanda.
   * @return id di una domanda
   */
  
  public int getId() {
    return id;
  }
  /**
   * Il metodo consente di inserire l'id della domanda.
   * @param id l'id nuovo da inserire per la domanda
   */
  
  public void setId(int id) {
    this.id = id;
  }
  /**
   * Il metodo  restituisce il testo di una domanda.
   * @return testo di una domanda
   */
  
  public String getTesto() {
    return testo;
  }
  /**
   * Il metodo consente di inserire un testo alla domanda.
   * @param testo il testo nuovo da inserire per la domanda
   */
  
  public void setTesto(String testo) {
    this.testo = testo;
  }
  /**
   * Il metodo  restituisce l'oggetto di una domanda.
   * @return oggetto della domanda
   */
  
  public String getOggetto() {
    return oggetto;
  }
  
  /**
   * Il metodo consente di inserire un oggetto alla domanda.
   * @param oggetto l'oggetto nuovo da inserire per la domanda
   */
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  /**
   * Il metodo  restituisce il link dell'allegato della domanda.
   * @return il link dell'allegato della domanda
   */
   
  public String getAllegato() {
    return allegato;
  }
  /**
   * Il metodo consente di inserire un link per poter accedere all'allegato della domanda.
   * @param allegato il link nuovo da inserire per la domanda
   */
   
  public void setAllegato(String allegato) {
    this.allegato = allegato;
  }
  /**
   * Il metodo  restituisce il mittente ha inviato la domanda.
   * @return lo studente che ha inviato la domanda.
   */
  
  public Studente getStudente() {
    return studente;
  }
  /**
   * Il metodo consente di inserire un mittente per la domanda.
   * @param studente il mittente che fa la domanda
   */
  
  public void setStudente(Studente studente) {
    this.studente = studente;
  }
  /**
   * Il metodo  restituisce il destinatario della domanda.
   * @return il destinatario della domanda.
   */
  
  public Tutor getTutor() {
    return tutor;
  }

  /**
   * Il metodo consente di inserire un destinatario della domanda.
   * @param tutor il destinatario della domanda
   */
  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }

  /**
   * Il metodo  restituisce la risposta alla domanda.
   * @return la risposta alla domanda.
   */
  public Risposta getRisposta() {
    return risposta;
  }
  /**
   * Il metodo consente di inserire una risposta alla domanda.
   * @param risposta la risposta alla domanda
   */
  
  public void setRisposta(Risposta risposta) {
    this.risposta = risposta;
  }
  /**
   * Il metodo  restituisce se la domanda � stata visualizzata.
   * @return visualizzazione di una domanda
   */
  
  public String getVis() {
    return visualizzazione;
  }
  /**
   * Il metodo consente di inserire la visualizzazione della domanda.
   * @param visualizzazione visita della domanda
   */
  
  public void setVis(String visualizzazione) {
    this.visualizzazione = visualizzazione;
  }
}
