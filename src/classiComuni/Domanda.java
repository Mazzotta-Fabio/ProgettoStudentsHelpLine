package classiComuni;

/**
 * La classe Domanda rappresenta una domanda generata da uno studente
 * Questa classe serve per gestire i dati di una domanda
 * Questa classe permette di ottenere e di modificare tutti dati di una domanda
 * @author Fabio Mazzotta
 * @version 1.0
 */
public class Domanda {
	private String testo;
	private String oggetto;
	private String allegato;
	private int id;
	private Studente studente;
	
	public Domanda(int id,String testo, String oggetto, String allegato, Studente studente) {
		this.testo = testo;
		this.id = id;
		this.oggetto = oggetto;
		this.allegato = allegato;
		this.studente = studente;
	}
	
	
	public int getId() {
    return id;
  }
	
	
	public void setId(int id) {
	  this.id = id;
  }
	/**
	 * Il metodo  restituisce il testo di una domanda
	 * @return testo di una domanda
	 */
	public String getTesto() {
		return testo;
	}
	
	/**
	 * Il metodo consente di inserire un testo alla domanda.
	 * @param testo: il testo nuovo da inserire per la domanda.
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	/**
	 * Il metodo  restituisce l'oggetto di una domanda
	 * @return oggetto della domanda
	 */
	public String getOggetto() {
		return oggetto;
	}
	
	/**
	 * Il metodo consente di inserire un oggetto alla domanda.
	 * @param oggetto: l'oggetto nuovo da inserire per la domanda.
	 */
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	
	/**
	 * Il metodo  restituisce il link dell'allegato della domanda
	 * @return il link dell'allegato della domanda
	 */
	public String getAllegato() {
		return allegato;
	}
	
	/**
	 * Il metodo consente di inserire un link per poter accedere all'allegato della domanda
	 * @param allegato: il link nuovo da inserire per la domanda.
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
	 * Il metodo consente di inserire un mittente per la domanda
	 * @param studente: il mittente che fa la domanda
	 */
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
}
