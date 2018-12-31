package storage;

/**
 * La classe FactoryDAO costruisce un oggetto di tipo ObjectDAO.
 * Questa classe permette di creare un oggetto di tipo ObjectDAO specificando quale tipo di DAO è in particolare.
 * @author Antonio Cimino
 * @version 1.0
 */
public class FactoryDAO {
	 /**
	  * Il metodo serve per costruire un oggetto DAO di una particolare tipologia.
	  * @return restituisce un oggetto DAO.
	  */
	public ObjectDAO getObject(String tipo){
		ObjectDAO o = null;
		switch (tipo) {
			case "Studente" :
				o = new StudenteDAOImp();
				break;
			case "Tutor" : 
				o = new TutorDAOImp();
				break;
			case "Domanda" : 
				o =  new DomandaDAOImp();
				break;
			case "Risposta" : 
				o = new RispostaDAOImp();
				break;
		}
		return o;
	}
}