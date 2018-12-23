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
		if(tipo == null){
			return null;
	    } else if(tipo.equalsIgnoreCase("Studente")){
	    	return new StudenteDAOImp();
	    } else if(tipo.equalsIgnoreCase("Tutor")){
	        return new TutorDAOImp();
	    } else if(tipo.equalsIgnoreCase("Domanda")){
	        return new DomandaDAOImp();
	    } else if(tipo.equalsIgnoreCase("Risposta")){
		    return new RispostaDAOImp();
		} 
	    return null;
	}
}
