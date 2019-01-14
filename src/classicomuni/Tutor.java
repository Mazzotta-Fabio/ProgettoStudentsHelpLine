package classicomuni;

/**
 * La classe Tutor rappresenta un utente registrato come tutor al sistema Student's Help Line.
 * Questa classe serve per gestire i dati del tutor.
 * Questa classe permette di ottenere e di modificare tutti dati personali del tutor
 * @author Fabio Mazzotta
 * @version 1.0
 */
public class Tutor extends Utente {
  private String numeroDiCellulare;
  private String materiaDiCompetenza;
  private String votoDiLaurea;
  private String titoloDiStudio;
  /**
   * Costruttore della classe.
   * @author Fabio Mazzotta
   * @version 1.0
   */
  
  public Tutor(String nome, String cognome, String email, String password, String linkImmagine,
          String numeroDiCellulare, String materiaDiCompetenza, String votoDiLaurea, 
          String titoloDiStudio) {
    super(nome, cognome, email, password, linkImmagine);
    this.numeroDiCellulare = numeroDiCellulare;
    this.materiaDiCompetenza = materiaDiCompetenza;
    this.votoDiLaurea = votoDiLaurea;
    this.titoloDiStudio = titoloDiStudio;
  }
  /**
   * Il metodo  restituisce il numero di cellulare di utente.
   * @return numero di cellulare del tutor
   */
  
  public String getNumeroDiCellulare() {
    return numeroDiCellulare;
  }
  /**
   * Il metodo serve per modificare il numero di cellulare del tutor.
   * @param numeroDiCellulare il numero di cellulare nuovo da inserire
   */
  
  public void setNumeroDiCellulare(String numeroDiCellulare) {
    this.numeroDiCellulare = numeroDiCellulare;
  }
  /**
   * Il metodo  restituisce la materia di competenza del tutor.
   * @return la materia di competenza del tutor
   */
  
  public String getMateriaDiCompetenza() {
    return materiaDiCompetenza;
  }
  /**
   *  Il metodo serve per modificare la materia di competenza del tutor.
   * @param materiaDiCompetenza la materia di competenza nuova da inserire
   */
  
  public void setMateriaDiCompetenza(String materiaDiCompetenza) {
    this.materiaDiCompetenza = materiaDiCompetenza;
  }
  /**
   * Il metodo  restituisce il voto di laurea del tutor.
   * @return voto di laurea del tutor
   */
  
  public String getVotoDiLaurea() {
    return votoDiLaurea;
  }
  /**
   *  Il metodo serve per modificare il voto di laurea del tutor.
   * @param votoDiLaurea voto di laurea nuovo da inserire
   */
  
  public void setVotoDiLaurea(String votoDiLaurea) {
    this.votoDiLaurea = votoDiLaurea;
  }
  /**
   * Il metodo  restituisce il titolo di studio del tutor.
   * @return titolo di studio del tutor
   */
  
  public String getTitoloDiStudio() {
    return titoloDiStudio;
  }
  /**
   *  Il metodo serve per modificare il titolo di studio del tutor.
   * @param titoloDiStudio titolo di studio nuovo da sostituire
   */
  
  public void setTitoloDiStudio(String titoloDiStudio) {
    this.titoloDiStudio = titoloDiStudio;
  }
}
