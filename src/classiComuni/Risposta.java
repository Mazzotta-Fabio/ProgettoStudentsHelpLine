package classiComuni;

/**
 * La classe Risposta rappresenta una risposta fatta da un tutor per una domanda ricevuta
 * Questa classe permette di gestire i dati di una risposta
 * La classe permette di modificare e ottenere tutti i dati di una risposta
 * @author Fabio Mazzotta
 * @version 1.0
 */

public class Risposta {
	private int id;
	private String testo;
	private String allegato;
	private String valutazione;
	
	public Risposta(int id,String testo, String allegato,String valutazione) {
		this.testo = testo;
		this.allegato = allegato;
		this.id = id;
		this.valutazione = valutazione;
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

	/**
	 * Il metodo  restituisce l'id di una risposta
	 * @return id di una risposta
	 */
	public int getId() {
		return id;
	}


	/**
	 * Il metodo consente di inserire l'id alla risposta
	 * @param id: id da inserire per la risposta
	 */
	public void setId(int id) {
		this.id = id;
	}
}
