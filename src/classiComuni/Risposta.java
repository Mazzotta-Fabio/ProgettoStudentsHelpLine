package classiComuni;

/**
 * La classe Risposta rappresenta una risposta fatta da un tutor per una domanda ricevuta
 * Questa classe permette di gestire i dati di una risposta
 * La classe permette di modificare e ottenere tutti i dati di una risposta
 * @author Fabio Mazzotta
 * @version 1.0
 */

public class Risposta {
	private String testo;
	private String allegato;
	private String valutazione;
	private Tutor tutor;
	private Domanda domanda;
	private int id;
	
	public Risposta(int id,String testo, String allegato,Tutor tutor, Domanda domanda) {
		this.testo = testo;
		this.allegato = allegato;
		this.tutor = tutor;
		this.domanda = domanda;
	  this.id = id;
	}
	
	/**
	 * Il metodo  restituisce il testo di una risposta
	 * @return testo di una risposta
	 */
	public String getTesto() {
		return testo;
	}
	
	/**
	 * Il metodo serve per modificare il testo di una risposta
	 * @param testo: il testo da inserire per la risposta
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	/**
	 * Il metodo  restituisce il link di un allegato della risposta
	 * @return link dell'allegato della risposta
	 */
	public String getAllegato() {
		return allegato;
	}
	
	/**
	 * Il metodo consente di inserire un nuovo link all'allegato della risposta 
	 * @param: allegato: link dell'allegato della risposta
	 */
	public void setAllegato(String allegato) {
		this.allegato = allegato;
	}
	
	/**
	 * Il metodo  restituisce il tutor che ha fatto la risposta
	 * @return tutor mittente della risposta
	 */
	public Tutor getTutor() {
		return tutor;
	}
	
	/** 
	 * Il metodo consente di inserire un mittente alla risposta 
	 * @param tutor: il tutor che ha fatto la risposta
	 */
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	/**
	 * Il metodo  restituisce la domanda per cui si è dato risposta
	 * @return domanda risposta
	 */
	public Domanda getDomanda() {
		return domanda;
	}
	
	/**
	 * Il metodo consente di associare alla risposta un domanda
	 * @param domanda: domanda per cui si risponde
	 */
	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}
	
	/**
	 * Il metodo  restituisce la valutazione ricevuta da uno studente per la risposta data
	 * @return valutazione di una risposta
	 */
	public String getValutazione() {
		return valutazione;
	}
	
	/**
	 * Il metodo consente di inserire una valutazione alla risposta
	 * @param valutazione: valutazione da inserire per la risposta
	 */
	public void setValutazione(String valutazione) {
		this.valutazione = valutazione;
	}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
